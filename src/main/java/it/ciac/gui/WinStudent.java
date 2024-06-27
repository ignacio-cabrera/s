package it.ciac.gui;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import it.ciac.boundary.SchoolBooksMarket;
import it.ciac.entity.Book;
import it.ciac.entity.BookCondition;
import it.ciac.entity.ClassBook;
import it.ciac.entity.PostedBook;
import it.ciac.entity.SchoolClass;
import it.ciac.entity.User;
import jakarta.validation.ConstraintViolationException;

public class WinStudent extends javax.swing.JFrame {

        private static User thisUser;
        private ArrayList<Long> tbClassIDs = new ArrayList<>();
        private ArrayList<Long> classBookIDs = new ArrayList<>();
        private ArrayList<Long> postedBookIDs = new ArrayList<>();
        private ArrayList<Long> cbClassIDs = new ArrayList<>();
        private ArrayList<Long> bookIDs = new ArrayList<>();
        private ArrayList<String> descriptions = new ArrayList<>();
        private ArrayList<Long> ownPostedBookIDs = new ArrayList<>();

        public WinStudent(User user) {
                initComponents();
                this.setLocationRelativeTo(null);
                addEventListeners();
                thisUser = user;
                lbFullName.setText(thisUser.getFullName());
                refreshClasses();
                refreshConditions();
                refreshOwnPostedBooks();
        }

