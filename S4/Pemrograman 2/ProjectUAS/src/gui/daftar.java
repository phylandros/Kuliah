/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import controller.koneksi;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ariya
 */
public class daftar extends javax.swing.JFrame {
    ResultSet rs;
    Statement stmt;

    
    /**
     * Creates new form daftar
     */
    public daftar() {
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

        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inp_npm = new javax.swing.JTextField();
        inp_nama = new javax.swing.JTextField();
        inp_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bt_backdaftar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        bt_daftar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        inp_password = new javax.swing.JPasswordField();

        jTextField2.setText("jTextField2");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DAFTAR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 70));

        inp_npm.setBackground(new java.awt.Color(102, 102, 102));
        inp_npm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inp_npm.setForeground(new java.awt.Color(255, 255, 255));
        inp_npm.setBorder(null);
        jPanel1.add(inp_npm, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 190, -1));

        inp_nama.setBackground(new java.awt.Color(102, 102, 102));
        inp_nama.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        inp_nama.setForeground(new java.awt.Color(255, 255, 255));
        inp_nama.setBorder(null);
        jPanel1.add(inp_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 190, -1));

        inp_username.setBackground(new java.awt.Color(102, 102, 102));
        inp_username.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        inp_username.setForeground(new java.awt.Color(255, 255, 255));
        inp_username.setBorder(null);
        jPanel1.add(inp_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 190, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NPM");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        bt_backdaftar.setBackground(new java.awt.Color(102, 102, 102));
        bt_backdaftar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bt_backdaftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_backdaftarMouseClicked(evt);
            }
        });
        bt_backdaftar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Back");
        bt_backdaftar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jPanel1.add(bt_backdaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 90, 30));

        bt_daftar.setBackground(new java.awt.Color(102, 102, 102));
        bt_daftar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bt_daftar.setForeground(new java.awt.Color(255, 255, 255));
        bt_daftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_daftarMouseClicked(evt);
            }
        });
        bt_daftar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Daftar");
        bt_daftar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jPanel1.add(bt_daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 90, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 190, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 190, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 190, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 190, 10));

        inp_password.setBackground(new java.awt.Color(102, 102, 102));
        inp_password.setForeground(new java.awt.Color(255, 255, 255));
        inp_password.setBorder(null);
        jPanel1.add(inp_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_backdaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_backdaftarMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new login().setVisible(true);
    }//GEN-LAST:event_bt_backdaftarMouseClicked

    private void bt_daftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_daftarMouseClicked
        // TODO add your handling code here:
        try{
            koneksi con = new koneksi();
        
        String npm = inp_npm.getText();
        String nama = inp_nama.getText();
        String username = inp_username.getText();
        String password = new String(inp_password.getPassword());
        String sql = "INSERT INTO `account` (`npm`, `nama`, `username`, `password`, `status_login`) VALUES ('"+npm+"', '"+nama+"', '"+username+"', '"+password+"', '0');";
        con.dmlData(sql);     
        
        inp_npm.setText("");
        inp_nama.setText("");
        inp_username.setText("");
        inp_password.setText("");
        
        } catch(Exception e){
            System.out.println("Error : " +e);
        }
    }//GEN-LAST:event_bt_daftarMouseClicked

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
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daftar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bt_backdaftar;
    private javax.swing.JPanel bt_daftar;
    private javax.swing.JTextField inp_nama;
    private javax.swing.JTextField inp_npm;
    private javax.swing.JPasswordField inp_password;
    private javax.swing.JTextField inp_username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
