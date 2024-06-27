package it.ciac;

import it.ciac.control.Store;
import it.ciac.entity.User;
import it.ciac.gui.WinMain;

public class App {
    public static void main(String[] args) {
        try {
            Store.findEntityByPrimaryKey(User.class, 1).orElseThrow();
        } catch (Exception e) {
            User admin = new User("Master", "Admin", "master@admin.com", "root", true);
            admin.setActivated(true);
            Store.saveEntity(admin);
            System.out.println("Created Master Admin account:\nemail: master@admin.com\npassword: root");
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WinMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WinMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WinMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WinMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WinMain().setVisible(true);
            }
        });
    }
}
