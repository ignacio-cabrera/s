package it.ciac.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import it.ciac.entity.Book;
import it.ciac.entity.ClassBook;
import it.ciac.entity.PostedBook;
import it.ciac.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.validation.ConstraintViolationException;

public class Store {
    private static EntityManager em;

    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-books-market");
        em = emf.createEntityManager();
    }

    public static User findUserByCredentials(String email, String pwd) {
        return em.createQuery("SELECT u FROM User u WHERE u.email LIKE :email AND u.password LIKE :pwd", User.class)
                .setParameter("email", email)
                .setParameter("pwd", pwd)
                .getSingleResult();
    }

    public static boolean isBookDuplicate(Book book) {
        return !em.createQuery(
                "SELECT b FROM Book b WHERE b.title LIKE :title AND b.author LIKE :author AND b.pubHouse LIKE :pubHouse AND ((b.version IS NULL AND :version IS NULL) OR b.version LIKE :version)")
                .setParameter("title", book.getTitle())
                .setParameter("author", book.getAuthor())
                .setParameter("pubHouse", book.getPubHouse())
                .setParameter("version", book.getVersion())
                .getResultList()
                .isEmpty();
    }

    public static List<ClassBook> getClassBooksByClassId(long id) {
        return em.createQuery("SELECT cb FROM ClassBook cb WHERE cb.assignedTo.id = :id", ClassBook.class)
                .setParameter("id", id)
                .getResultList();
    }

    public static List<PostedBook> getPostedBooksByBookId(long id) {
        return em.createQuery("SELECT pb FROM PostedBook pb WHERE pb.book.id = :id", PostedBook.class)
                .setParameter("id", id)
                .getResultList();
    }

    public static List<PostedBook> getPostedBooksByUserId(long id) {
        return em.createQuery("SELECT pb FROM PostedBook pb WHERE pb.postedBy.id = :id", PostedBook.class)
                .setParameter("id", id)
                .getResultList();
    }

    public static <E> Optional<E> findEntityByPrimaryKey(Class<E> entityClass, Object pk) {
        E found = em.find(entityClass, pk);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    public static <E> List<E> getAllEntities(Class<E> entityClass) {
        String query = String.format("SELECT e FROM %s e", entityClass.getSimpleName());
        return em.createQuery(query, entityClass)
                .getResultList();
    }

    public static <E> E saveEntity(E entity) {
        try {
            em.getTransaction().begin();
            E saved = em.merge(entity);
            em.getTransaction().commit();
            return saved;
        } catch (ConstraintViolationException e) {
            em.getTransaction().rollback();
            throw new StoreException(e.getConstraintViolations().stream().findFirst().get().getMessageTemplate());
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new StoreException(e.getMessage());
        }
    }

    public static <E> List<E> saveEntities(List<E> entities) {
        List<E> saved = new ArrayList<>();
        try {
            em.getTransaction().begin();
            entities.forEach(e -> saved.add(em.merge(e)));
            em.getTransaction().commit();
            return saved;
        } catch (ConstraintViolationException e) {
            em.getTransaction().rollback();
            throw new StoreException(e.getConstraintViolations().stream().findFirst().get().getMessageTemplate());
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new StoreException(e.getMessage());
        }
    }
}
