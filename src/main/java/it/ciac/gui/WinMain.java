package it.ciac.gui;

import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;

import it.ciac.boundary.SchoolBooksMarket;
import it.ciac.entity.User;
import jakarta.validation.ConstraintViolationException;

public class WinMain extends javax.swing.JFrame {

        public WinMain() {
                initComponents();
                addEventListeners();
                this.setLocationRelativeTo(null);
        }

        private void initComponents() {

                lbAppTitle = new javax.swing.JLabel();
                lbLogin = new javax.swing.JLabel();
                lbLIEmail = new javax.swing.JLabel();
                txLIEmail = new javax.swing.JTextField();
                lbLIPassword = new javax.swing.JLabel();
                pwLIPassword = new javax.swing.JPasswordField();
                btLogin = new javax.swing.JButton();
                lbLIFeedback = new javax.swing.JLabel();
                lbSignUp = new javax.swing.JLabel();
                lbSUName = new javax.swing.JLabel();
                txSUName = new javax.swing.JTextField();
                lbSUSurname = new javax.swing.JLabel();
                txSUSurname = new javax.swing.JTextField();
                lbSUEmail = new javax.swing.JLabel();
                txSUEmail = new javax.swing.JTextField();
                lbSUPhoneNum = new javax.swing.JLabel();
                txSUPhoneNum = new javax.swing.JTextField();
                lbSUPassword = new javax.swing.JLabel();
                pwSUPassword = new javax.swing.JPasswordField();
                lbSUPasswordCf = new javax.swing.JLabel();
                pwSUPasswordCf = new javax.swing.JPasswordField();
                lbAccountType = new javax.swing.JLabel();
                cbAccountType = new javax.swing.JComboBox<>();
                btSignUp = new javax.swing.JButton();
                lbSUFeedback = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                lbAppTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
                lbAppTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbAppTitle.setText("School Books Market");

                lbLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                lbLogin.setText("Login");

                lbLIEmail.setText("Email:");

                lbLIPassword.setText("Password:");

                btLogin.setText("Connect");

                lbSignUp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                lbSignUp.setText("Sign Up");

                lbSUName.setText("Name:");

                lbSUSurname.setText("Surname:");

                lbSUEmail.setText("Email:");

                lbSUPhoneNum.setText("Phone number:");

                lbSUPassword.setText("Password:");

                lbSUPasswordCf.setText("Confirm Password:");

                lbAccountType.setText("Account Type:");

                cbAccountType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Admin" }));

                btSignUp.setText("Register");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap(100, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(lbAppTitle,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                400,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                false)
                                                                                                                .addComponent(lbLIEmail,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(lbLIPassword,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(lbSUName,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(lbSUSurname,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(lbSUEmail,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(lbSUPhoneNum,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(lbSUPassword,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(lbAccountType,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(lbSUPasswordCf,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(pwLIPassword)
                                                                                                                .addComponent(txSUName)
                                                                                                                .addComponent(txSUSurname)
                                                                                                                .addComponent(txSUEmail)
                                                                                                                .addComponent(txSUPhoneNum)
                                                                                                                .addComponent(pwSUPassword)
                                                                                                                .addComponent(pwSUPasswordCf)
                                                                                                                .addComponent(cbAccountType,
                                                                                                                                0,
                                                                                                                                288,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(txLIEmail)))
                                                                                .addComponent(btLogin,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(lbLIFeedback,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(lbSignUp,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(lbLogin,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(btSignUp,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(lbSUFeedback,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap(100, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lbAppTitle)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                64,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(lbLogin)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lbLIEmail)
                                                                                .addComponent(txLIEmail,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lbLIPassword)
                                                                                .addComponent(pwLIPassword,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btLogin)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lbLIFeedback)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                63,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(lbSignUp)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lbSUName)
                                                                                .addComponent(txSUName,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lbSUSurname)
                                                                                .addComponent(txSUSurname,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lbSUEmail)
                                                                                .addComponent(txSUEmail,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lbSUPhoneNum)
                                                                                .addComponent(txSUPhoneNum,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lbSUPassword)
                                                                                .addComponent(pwSUPassword,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lbSUPasswordCf)
                                                                                .addComponent(pwSUPasswordCf,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lbAccountType,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                26,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(cbAccountType,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btSignUp)
                                                                .addGap(20, 20, 20)
                                                                .addComponent(lbSUFeedback)
                                                                .addContainerGap(63, Short.MAX_VALUE)));

                pack();
        }

        private void addEventListeners() {
                btLogin.addActionListener(this::logIn);
                btSignUp.addActionListener(this::signUp);
        }

        public static DefaultTableModel clearTable(javax.swing.JTable table) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setNumRows(0);
                return model;
        }

        private void logIn(ActionEvent evt) {
                String email = txLIEmail.getText();
                String password = String.valueOf(pwLIPassword.getPassword());
                if (!loginIsValid(email, password))
                        return;
                try {
                        User loggedUser = SchoolBooksMarket.logIn(email, password);
                        handleLogin(loggedUser);
                } catch (Exception e) {
                        lbLIFeedback.setText(e.getMessage());
                }
        }

        private void handleLogin(User loggedUser) {
                this.dispose();
                if (loggedUser.isAdmin())
                        new WinAdmin(loggedUser).setVisible(true);
                else
                        new WinStudent(loggedUser).setVisible(true);
        }

        private void signUp(ActionEvent evt) {
                String name = txSUName.getText();
                String surname = txSUSurname.getText();
                String email = txSUEmail.getText();
                String pwd = String.valueOf(pwSUPassword.getPassword());
                String pwdCf = String.valueOf(pwSUPasswordCf.getPassword());
                String tel = txSUPhoneNum.getText().isBlank() ? null : txSUPhoneNum.getText();
                boolean admin = cbAccountType.getSelectedItem().equals("Admin") ? true : false;
                try {
                        User registeredUser = SchoolBooksMarket.signUp(name, surname, email, pwd, pwdCf, tel, admin);
                        lbSUFeedback.setText("Account created successfully with ID: " + registeredUser.getId());
                } catch (ConstraintViolationException cve) {
                        String msg = cve.getConstraintViolations().stream().findFirst().get().getMessageTemplate();
                        lbSUFeedback.setText(msg);
                } catch (Exception e) {
                        lbSUFeedback.setText(e.getMessage());
                }
        }

        private boolean loginIsValid(String e, String p) {
                if (!emailIsValid(e)) {
                        lbLIFeedback.setText("Email field is not a valid email address");
                        return false;
                }
                if (p.isBlank()) {
                        lbLIFeedback.setText("Password field cannot be empty");
                        return false;
                }
                return true;
        }

        private boolean emailIsValid(String email) {
                String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(email);
                return matcher.matches();
        }

        private javax.swing.JButton btLogin;
        private javax.swing.JButton btSignUp;
        private javax.swing.JComboBox<String> cbAccountType;
        private javax.swing.JLabel lbAccountType;
        private javax.swing.JLabel lbAppTitle;
        private javax.swing.JLabel lbLIEmail;
        private javax.swing.JLabel lbLIFeedback;
        private javax.swing.JLabel lbLIPassword;
        private javax.swing.JLabel lbLogin;
        private javax.swing.JLabel lbSUEmail;
        private javax.swing.JLabel lbSUFeedback;
        private javax.swing.JLabel lbSUName;
        private javax.swing.JLabel lbSUPassword;
        private javax.swing.JLabel lbSUPasswordCf;
        private javax.swing.JLabel lbSUPhoneNum;
        private javax.swing.JLabel lbSUSurname;
        private javax.swing.JLabel lbSignUp;
        private javax.swing.JPasswordField pwLIPassword;
        private javax.swing.JPasswordField pwSUPassword;
        private javax.swing.JPasswordField pwSUPasswordCf;
        private javax.swing.JTextField txLIEmail;
        private javax.swing.JTextField txSUEmail;
        private javax.swing.JTextField txSUName;
        private javax.swing.JTextField txSUPhoneNum;
        private javax.swing.JTextField txSUSurname;
}