        @SuppressWarnings({ "unchecked", "rawtypes" })
        private void initComponents() {

                btLogOut = new javax.swing.JButton();
                lbStudent = new javax.swing.JLabel();
                lbFullName = new javax.swing.JLabel();
                lbBrowseBooks = new javax.swing.JLabel();
                scrClasses = new javax.swing.JScrollPane();
                tbClasses = new javax.swing.JTable();
                scrClassBooks = new javax.swing.JScrollPane();
                tbClassBooks = new javax.swing.JTable();
                scrPostedBooks = new javax.swing.JScrollPane();
                tbPostedBooks = new javax.swing.JTable();
                lbOwnPostedBooks = new javax.swing.JLabel();
                lbClass = new javax.swing.JLabel();
                cbClass = new javax.swing.JComboBox<>();
                lbBook = new javax.swing.JLabel();
                cbBook = new javax.swing.JComboBox<>();
                lbCondition = new javax.swing.JLabel();
                cbCondition = new javax.swing.JComboBox<>();
                lbPrice = new javax.swing.JLabel();
                txPrice = new javax.swing.JTextField();
                lbComment = new javax.swing.JLabel();
                txComment = new javax.swing.JTextField();
                btAddPostedBook = new javax.swing.JButton();
                scrOwnPostedBooks = new javax.swing.JScrollPane();
                tbOwnPostedBooks = new javax.swing.JTable();
                btRemovePostedBook = new javax.swing.JButton();
                tgbtHideRemoved = new javax.swing.JToggleButton();
                lbFeedback = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                btLogOut.setText("Log out");

                lbStudent.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
                lbStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbStudent.setText("Student");

                lbFullName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                lbFullName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

                lbBrowseBooks.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                lbBrowseBooks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbBrowseBooks.setText("Browse books");

                tbClasses.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Classes"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                tbClasses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                tbClasses.getTableHeader().setReorderingAllowed(false);
                scrClasses.setViewportView(tbClasses);
                if (tbClasses.getColumnModel().getColumnCount() > 0) {
                        tbClasses.getColumnModel().getColumn(0).setResizable(false);
                }

                tbClassBooks.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Title", "Author", "Pub. house", "Std. price"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.Object.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                tbClassBooks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                tbClassBooks.getTableHeader().setReorderingAllowed(false);
                scrClassBooks.setViewportView(tbClassBooks);

                tbPostedBooks.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Book", "Condition", "Price", "Student", "Email"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.Object.class,
                                        java.lang.String.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                tbPostedBooks.getTableHeader().setReorderingAllowed(false);
                scrPostedBooks.setViewportView(tbPostedBooks);

                lbOwnPostedBooks.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                lbOwnPostedBooks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbOwnPostedBooks.setText("Your posted books");

                lbClass.setText("Class:");

                lbBook.setText("Book:");

                lbCondition.setText("Condition:");

                lbPrice.setText("Price:");

                lbComment.setText("Comment:");

                btAddPostedBook.setText("Add");

                tbOwnPostedBooks.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Book", "Condition", "Price", "Available"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.Object.class,
                                        java.lang.String.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                tbOwnPostedBooks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                tbOwnPostedBooks.getTableHeader().setReorderingAllowed(false);
                scrOwnPostedBooks.setViewportView(tbOwnPostedBooks);

                btRemovePostedBook.setText("Remove");

                tgbtHideRemoved.setText("Hide removed");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(btLogOut)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(32, 32, 32)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(scrPostedBooks)
                                                                                                                .addComponent(lbFullName,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(lbBrowseBooks,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(lbStudent,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(lbOwnPostedBooks,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                layout.createSequentialGroup()
                                                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                                                false)
                                                                                                                                                                                                .addComponent(lbCondition,
                                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                .addComponent(lbBook,
                                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                .addComponent(lbComment,
                                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                .addComponent(lbClass,
                                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                .addComponent(lbPrice,
                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                                                                .addComponent(cbCondition,
                                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                                0,
                                                                                                                                                                                                                250,
                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                .addComponent(txPrice,
                                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                250,
                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                .addComponent(txComment,
                                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                250,
                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                .addComponent(cbClass,
                                                                                                                                                                                                                0,
                                                                                                                                                                                                                250,
                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                .addComponent(cbBook,
                                                                                                                                                                                                                0,
                                                                                                                                                                                                                250,
                                                                                                                                                                                                                Short.MAX_VALUE)))
                                                                                                                                                .addComponent(btAddPostedBook,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                319,
                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(scrOwnPostedBooks,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                349,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addComponent(btRemovePostedBook,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                                                .addComponent(tgbtHideRemoved,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE))))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(scrClasses,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                169,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(scrClassBooks,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                499,
                                                                                                                                                Short.MAX_VALUE))
                                                                                                                .addComponent(lbFeedback,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))))
                                                                .addGap(32, 32, 32)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addComponent(btLogOut)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbStudent)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbFullName,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lbBrowseBooks)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(scrClasses,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                0, Short.MAX_VALUE)
                                                                                .addComponent(scrClassBooks,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                140, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(scrPostedBooks,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                151, Short.MAX_VALUE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lbOwnPostedBooks)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(lbClass)
                                                                                                                .addComponent(cbClass,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(lbBook)
                                                                                                                .addComponent(cbBook,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(lbCondition)
                                                                                                                .addComponent(cbCondition,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(lbPrice)
                                                                                                                .addComponent(txPrice,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(lbComment)
                                                                                                                .addComponent(txComment,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addComponent(scrOwnPostedBooks,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                0, Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btAddPostedBook)
                                                                                .addComponent(btRemovePostedBook)
                                                                                .addComponent(tgbtHideRemoved))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lbFeedback,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                16,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(32, 32, 32)));

                pack();
        }

        private void addEventListeners() {
                btLogOut.addActionListener(this::logOut);
                tbClasses.getSelectionModel().addListSelectionListener(this::handleClassSelection);
                tbClassBooks.getSelectionModel().addListSelectionListener(this::handleClassBookSelection);
                cbClass.addActionListener(this::refreshBooks);
                cbCondition.addActionListener(this::setToolTip);
                btAddPostedBook.addActionListener(this::postBook);
                btRemovePostedBook.addActionListener(this::removeBook);
                tgbtHideRemoved.addActionListener(evt -> refreshOwnPostedBooks());
        };

        private void logOut(ActionEvent evt) {
                SchoolBooksMarket.logOut();
                this.dispose();
                new WinMain().setVisible(true);
        }

        private void postBook(ActionEvent evt) {
                int bookIdx = cbBook.getSelectedIndex();
                String text = txComment.getText();

                String condition = cbCondition.getSelectedItem().toString();
                String comment = text == null || text.isBlank() ? null : text;
                BigDecimal price;

                try {
                        if (bookIdx == -1)
                                throw new NoSelectionException("There is no book selected");
                        price = new BigDecimal(txPrice.getText());
                        SchoolBooksMarket.postBook(bookIDs.get(bookIdx), condition, comment, price);
                        refreshOwnPostedBooks();
                        refreshPostedBooks();
                } catch (NumberFormatException e) {
                        lbFeedback.setText("Price field is not a valid decimal");
                } catch (ConstraintViolationException cve) {
                        String msg = cve.getConstraintViolations().stream().findFirst().get().getMessageTemplate();
                        lbFeedback.setText(msg);
                } catch (Exception e) {
                        lbFeedback.setText(e.getMessage());
                }
        }

        private void removeBook(ActionEvent evt) {
                int postedBookIdx = tbOwnPostedBooks.getSelectedRow();

                try {
                        if (postedBookIdx == -1)
                                throw new NoSelectionException("There is no posted book selected");
                        SchoolBooksMarket.removeBook(ownPostedBookIDs.get(postedBookIdx));
                        refreshOwnPostedBooks();
                        refreshPostedBooks();
                } catch (Exception e) {
                        lbFeedback.setText(e.getMessage());
                }
        }

        private void refreshClasses() {
                List<SchoolClass> classes = new ArrayList<>();
                try {
                        classes = SchoolBooksMarket.getAllClasses();
                } catch (Exception e) {
                        lbFeedback.setText("Unable to load classes");
                } finally {
                        DefaultTableModel model = WinMain.clearTable(tbClasses);
                        tbClassIDs.clear();
                        for (SchoolClass c : classes) {
                                model.addRow(generateRow(c));
                                cbClass.addItem(generateItem(c));
                        }
                        tbClasses.setModel(model);
                }
        }

        private void refreshClassBooks() {
                int classIdx = tbClasses.getSelectedRow();
                List<ClassBook> classBooks = new ArrayList<>();

                try {
                        if (classIdx == -1)
                                throw new NoSelectionException();
                        long cID = tbClassIDs.get(classIdx);
                        classBooks = SchoolBooksMarket.getClassBooksByClassId(cID);
                } catch (NoSelectionException e) {
                } catch (Exception e) {
                        lbFeedback.setText("Unable to load classbooks");
                } finally {
                        DefaultTableModel model = WinMain.clearTable(tbClassBooks);
                        classBookIDs.clear();
                        classBooks.forEach(cb -> model.addRow(generateRow(cb)));
                        tbClassBooks.setModel(model);
                }
        }

        private void refreshPostedBooks() {
                int classBookIdx = tbClassBooks.getSelectedRow();
                List<PostedBook> postedBooks = new ArrayList<>();

                try {
                        if (classBookIdx == -1)
                                throw new NoSelectionException();
                        long cbID = classBookIDs.get(classBookIdx);
                        postedBooks = SchoolBooksMarket.getPostedBooksByClassBookId(cbID);
                } catch (NoSelectionException e) {
                } catch (Exception e) {
                        lbFeedback.setText("Unable to load posted books");
                } finally {
                        DefaultTableModel model = WinMain.clearTable(tbPostedBooks);
                        postedBookIDs.clear();
                        for (PostedBook pb : postedBooks) {
                                if (pb.isAvailable())
                                        model.addRow(generateRow(pb));
                        }
                        tbPostedBooks.setModel(model);
                }
        }

        private void refreshBooks(ActionEvent evt) {
                int classIdx = cbClass.getSelectedIndex();
                List<ClassBook> classBooks = new ArrayList<>();

                try {
                        if (classIdx == -1)
                                throw new NoSelectionException();
                        long cID = tbClassIDs.get(classIdx);
                        classBooks = SchoolBooksMarket.getClassBooksByClassId(cID);
                } catch (NoSelectionException e) {
                } catch (Exception e) {
                        lbFeedback.setText("Unable to load books");
                } finally {
                        cbBook.removeAllItems();
                        bookIDs.clear();
                        classBooks.forEach(cb -> cbBook.addItem(generateItem(cb.getBook())));
                }
        }

        private void refreshConditions() {
                List<BookCondition> bookConditions = new ArrayList<>();

                try {
                        bookConditions = SchoolBooksMarket.getBookConditions();
                } catch (Exception e) {
                        lbFeedback.setText("Unable to load book conditions");
                } finally {
                        cbCondition.removeAllItems();
                        descriptions.clear();
                        bookConditions.forEach(bc -> cbCondition.addItem(generateItem(bc)));
                }
        }

        private void refreshOwnPostedBooks() {
                List<PostedBook> ownPostedBooks = new ArrayList<>();

                try {
                        ownPostedBooks = SchoolBooksMarket.getOwnPostedBooks();
                } catch (Exception e) {
                        lbFeedback.setText("Unable to load own posted books");
                } finally {
                        DefaultTableModel model = WinMain.clearTable(tbOwnPostedBooks);
                        ownPostedBookIDs.clear();
                        tgbtHideRemoved.isSelected();
                        for (PostedBook opb : ownPostedBooks) {
                                if (tgbtHideRemoved.isSelected() && !opb.isAvailable())
                                        continue;
                                model.addRow(generateOPBRow(opb));
                        }
                        tbOwnPostedBooks.setModel(model);
                }
        }

        private String[] generateRow(SchoolClass c) {
                tbClassIDs.add(c.getId());
                return new String[] { c.getClassName() };
        }

        private Object[] generateRow(ClassBook cb) {
                classBookIDs.add(cb.getId());
                Book b = cb.getBook();
                Object[] row = new Object[4];
                row[0] = b.getTitle();
                row[1] = b.getAuthor();
                row[2] = b.getPubHouse();
                row[3] = b.getStdPrice() == null ? "---" : b.getStdPrice();
                return row;
        }

        private Object[] generateRow(PostedBook pb) {
                postedBookIDs.add(pb.getId());
                Object[] row = new Object[5];
                row[0] = pb.getBook().getTitle();
                row[1] = pb.getBookCondition().getCondition();
                row[2] = pb.getPrice();
                row[3] = pb.getPostedBy().getFullName();
                row[4] = pb.getPostedBy().getEmail();
                return row;
        }

        private Object[] generateOPBRow(PostedBook pb) {
                ownPostedBookIDs.add(pb.getId());
                Object[] row = new Object[4];
                row[0] = pb.getBook().getTitle();
                row[1] = pb.getBookCondition().getCondition();
                row[2] = pb.getPrice();
                row[3] = pb.isAvailable() ? "Yes" : "No";
                return row;
        }

        private String generateItem(SchoolClass c) {
                cbClassIDs.add(c.getId());
                return c.getClassName();
        }

        private String generateItem(Book b) {
                bookIDs.add(b.getId());
                return b.getTitle();
        }

        private String generateItem(BookCondition bc) {
                descriptions.add(bc.getDescription());
                return bc.getCondition();
        }

        private void handleClassSelection(ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting())
                        refreshClassBooks();
        }

        private void handleClassBookSelection(ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting())
                        refreshPostedBooks();
        }

        private void setToolTip(ActionEvent evt) {
                int idx = cbCondition.getSelectedIndex();
                String description = idx == -1 ? null : descriptions.get(idx);
                cbCondition.setToolTipText(description);
        }

        private javax.swing.JButton btAddPostedBook;
        private javax.swing.JButton btLogOut;
        private javax.swing.JButton btRemovePostedBook;
        private javax.swing.JComboBox<String> cbBook;
        private javax.swing.JComboBox<String> cbClass;
        private javax.swing.JComboBox<String> cbCondition;
        private javax.swing.JLabel lbBook;
        private javax.swing.JLabel lbBrowseBooks;
        private javax.swing.JLabel lbClass;
        private javax.swing.JLabel lbComment;
        private javax.swing.JLabel lbCondition;
        private javax.swing.JLabel lbFeedback;
        private javax.swing.JLabel lbFullName;
        private javax.swing.JLabel lbOwnPostedBooks;
        private javax.swing.JLabel lbPrice;
        private javax.swing.JLabel lbStudent;
        private javax.swing.JScrollPane scrClassBooks;
        private javax.swing.JScrollPane scrClasses;
        private javax.swing.JScrollPane scrOwnPostedBooks;
        private javax.swing.JScrollPane scrPostedBooks;
        private javax.swing.JTable tbClassBooks;
        private javax.swing.JTable tbClasses;
        private javax.swing.JTable tbOwnPostedBooks;
        private javax.swing.JTable tbPostedBooks;
        private javax.swing.JToggleButton tgbtHideRemoved;
        private javax.swing.JTextField txComment;
        private javax.swing.JTextField txPrice;
}