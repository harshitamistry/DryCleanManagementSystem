/* Name: Harshita Aka Dharna Mistry
 * Name : Sheenam Kamal
 * Name : Kour Sanminder
 * JavaProject
 *
 * description:A java GUI application to register a customer.
 */

package javaproject;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaproject.Functionality.counter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Signup
     */
    public Register() {
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

        firtNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        phNumberLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        phNumberTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        stAddressLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        stAddressTextField = new javax.swing.JTextField();
        postCodeTextField = new javax.swing.JTextField();
        provinceTextField = new javax.swing.JTextField();
        RegisterButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuBar = new javax.swing.JMenu();
        signinMenuItem = new javax.swing.JMenuItem();
        pickupMenuItem = new javax.swing.JMenuItem();
        registerMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        firtNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        firtNameLabel.setForeground(new java.awt.Color(102, 204, 255));
        firtNameLabel.setText("First Name");
        getContentPane().add(firtNameLabel);
        firtNameLabel.setBounds(80, 130, 74, 17);

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lastNameLabel.setForeground(new java.awt.Color(51, 204, 255));
        lastNameLabel.setText("Last Name");
        getContentPane().add(lastNameLabel);
        lastNameLabel.setBounds(80, 170, 73, 17);

        phNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phNumberLabel.setForeground(new java.awt.Color(102, 204, 255));
        phNumberLabel.setText("Phone Number");
        getContentPane().add(phNumberLabel);
        phNumberLabel.setBounds(80, 210, 104, 17);

        firstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextFieldActionPerformed(evt);
            }
        });
        firstNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstNameTextFieldFocusLost(evt);
            }
        });
        getContentPane().add(firstNameTextField);
        firstNameTextField.setBounds(210, 130, 146, 30);

        lastNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastNameTextFieldFocusLost(evt);
            }
        });
        getContentPane().add(lastNameTextField);
        lastNameTextField.setBounds(210, 170, 146, 30);

        phNumberTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phNumberTextFieldFocusLost(evt);
            }
        });
        getContentPane().add(phNumberTextField);
        phNumberTextField.setBounds(210, 210, 141, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("Postal Code");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 290, 90, 20);

        stAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stAddressLabel.setForeground(new java.awt.Color(0, 204, 255));
        stAddressLabel.setText("Street Address");
        getContentPane().add(stAddressLabel);
        stAddressLabel.setBounds(80, 250, 110, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("Province");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 330, 70, 17);
        getContentPane().add(stAddressTextField);
        stAddressTextField.setBounds(210, 250, 150, 30);

        postCodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postCodeTextFieldActionPerformed(evt);
            }
        });
        postCodeTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                postCodeTextFieldFocusLost(evt);
            }
        });
        getContentPane().add(postCodeTextField);
        postCodeTextField.setBounds(210, 290, 150, 30);

        provinceTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                provinceTextFieldFocusLost(evt);
            }
        });
        getContentPane().add(provinceTextField);
        provinceTextField.setBounds(210, 330, 160, 30);

        RegisterButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(0, 153, 153));
        RegisterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_images/register.png"))); // NOI18N
        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });
        getContentPane().add(RegisterButton);
        RegisterButton.setBounds(180, 380, 170, 50);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("ZOOM DRY CLEANING");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 60, 199, 22);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_images/background.jpg"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(500, 500));
        jLabel3.setMinimumSize(new java.awt.Dimension(500, 500));
        jLabel3.setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 500, 500);

        MenuBar.setText("Menu");

        signinMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_images/signInsmall.jpg"))); // NOI18N
        signinMenuItem.setText("Signin");
        signinMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinMenuItemActionPerformed(evt);
            }
        });
        MenuBar.add(signinMenuItem);

        pickupMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_images/pickUpSmall.jpg"))); // NOI18N
        pickupMenuItem.setText("Pick Up");
        pickupMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickupMenuItemActionPerformed(evt);
            }
        });
        MenuBar.add(pickupMenuItem);

        registerMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_images/registerSmall.png"))); // NOI18N
        registerMenuItem.setText("Register");
        registerMenuItem.setToolTipText("");
        registerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerMenuItemActionPerformed(evt);
            }
        });
        MenuBar.add(registerMenuItem);

        jMenuBar1.add(MenuBar);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextFieldActionPerformed

    private void firstNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameTextFieldFocusLost
       if(firstNameTextField.getText().equals(""))
      {
          
      }
         
        counter=0; 
        Functionality f = new Functionality();
         f.isNotDigitOrSpace(firstNameTextField.getText());
         if(counter>=1)
         {
             firstNameTextField.requestFocusInWindow();
         }
    }//GEN-LAST:event_firstNameTextFieldFocusLost

    private void lastNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameTextFieldFocusLost
        if(lastNameTextField.getText().equals(""))
      {
          
      }
        else
        {
         
        counter=0; 
        Functionality f = new Functionality();
         f.isNotDigitOrSpace(lastNameTextField.getText());
         if(counter>=1)
         {
             lastNameTextField.requestFocusInWindow();
         }
        }
    }//GEN-LAST:event_lastNameTextFieldFocusLost

    private void phNumberTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phNumberTextFieldFocusLost
        if(phNumberTextField.getText().equals(""))
      {
          
      }
        else
        { 
         counter=0;
        Functionality f = new Functionality();
        f.checkLengthPhone(phNumberTextField.getText());
        if(counter>=1)
        {
            phNumberTextField.requestFocusInWindow();
        }
        }
        Functionality f = new Functionality();
        try {
            f.storeNumbers(phNumberTextField.getText());
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_phNumberTextFieldFocusLost

    private void postCodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postCodeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postCodeTextFieldActionPerformed

    private void postCodeTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_postCodeTextFieldFocusLost
        if(postCodeTextField.getText().equals(""))
      {
          
      }
        else
        { 
         counter=0;
         Functionality f = new Functionality();
         f.checkPostal(postCodeTextField.getText());
         if(counter>=1)
         {
             postCodeTextField.requestFocusInWindow();
         }
        }
    }//GEN-LAST:event_postCodeTextFieldFocusLost

    private void provinceTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_provinceTextFieldFocusLost
        if(provinceTextField.getText().equals(""))
      {
          
      }
        else
        { 
         counter=0;
        Functionality f = new Functionality();
        f.checkLength(provinceTextField.getText());
        if(counter>=1)
        {
            provinceTextField.requestFocusInWindow();
        }
        }
    }//GEN-LAST:event_provinceTextFieldFocusLost

    
    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        Name n = new Name(firstNameTextField.getText(),phNumberTextField.getText());
        DisplayOrders dos = new DisplayOrders();
        Object[] row={firstNameTextField.getText(),phNumberTextField.getText()};
        CustomerStore cs = new CustomerStore();
        DefaultTableModel model = (DefaultTableModel)cs.recordTable.getModel();
        model.addRow(row);
        Functionality f = new Functionality();
        try {
            f.storePhoneNumbers(phNumberTextField.getText());
            f.storePhoneNumbers(firstNameTextField.getText());
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        DisplayOrders displ = new DisplayOrders();
        displ.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void signinMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinMenuItemActionPerformed
        signIn s = new signIn();
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_signinMenuItemActionPerformed

    private void pickupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickupMenuItemActionPerformed
        PickUp p = new PickUp();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pickupMenuItemActionPerformed

    private void registerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerMenuItemActionPerformed
         Register r = new Register();
        r.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registerMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuBar;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel firtNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel phNumberLabel;
    private javax.swing.JTextField phNumberTextField;
    private javax.swing.JMenuItem pickupMenuItem;
    private javax.swing.JTextField postCodeTextField;
    private javax.swing.JTextField provinceTextField;
    private javax.swing.JMenuItem registerMenuItem;
    private javax.swing.JMenuItem signinMenuItem;
    private javax.swing.JLabel stAddressLabel;
    private javax.swing.JTextField stAddressTextField;
    // End of variables declaration//GEN-END:variables
}
