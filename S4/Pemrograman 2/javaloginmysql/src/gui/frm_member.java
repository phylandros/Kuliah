/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import controller.koneksi;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 *
 * @author ariya
 */
public class frm_member extends javax.swing.JFrame {

    
    ResultSet rs;
    Statement stmt;
    koneksi con = new koneksi();
    String fullnm,email,pwd,confirmpwd,ph,gender,birth;

    /**
     * Creates new form frm_member
     */
    public frm_member() {
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

        gender_group = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inp_pwd = new javax.swing.JPasswordField();
        inp_confirmpwd = new javax.swing.JPasswordField();
        inp_email = new javax.swing.JTextField();
        inp_name = new javax.swing.JTextField();
        inp_numb = new javax.swing.JTextField();
        cb_pria = new javax.swing.JRadioButton();
        cb_wanita = new javax.swing.JRadioButton();
        inp_date = new com.toedter.calendar.JDateChooser();
        bt_cancel = new javax.swing.JButton();
        bt_register = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Register Form");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 440, -1));

        jLabel2.setText("Date of Birth");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, 30));

        jLabel3.setText("Fullname");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 30));

        jLabel4.setText("Email");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 30));

        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 30));

        jLabel6.setText("Confirm Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 30));

        jLabel7.setText("Mobile Number");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 30));

        jLabel8.setText("Gender");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, 30));

        inp_pwd.setText("jPasswordField1");
        inp_pwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inp_pwdMouseClicked(evt);
            }
        });
        jPanel1.add(inp_pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 220, -1));

        inp_confirmpwd.setText("jPasswordField2");
        inp_confirmpwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inp_confirmpwdMouseClicked(evt);
            }
        });
        jPanel1.add(inp_confirmpwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 220, -1));

        inp_email.setText("Masukan Email");
        inp_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inp_emailMouseClicked(evt);
            }
        });
        jPanel1.add(inp_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 220, -1));

        inp_name.setText("Masukan Fullname");
        inp_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inp_nameMouseClicked(evt);
            }
        });
        jPanel1.add(inp_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 220, -1));

        inp_numb.setText("Masukan Mobile Number");
        inp_numb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inp_numbMouseClicked(evt);
            }
        });
        jPanel1.add(inp_numb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 220, -1));

        gender_group.add(cb_pria);
        cb_pria.setText("Pria");
        jPanel1.add(cb_pria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        gender_group.add(cb_wanita);
        cb_wanita.setText("Wanita");
        jPanel1.add(cb_wanita, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));
        jPanel1.add(inp_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 220, -1));

        bt_cancel.setText("Cancel");
        bt_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(bt_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, -1, -1));

        bt_register.setText("Register");
        bt_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_registerActionPerformed(evt);
            }
        });
        jPanel1.add(bt_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_registerActionPerformed
        // TODO add your handling code here:
        fullnm=inp_name.getText();
        email=inp_email.getText();
        pwd = new String(inp_pwd.getPassword());
        confirmpwd = new String(inp_confirmpwd.getPassword());
        ph = inp_numb.getText();
        gender = "";
        if(cb_pria.isSelected()){
            gender = "Male";
        }
        if(cb_wanita.isSelected()){
            gender = "Female";
        }
        
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        birth = dateformat.format(inp_date.getDate());
        System.out.println("PWD : "+pwd);
        String sql = "INSERT INTO register(fullname,email,pwd,confirmpwd,phone,gender,birth) "
                + "VALUES('"+fullnm+"','"+email+"','"+pwd+"','"+confirmpwd+"','"+ph+"','"+gender+"',"
                + "STR_TO_DATE('"+birth+"','%d-%m-%Y'))";
        System.out.println("SQL : "+sql);
        con.dmlData(sql);
        this.dispose();
        
        
    }//GEN-LAST:event_bt_registerActionPerformed

    private void inp_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inp_nameMouseClicked
        // TODO add your handling code here:
        inp_name.setText("");
    }//GEN-LAST:event_inp_nameMouseClicked

    private void inp_emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inp_emailMouseClicked
        // TODO add your handling code here:
        inp_email.setText("");
    }//GEN-LAST:event_inp_emailMouseClicked

    private void inp_pwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inp_pwdMouseClicked
        // TODO add your handling code here:
        inp_pwd.setText("");
    }//GEN-LAST:event_inp_pwdMouseClicked

    private void inp_confirmpwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inp_confirmpwdMouseClicked
        // TODO add your handling code here:
        inp_confirmpwd.setText("");
    }//GEN-LAST:event_inp_confirmpwdMouseClicked

    private void inp_numbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inp_numbMouseClicked
        // TODO add your handling code here:
        inp_numb.setText("");
    }//GEN-LAST:event_inp_numbMouseClicked

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bt_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(frm_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancel;
    private javax.swing.JButton bt_register;
    private javax.swing.JRadioButton cb_pria;
    private javax.swing.JRadioButton cb_wanita;
    private javax.swing.ButtonGroup gender_group;
    private javax.swing.JPasswordField inp_confirmpwd;
    private com.toedter.calendar.JDateChooser inp_date;
    private javax.swing.JTextField inp_email;
    private javax.swing.JTextField inp_name;
    private javax.swing.JTextField inp_numb;
    private javax.swing.JPasswordField inp_pwd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
