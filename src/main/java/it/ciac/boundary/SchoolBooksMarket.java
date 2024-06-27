package it.ciac.boundary;

import it.ciac.entity.Book;
import it.ciac.entity.BookCondition;
import it.ciac.entity.ClassBook;
import it.ciac.entity.Log;
import it.ciac.entity.LogAction;
import it.ciac.entity.PostedBook;
import it.ciac.entity.SchoolClass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import it.ciac.control.Store;
import it.ciac.entity.User;
import jakarta.persistence.NoResultException;

public class SchoolBooksMarket {
    private static User currentSession = null;

    public static User logIn(String email, String password) {
        requireNoSession();
        User foundUser = findUser(email, password);
        setCurrentSession(foundUser);
        return foundUser;
    }

    public static User logOut() {
        requireSession();
        User previousSession = currentSession;
        currentSession = null;
        return previousSession;
    }

    public static User signUp(String name, String surname, String email, String password, String confirmPassword,
            String tel, boolean admin) {
        if (!Objects.equals(password, confirmPassword))
            throw new OperationException("Password does not match password confirmation");
        User newUser = Store.saveEntity(new User(name, surname, email, password, tel, admin));
        LogAction action = getEntityOrThrow(LogAction.class, LogAction.CREATION);
        Store.saveEntity(new Log(action, newUser, currentSession == null ? newUser : currentSession));
        return newUser;
    }

    public static SchoolClass createClass(String className) {
        requireAdmin();
        return Store.saveEntity(new SchoolClass(className));
    }

    public static Book createBook(String title, String author, String pubHouse, String version, BigDecimal stdPrice) {
        requireAdmin();
        Book newBook = new Book(title, author, pubHouse, version, stdPrice);
        if (Store.isBookDuplicate(newBook)) {
            throw new OperationException("The book is identical to an already existing one");
        }
        return Store.saveEntity(newBook);
    }

    public static List<ClassBook> assignBooksToClass(long classId, List<Long> bookIds, boolean optional) {
        requireAdmin();
        SchoolClass sClass = findClass(classId);
        List<Book> booksInThisClass = new ArrayList<>();
        getClassBooksByClassId(classId).forEach(cb -> booksInThisClass.add(cb.getBook()));

        List<Book> booksToAssign = new ArrayList<>();
        // List<Book> duplicateBooks = new ArrayList<>();
        for (long id : bookIds) {
            Book b = findBook(id);
            if (!booksInThisClass.contains(b))
                booksToAssign.add(b);
            // else
            // duplicateBooks.add(b);
        }

        List<ClassBook> classBooks = new ArrayList<>();
        booksToAssign.forEach(book -> classBooks.add(new ClassBook(sClass, book, optional)));
        // here we could throw a custom exception that provides a getDuplicates() method
        return Store.saveEntities(classBooks);
    }

    public static User activateAccount(long id) {
        return manageAccount(id, true, "enabled", LogAction.ACTIVATION);
    }

    public static User suspendAccount(long id) {
        return manageAccount(id, false, "disabled", LogAction.SUSPENSION);
    }

    public static User banAccount(long id) {
        return manageAccount(id, null, "banned", LogAction.BAN);
    }

    public static SchoolClass findClass(long id) {
        requireSession();
        return getEntityOrThrow(SchoolClass.class, id);
    }

    public static Book findBook(long id) {
        requireSession();
        return getEntityOrThrow(Book.class, id);
    }

    private static User findUser(String email, String password) {
        try {
            return Store.findUserByCredentials(email, password);
        } catch (NoResultException e) {
            throw new SessionException("Could not find a user with the given credentials");
        }
    }

    public static List<SchoolClass> getAllClasses() {
        requireSession();
        return Store.getAllEntities(SchoolClass.class);
    }

    public static List<Book> getAllBooks() {
        requireSession();
        return Store.getAllEntities(Book.class);
    }

    public static List<User> getAllUsers() {
        requireAdmin();
        return Store.getAllEntities(User.class);
    }

    public static List<Log> getAllLogs() {
        requireAdmin();
        return Store.getAllEntities(Log.class);
    }

    public static List<BookCondition> getBookConditions() {
        requireSession();
        return Store.getAllEntities(BookCondition.class);
    }

    public static List<ClassBook> getClassBooksByClassId(long id) {
        requireSession();
        return Store.getClassBooksByClassId(id);
    }

    public static List<PostedBook> getPostedBooksByClassBookId(long id) {
        requireSession();
        Book book = getEntityOrThrow(ClassBook.class, id).getBook();
        return Store.getPostedBooksByBookId(book.getId());
    }

    public static List<PostedBook> getOwnPostedBooks() {
        requireSession();
        return Store.getPostedBooksByUserId(currentSession.getId());
    }

    public static PostedBook postBook(long bookId, String bookCondition, String comment, BigDecimal price) {
        requireSession();
        Book book = getEntityOrThrow(Book.class, bookId);
        BookCondition condition = getEntityOrThrow(BookCondition.class, bookCondition);
        return Store.saveEntity(new PostedBook(book, currentSession, condition, comment, price, true));
    }

    public static PostedBook removeBook(long postedBookId) {
        requireSession();
        PostedBook book = getEntityOrThrow(PostedBook.class, postedBookId);
        if (book.getPostedBy() != currentSession && !currentSession.isAdmin())
            throw new OperationException(
                    "Cannot perform this action because the book was not posted by the current account, which lacks admin privileges");
        if (!book.isAvailable())
            throw new OperationException("The book is already marked as unavailable");
        book.setAvailable(false);
        return Store.saveEntity(book);
    }

    private static void requireSession() {
        if (currentSession == null)
            throw new SessionException("There is no session currently active");
    }

    private static void requireNoSession() {
        if (currentSession != null)
            throw new SessionException("There is already an active session");
    }

    private static void requireAdmin() {
        requireSession();
        if (!currentSession.isAdmin())
            throw new PermissionException("Cannot perform this action because the account lacks admin privileges");
    }

    private static void setCurrentSession(User user) {
        if (user.isActivated() == null)
            throw new SessionException("Cannot connect to the account because it has been banned");
        if (user.isActivated() == false)
            throw new SessionException("Cannot connect to the account because it is currently pending activation");
        currentSession = user;
    }

    private static User manageAccount(long id, Boolean state, String status, String logAction) {
        requireAdmin();
        if (id == 1)
            throw new OperationException("The root admin account cannot be modified");
        else if (id == currentSession.getId())
            throw new OperationException("You cannot modify your own account");
        User account = getEntityOrThrow(User.class, id);
        if (account.isActivated() == state)
            throw new OperationException("The account is already " + status);
        account.setActivated(state);
        account = Store.saveEntity(account);
        LogAction action = getEntityOrThrow(LogAction.class, logAction);
        Store.saveEntity(new Log(action, account, currentSession));
        return account;
    }

    private static <E> E getEntityOrThrow(Class<E> entityClass, Object id) {
        return Store.findEntityByPrimaryKey(entityClass, id)
                .orElseThrow(() -> new OperationException(
                        String.format("Could not find a %s with ID: %s", entityClass.getSimpleName(), id)));
    }
}
