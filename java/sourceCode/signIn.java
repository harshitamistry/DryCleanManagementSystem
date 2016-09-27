/* Name: Harshita Aka Dharna Mistry
 * Name : Sheenam Kamal
 * Name : Kour Sanminder
 * JavaProject
 *
 * description:A java GUI application to signin the customer. And gives an error
 * if customer is not registered.
 */

package javaproject;

/**
 *
 * @author admin
 */
public class signIn extends javax.swing.JFrame {

    /**
     * Creates new form signIn
     */
    public signIn() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        signInLabel = new javax.swing.JLabel();
        signInTextField = new javax.swing.JTextField();
        signInButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        signInMenuItem = new javax.swing.JMenuItem();
        pickUpItem = new javax.swing.JMenuItem();
        registerItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        signInLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signInLabel.setForeground(new java.awt.Color(51, 204, 255));
        signInLabel.setText("Customer Phone Number");
        getContentPane().add(signInLabel);
        signInLabel.setBounds(30, 180, 180, 14);

        signInTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(signInTextField);
        signInTextField.setBounds(230, 170, 180, 40);

        signInButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_images/signIn.jpg"))); // NOI18N
        signInButton.setText("Sign In");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });
        getContentPane().add(signInButton);
        signInButton.setBounds(180, 290, 130, 80);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("ZOOM DRY CLEANING");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 60, 199, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_images/background.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 500));
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 500);

        Menu.setText("Menu");

        signInMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_images/signInsmall.jpg"))); // NOI18N
        signInMenuItem.setText("Signin");
        signInMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInMenuItemActionPerformed(evt);
            }
        });
        Menu.add(signInMenuItem);

        pickUpItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_images/pickUpSmall.jpg"))); // NOI18N
        pickUpItem.setText("Pick Up");
        pickUpItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickUpItemActionPerformed(evt);
            }
        });
        Menu.add(pickUpItem);

        registerItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_images/registerSmall.png"))); // NOI18N
        registerItem.setText("Register");
        registerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerItemActionPerformed(evt);
            }
        });
        Menu.add(registerItem);

        jMenuBar1.add(Menu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signInTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signInTextFieldActionPerformed

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        SearchPhoneNumbers s = new SearchPhoneNumbers();
        s.searchFile(signInTextField.getText());
        Functionality f = new Functionality();
       // f.storeOrderNums();
    }//GEN-LAST:event_signInButtonActionPerformed

    private void signInMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInMenuItemActionPerformed
        signIn s = new signIn();
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_signInMenuItemActionPerformed

    private void pickUpItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickUpItemActionPerformed
        PickUp p = new PickUp();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pickUpItemActionPerformed

    private void registerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerItemActionPerformed
        Register r = new Register();
        r.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registerItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(signIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem pickUpItem;
    private javax.swing.JMenuItem registerItem;
    private javax.swing.JButton signInButton;
    private javax.swing.JLabel signInLabel;
    private javax.swing.JMenuItem signInMenuItem;
    private javax.swing.JTextField signInTextField;
    // End of variables declaration//GEN-END:variables
}