package it.ciac.gui;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import it.ciac.boundary.SchoolBooksMarket;
import it.ciac.entity.Book;
import it.ciac.entity.ClassBook;
import it.ciac.entity.Log;
import it.ciac.entity.SchoolClass;
import it.ciac.entity.User;
import jakarta.validation.ConstraintViolationException;

public class WinAdmin extends javax.swing.JFrame {

        private static User thisUser;
        private ArrayList<Long> classIDs = new ArrayList<>();
        private ArrayList<Long> bookIDs = new ArrayList<>();
        private ArrayList<Long> classBookIDs = new ArrayList<>();
        private ArrayList<Long> userIDs = new ArrayList<>();

        public WinAdmin(User user) {
                initComponents();
                this.setLocationRelativeTo(null);
                addEventListeners();
                thisUser = user;
                lbFullName.setText(thisUser.getFullName());
                refreshClasses();
                refreshBooks();
                refreshUsers();
                refreshButtons();
                refreshLogs();
        }

        @SuppressWarnings({ "unchecked", "rawtypes" })
        private void initComponents() {

                btLogOut = new javax.swing.JButton();
                lbAdmin = new javax.swing.JLabel();
                lbFullName = new javax.swing.JLabel();
                tbpnAdminTasks = new javax.swing.JTabbedPane();
                pnClassbooks = new javax.swing.JPanel();
                lbInsertBook = new javax.swing.JLabel();
                lbTitle = new javax.swing.JLabel();
                txTitle = new javax.swing.JTextField();
                lbAuthor = new javax.swing.JLabel();
                txAuthor = new javax.swing.JTextField();
                lbPubHouse = new javax.swing.JLabel();
                txPubHouse = new javax.swing.JTextField();
                lbVersion = new javax.swing.JLabel();
                txVersion = new javax.swing.JTextField();
                lbStdPrice = new javax.swing.JLabel();
                txStdPrice = new javax.swing.JTextField();
                btSubmitBook = new javax.swing.JButton();
                lbCreateClass = new javax.swing.JLabel();
                lbClassName = new javax.swing.JLabel();
                txClassName = new javax.swing.JTextField();
                btCreateClass = new javax.swing.JButton();
                lbAssignBooks = new javax.swing.JLabel();
                scrClasses = new javax.swing.JScrollPane();
                tbClasses = new javax.swing.JTable();
                scrBooks = new javax.swing.JScrollPane();
                tbBooks = new javax.swing.JTable();
                btAssignBooks = new javax.swing.JButton();
                lbFeedbackCbk = new javax.swing.JLabel();
                lbClassBooks = new javax.swing.JLabel();
                scrClassBooks = new javax.swing.JScrollPane();
                tbClassBooks = new javax.swing.JTable();
                pnUsers = new javax.swing.JPanel();
                lbManageUsers = new javax.swing.JLabel();
                scrUsers = new javax.swing.JScrollPane();
                tbUsers = new javax.swing.JTable();
                btActivateSuspend = new javax.swing.JButton();
                btBanUnban = new javax.swing.JButton();
                lbLogs = new javax.swing.JLabel();
                scrLogs = new javax.swing.JScrollPane();
                tbLogs = new javax.swing.JTable();
                lbFeedbackUsr = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                btLogOut.setText("Log out");

                lbAdmin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
                lbAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbAdmin.setText("Admin");
                lbAdmin.setPreferredSize(new java.awt.Dimension(650, 32));

                lbFullName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                lbFullName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbFullName.setPreferredSize(new java.awt.Dimension(650, 0));

                lbInsertBook.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                lbInsertBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbInsertBook.setText("Insert book");
                lbInsertBook.setPreferredSize(new java.awt.Dimension(300, 25));

                lbTitle.setText("Title:");
                lbTitle.setMaximumSize(new java.awt.Dimension(62, 16));
                lbTitle.setMinimumSize(new java.awt.Dimension(62, 16));
                lbTitle.setPreferredSize(new java.awt.Dimension(62, 16));

                txTitle.setPreferredSize(new java.awt.Dimension(226, 26));

                lbAuthor.setText("Author:");
                lbAuthor.setMaximumSize(new java.awt.Dimension(62, 16));
                lbAuthor.setMinimumSize(new java.awt.Dimension(62, 16));
                lbAuthor.setPreferredSize(new java.awt.Dimension(62, 16));

                txAuthor.setPreferredSize(new java.awt.Dimension(226, 26));

                lbPubHouse.setText("Pub. house:");

                txPubHouse.setPreferredSize(new java.awt.Dimension(226, 26));

                lbVersion.setText("Version:");
                lbVersion.setMaximumSize(new java.awt.Dimension(62, 16));
                lbVersion.setMinimumSize(new java.awt.Dimension(62, 16));
                lbVersion.setPreferredSize(new java.awt.Dimension(62, 16));

                txVersion.setPreferredSize(new java.awt.Dimension(226, 26));

                lbStdPrice.setText("Std. price:");
                lbStdPrice.setMaximumSize(new java.awt.Dimension(62, 16));
                lbStdPrice.setMinimumSize(new java.awt.Dimension(62, 16));
                lbStdPrice.setPreferredSize(new java.awt.Dimension(62, 16));

                txStdPrice.setPreferredSize(new java.awt.Dimension(226, 26));

                btSubmitBook.setText("Submit");
                btSubmitBook.setPreferredSize(new java.awt.Dimension(300, 27));

                lbCreateClass.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                lbCreateClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbCreateClass.setText("Create class");
                lbCreateClass.setPreferredSize(new java.awt.Dimension(300, 25));

                lbClassName.setText("Name:");

                txClassName.setPreferredSize(new java.awt.Dimension(226, 26));

                btCreateClass.setText("Create");
                btCreateClass.setPreferredSize(new java.awt.Dimension(300, 27));

                lbAssignBooks.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                lbAssignBooks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbAssignBooks.setText("Assign books");
                lbAssignBooks.setPreferredSize(new java.awt.Dimension(300, 25));

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
                tbClasses.setColumnSelectionAllowed(true);
                tbClasses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                tbClasses.getTableHeader().setReorderingAllowed(false);
                scrClasses.setViewportView(tbClasses);
                tbClasses.getColumnModel().getSelectionModel()
                                .setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                if (tbClasses.getColumnModel().getColumnCount() > 0) {
                        tbClasses.getColumnModel().getColumn(0).setResizable(false);
                }

                tbBooks.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Books"
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
                tbBooks.setColumnSelectionAllowed(true);
                tbBooks.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                tbBooks.getTableHeader().setReorderingAllowed(false);
                scrBooks.setViewportView(tbBooks);
                tbBooks.getColumnModel().getSelectionModel()
                                .setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                if (tbBooks.getColumnModel().getColumnCount() > 0) {
                        tbBooks.getColumnModel().getColumn(0).setResizable(false);
                }

                btAssignBooks.setText("Assign");
                btAssignBooks.setPreferredSize(new java.awt.Dimension(300, 27));

                lbFeedbackCbk.setPreferredSize(new java.awt.Dimension(650, 0));

                lbClassBooks.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                lbClassBooks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbClassBooks.setText("Classbooks");

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
                tbClassBooks.getTableHeader().setReorderingAllowed(false);
                scrClassBooks.setViewportView(tbClassBooks);

                javax.swing.GroupLayout pnClassbooksLayout = new javax.swing.GroupLayout(pnClassbooks);
                pnClassbooks.setLayout(pnClassbooksLayout);
                pnClassbooks.setLayout(pnClassbooksLayout);
                pnClassbooksLayout.setHorizontalGroup(
                                pnClassbooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnClassbooksLayout
                                                                .createSequentialGroup()
                                                                .addGroup(pnClassbooksLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(lbFeedbackCbk,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                686, Short.MAX_VALUE)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                pnClassbooksLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(btSubmitBook,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                                false)
                                                                                                                                                                .addComponent(lbStdPrice,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(lbVersion,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(lbAuthor,
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(lbPubHouse,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(lbTitle,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                62,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addComponent(txVersion,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(txPubHouse,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(txAuthor,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(txTitle,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(txStdPrice,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)))
                                                                                                                                .addComponent(lbInsertBook,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE))
                                                                                                                .addGap(50, 50, 50)
                                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(lbClassName)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                                .addComponent(txClassName,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                .addComponent(btCreateClass,
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(lbAssignBooks,
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                pnClassbooksLayout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addComponent(scrClasses,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                0,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                                                .addComponent(scrBooks,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                0,
                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                .addComponent(btAssignBooks,
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(lbCreateClass,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)))
                                                                                .addComponent(scrClassBooks,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                0, Short.MAX_VALUE)
                                                                                .addComponent(lbClassBooks,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(0, 0, 0)));

                pnClassbooksLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
                                new java.awt.Component[] { lbAuthor, lbPubHouse, lbStdPrice, lbTitle, lbVersion });

                pnClassbooksLayout.setVerticalGroup(
                                pnClassbooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnClassbooksLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(pnClassbooksLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(lbCreateClass,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lbInsertBook,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(pnClassbooksLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(pnClassbooksLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(lbClassName)
                                                                                                                .addComponent(txClassName,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(btCreateClass,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(32, 32, 32)
                                                                                                .addComponent(lbAssignBooks,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(12, 12, 12)
                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(scrClasses,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                0,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(scrBooks,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                0,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(btAssignBooks,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(pnClassbooksLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(lbTitle,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(txTitle,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                28,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(lbAuthor,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(txAuthor,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                28,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(lbPubHouse)
                                                                                                                .addComponent(txPubHouse,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                28,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(lbVersion,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(txVersion,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                28,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(pnClassbooksLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(lbStdPrice,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(txStdPrice,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(btSubmitBook,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lbFeedbackCbk,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lbClassBooks)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(scrClassBooks,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                180,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)));

                pnClassbooksLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { lbAuthor,
                                lbClassName, lbFeedbackCbk, lbPubHouse, lbStdPrice, lbTitle, lbVersion });

                pnClassbooksLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { txAuthor,
                                txClassName, txPubHouse, txStdPrice, txTitle, txVersion });

                pnClassbooksLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
                                new java.awt.Component[] { lbAssignBooks, lbCreateClass, lbInsertBook });

                tbpnAdminTasks.addTab("Classbooks", pnClassbooks);

                lbManageUsers.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                lbManageUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbManageUsers.setText("Manage users");
                lbManageUsers.setPreferredSize(new java.awt.Dimension(650, 25));

                tbUsers.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Name", "Surname", "Email", "Admin", "Status"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
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
                tbUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                tbUsers.getTableHeader().setReorderingAllowed(false);
                scrUsers.setViewportView(tbUsers);

                btActivateSuspend.setMaximumSize(new java.awt.Dimension(50, 27));
                btActivateSuspend.setMinimumSize(new java.awt.Dimension(50, 27));
                btActivateSuspend.setPreferredSize(new java.awt.Dimension(250, 27));

                btBanUnban.setMaximumSize(new java.awt.Dimension(50, 27));
                btBanUnban.setMinimumSize(new java.awt.Dimension(50, 27));
                btBanUnban.setPreferredSize(new java.awt.Dimension(250, 27));

                lbLogs.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                lbLogs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbLogs.setText("Logs");
                lbLogs.setPreferredSize(new java.awt.Dimension(650, 25));

                tbLogs.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Target", "Action", "Performer", "Date"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
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
                tbLogs.getTableHeader().setReorderingAllowed(false);
                scrLogs.setViewportView(tbLogs);
                tbLogs.getColumnModel().getSelectionModel()
                                .setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

                javax.swing.GroupLayout pnUsersLayout = new javax.swing.GroupLayout(pnUsers);
                pnUsers.setLayout(pnUsersLayout);
                pnUsersLayout.setHorizontalGroup(
                                pnUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnUsersLayout.createSequentialGroup()
                                                                .addGap(0, 0, 0)
                                                                .addGroup(pnUsersLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(lbFeedbackUsr,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(scrUsers)
                                                                                .addComponent(lbManageUsers,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(pnUsersLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(btActivateSuspend,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(btBanUnban,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addComponent(lbLogs,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(scrLogs))
                                                                .addGap(0, 0, 0)));
                pnUsersLayout.setVerticalGroup(
                                pnUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnUsersLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lbManageUsers,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(scrUsers,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                222, Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(pnUsersLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btActivateSuspend,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btBanUnban,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lbFeedbackUsr,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                16,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lbLogs,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(scrLogs,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                200,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)));

                tbpnAdminTasks.addTab("Users", pnUsers);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(0, 0, 0)
                                                                                                .addComponent(btLogOut))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(32, 32, 32)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(lbFullName,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                0,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(lbAdmin,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                0,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(tbpnAdminTasks))))
                                                                .addGap(32, 32, 32)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addComponent(btLogOut)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbAdmin,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbFullName,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(tbpnAdminTasks)
                                                                .addGap(32, 32, 32)));

                pack();
        }

        private void addEventListeners() {
                btLogOut.addActionListener(this::logOut);
                btSubmitBook.addActionListener(this::insertBook);
                btCreateClass.addActionListener(this::createClass);
                btAssignBooks.addActionListener(this::assignBooks);
                tbClasses.getSelectionModel().addListSelectionListener(this::handleClassSelection);
                tbBooks.getSelectionModel().addListSelectionListener(this::handleBookSelection);
                tbUsers.getSelectionModel().addListSelectionListener(this::handleUserSelection);
                btActivateSuspend.addActionListener(this::manageActivation);
                btBanUnban.addActionListener(this::manageBan);
        }

        private void logOut(ActionEvent evt) {
                SchoolBooksMarket.logOut();
                this.dispose();
                new WinMain().setVisible(true);
        }

        private void insertBook(ActionEvent evt) {
                String title = txTitle.getText();
                String author = txAuthor.getText();
                String pubHouse = txPubHouse.getText();
                String version = txVersion.getText();
                BigDecimal stdPrice;

                try {
                        stdPrice = txStdPrice.getText().isBlank() ? null : new BigDecimal(txStdPrice.getText());
                        SchoolBooksMarket.createBook(title, author, pubHouse, version, stdPrice);
                        refreshBooks();
                } catch (NumberFormatException e) {
                        lbFeedbackCbk.setText("Std. price field is not a valid decimal");
                } catch (ConstraintViolationException cve) {
                        String msg = cve.getConstraintViolations().stream().findFirst().get().getMessageTemplate();
                        lbFeedbackCbk.setText(msg);
                } catch (Exception e) {
                        lbFeedbackCbk.setText(e.getMessage());
                }
        }

        private void createClass(ActionEvent evt) {
                String name = txClassName.getText();
                try {
                        SchoolBooksMarket.createClass(name);
                        refreshClasses();
                } catch (ConstraintViolationException cve) {
                        String msg = cve.getConstraintViolations().stream().findFirst().get().getMessageTemplate();
                        lbFeedbackCbk.setText(msg);
                } catch (Exception e) {
                        lbFeedbackCbk.setText(e.getMessage());
                }
        }

        private void assignBooks(ActionEvent evt) {
                int classIdx = tbClasses.getSelectedRow();
                int[] booksIdc = tbBooks.getSelectedRows();
                if (!assignIsValid(classIdx, booksIdc))
                        return;
                long cID = classIDs.get(classIdx);
                ArrayList<Long> bIDs = new ArrayList<>();
                for (int id : booksIdc)
                        bIDs.add(bookIDs.get(id));
                try {
                        SchoolBooksMarket.assignBooksToClass(cID, bIDs, false);
                        refreshClassBooks();
                } catch (Exception e) {
                        lbFeedbackCbk.setText(e.getMessage());
                }
        }

        private boolean assignIsValid(int c, int[] b) {
                if (c == -1) {
                        lbFeedbackCbk.setText("Select the class to assign the book(s) to");
                        return false;
                }
                if (b.length == 0) {
                        lbFeedbackCbk.setText("Select the book(s) to assign to the selected class");
                        return false;
                }
                return true;
        }

        private void refreshClasses() {
                List<SchoolClass> classes = new ArrayList<>();
                try {
                        classes = SchoolBooksMarket.getAllClasses();
                } catch (Exception e) {
                        lbFeedbackCbk.setText("Unable to load classes");
                } finally {
                        int selectedRow = tbClasses.getSelectedRow();
                        DefaultTableModel model = WinMain.clearTable(tbClasses);
                        classIDs.clear();
                        classes.forEach(c -> model.addRow(generateRow(c)));
                        tbClasses.setModel(model);
                        if (selectedRow < tbClasses.getRowCount())
                                tbClasses.changeSelection(selectedRow, 0, false, false);
                }
        }

        private void refreshBooks() {
                List<Book> books = new ArrayList<>();
                try {
                        books = SchoolBooksMarket.getAllBooks();
                } catch (Exception e) {
                        lbFeedbackCbk.setText("Unable to load books");
                } finally {
                        int[] selectedRows = tbBooks.getSelectedRows();
                        DefaultTableModel model = WinMain.clearTable(tbBooks);
                        bookIDs.clear();
                        books.forEach(b -> model.addRow(generateRow(b)));
                        tbBooks.setModel(model);
                        for (int row : selectedRows) {
                                if (row < tbBooks.getRowCount())
                                        tbBooks.addRowSelectionInterval(row, row);
                        }
                }
        }

        private void refreshClassBooks() {
                int classIdx = tbClasses.getSelectedRow();
                List<ClassBook> classBooks = new ArrayList<>();

                try {
                        if (classIdx == -1)
                                throw new NoSelectionException();
                        long cID = classIDs.get(classIdx);
                        classBooks = SchoolBooksMarket.getClassBooksByClassId(cID);
                } catch (Exception e) {
                        lbFeedbackCbk.setText("Unable to load classbooks");
                } finally {
                        DefaultTableModel model = WinMain.clearTable(tbClassBooks);
                        classBookIDs.clear();
                        classBooks.forEach(cb -> model.addRow(generateRow(cb)));
                        tbClassBooks.setModel(model);
                }
        }

        private void refreshUsers() {
                List<User> users = new ArrayList<>();
                try {
                        users = SchoolBooksMarket.getAllUsers();
                } catch (Exception e) {
                        lbFeedbackUsr.setText("Unable to load users");
                } finally {
                        int selectedRow = tbUsers.getSelectedRow();
                        DefaultTableModel model = WinMain.clearTable(tbUsers);
                        userIDs.clear();
                        users.forEach(u -> model.addRow(generateRow(u)));
                        tbUsers.setModel(model);
                        if (selectedRow < tbUsers.getRowCount())
                                tbUsers.changeSelection(selectedRow, 0, false, false);
                }
        }

        private void refreshButtons() {
                String status = getSelectedUserStatus();
                if (status == null) {
                        displayButtons(false);
                        return;
                }

                displayButtons(true);
                btActivateSuspend.setText(status.equals("Activated") ? "Suspend" : "Activate");
                btBanUnban.setText(status.equals("Banned") ? "Unban" : "Ban");
        }

        private void refreshLogs() {
                List<Log> logs = new ArrayList<>();
                try {
                        logs = SchoolBooksMarket.getAllLogs();
                } catch (Exception e) {
                        lbFeedbackUsr.setText("Unable to load logs");
                } finally {
                        DefaultTableModel model = WinMain.clearTable(tbLogs);
                        logs.forEach(l -> model.addRow(generateRow(l)));
                        tbLogs.setModel(model);
                        tbLogs.changeSelection(tbLogs.getRowCount() - 1, 0, false, false);
                }
        }

        private void manageActivation(ActionEvent evt) {
                String status = getSelectedUserStatus();
                if (status == null) {
                        lbFeedbackUsr.setText("No user selected");
                        return;
                }

                long id = userIDs.get(tbUsers.getSelectedRow());
                try {
                        if (status.equals("Activated")) {
                                SchoolBooksMarket.suspendAccount(id);
                        } else {
                                SchoolBooksMarket.activateAccount(id);
                        }
                        refreshUsers();
                        refreshLogs();
                } catch (Exception e) {
                        lbFeedbackUsr.setText(e.getMessage());
                }
        }

        private void manageBan(ActionEvent evt) {
                String status = getSelectedUserStatus();
                if (status == null) {
                        lbFeedbackUsr.setText("No user selected");
                        return;
                }

                long id = userIDs.get(tbUsers.getSelectedRow());
                try {
                        if (status.equals("Banned")) {
                                SchoolBooksMarket.suspendAccount(id);
                        } else {
                                SchoolBooksMarket.banAccount(id);
                        }
                        refreshUsers();
                        refreshLogs();
                } catch (Exception e) {
                        lbFeedbackUsr.setText(e.getMessage());
                }
        }

        private String[] generateRow(SchoolClass c) {
                classIDs.add(c.getId());
                return new String[] { c.getClassName() };
        }

        private String[] generateRow(Book b) {
                bookIDs.add(b.getId());
                return new String[] { b.getTitle() };
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

        private String[] generateRow(User u) {
                userIDs.add(u.getId());
                String[] row = new String[5];
                row[0] = u.getFname();
                row[1] = u.getLname();
                row[2] = u.getEmail();
                row[3] = u.isAdmin() ? "Yes" : "No";
                row[4] = u.isActivated() == null ? "Banned" : u.isActivated() ? "Activated" : "Suspended";
                return row;
        }

        private Object[] generateRow(Log l) {
                Object[] row = new Object[4];
                row[0] = userLogInfo(l.getPerformedOn());
                row[1] = l.getAction().getAction();
                row[2] = userLogInfo(l.getPerformedBy());
                row[3] = l.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                return row;
        }

        private String userLogInfo(User u) {
                return String.format("ID: %s   %s", u.getId(), u.getFullName());
        }

        private String getSelectedUserStatus() {
                int row = tbUsers.getSelectedRow();
                return row == -1 ? null : tbUsers.getModel().getValueAt(row, 4).toString();
        }

        private void displayButtons(boolean boo) {
                btActivateSuspend.setVisible(boo);
                btBanUnban.setVisible(boo);
        }

        private void handleClassSelection(ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting())
                        refreshClassBooks();
        }

        private void handleBookSelection(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting())
                        return;
                int bookIdx = tbBooks.getSelectedRow();
                try {
                        Book book = SchoolBooksMarket.findBook(bookIDs.get(bookIdx));
                        lbFeedbackCbk.setText(String.format(
                                        "Title: %s   |   Author: %s   |   Publishing house: %s   |   Version: %s   |   Standard price: %s",
                                        book.getTitle(),
                                        book.getAuthor(),
                                        book.getPubHouse() == null ? "---" : book.getPubHouse(),
                                        book.getVersion() == null ? "---" : book.getVersion(),
                                        book.getStdPrice()));
                } catch (Exception e) {
                }
        }

        private void handleUserSelection(ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting())
                        refreshButtons();
        }

        private javax.swing.JButton btActivateSuspend;
        private javax.swing.JButton btAssignBooks;
        private javax.swing.JButton btBanUnban;
        private javax.swing.JButton btCreateClass;
        private javax.swing.JButton btLogOut;
        private javax.swing.JButton btSubmitBook;
        private javax.swing.JLabel lbAdmin;
        private javax.swing.JLabel lbAssignBooks;
        private javax.swing.JLabel lbAuthor;
        private javax.swing.JLabel lbClassBooks;
        private javax.swing.JLabel lbClassName;
        private javax.swing.JLabel lbCreateClass;
        private javax.swing.JLabel lbFeedbackCbk;
        private javax.swing.JLabel lbFeedbackUsr;
        private javax.swing.JLabel lbFullName;
        private javax.swing.JLabel lbInsertBook;
        private javax.swing.JLabel lbLogs;
        private javax.swing.JLabel lbManageUsers;
        private javax.swing.JLabel lbPubHouse;
        private javax.swing.JLabel lbStdPrice;
        private javax.swing.JLabel lbTitle;
        private javax.swing.JLabel lbVersion;
        private javax.swing.JPanel pnClassbooks;
        private javax.swing.JPanel pnUsers;
        private javax.swing.JScrollPane scrBooks;
        private javax.swing.JScrollPane scrClassBooks;
        private javax.swing.JScrollPane scrClasses;
        private javax.swing.JScrollPane scrLogs;
        private javax.swing.JScrollPane scrUsers;
        private javax.swing.JTable tbBooks;
        private javax.swing.JTable tbClassBooks;
        private javax.swing.JTable tbClasses;
        private javax.swing.JTable tbLogs;
        private javax.swing.JTable tbUsers;
        private javax.swing.JTabbedPane tbpnAdminTasks;
        private javax.swing.JTextField txAuthor;
        private javax.swing.JTextField txClassName;
        private javax.swing.JTextField txPubHouse;
        private javax.swing.JTextField txStdPrice;
        private javax.swing.JTextField txTitle;
        private javax.swing.JTextField txVersion;
}
