/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package per2;

import javax.swing.JOptionPane;

/**
 *
 * @author ariya
 */
public class latihan extends javax.swing.JFrame {

    /**
     * Creates new form latihan
     */
    public latihan() {
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

        label1 = new java.awt.Label();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        bt_segitiga = new javax.swing.JButton();
        inpt_segitiga2 = new javax.swing.JTextField();
        inpt_segitiga1 = new javax.swing.JTextField();
        label_hasil1 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inpt_lingkaran1 = new javax.swing.JTextField();
        bt_lingkaran = new javax.swing.JButton();
        label_hasil2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inpt_trapesium3 = new javax.swing.JTextField();
        inpt_trapesium1 = new javax.swing.JTextField();
        inpt_trapesium2 = new javax.swing.JTextField();
        label_hasil3 = new javax.swing.JLabel();
        btn_trapesium = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setText("Menghitung Luas Bangun");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 230, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label2.setText("Alas");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 27, -1, -1));

        label3.setText("Tinggi");
        jPanel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 65, -1, -1));

        bt_segitiga.setText("Hitung");
        bt_segitiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_segitigaActionPerformed(evt);
            }
        });
        jPanel1.add(bt_segitiga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        inpt_segitiga2.setText("Input Tinggi");
        inpt_segitiga2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inpt_segitiga2MouseClicked(evt);
            }
        });
        jPanel1.add(inpt_segitiga2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 120, -1));

        inpt_segitiga1.setText("Input Alas");
        inpt_segitiga1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpt_segitiga1.setFocusCycleRoot(true);
        inpt_segitiga1.setHighlighter(null);
        inpt_segitiga1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inpt_segitiga1MouseClicked(evt);
            }
        });
        jPanel1.add(inpt_segitiga1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 120, -1));

        label_hasil1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_hasil1.setText("Luas Segitiga =");
        jPanel1.add(label_hasil1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 250, -1));

        jTabbedPane1.addTab("Segitiga", jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(395, 188));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Jari - Jari");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 50, -1));

        inpt_lingkaran1.setText("Input Jari - Jari");
        inpt_lingkaran1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inpt_lingkaran1MouseClicked(evt);
            }
        });
        jPanel2.add(inpt_lingkaran1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 140, -1));

        bt_lingkaran.setText("Hitung");
        bt_lingkaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_lingkaranActionPerformed(evt);
            }
        });
        jPanel2.add(bt_lingkaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        label_hasil2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_hasil2.setText("Luas Lingkaran = ");
        jPanel2.add(label_hasil2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 310, -1));

        jTabbedPane1.addTab("Lingkaran", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Tinggi");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel4.setText("Alas - A");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel5.setText("Alas - B");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        inpt_trapesium3.setText("Tinggi");
        inpt_trapesium3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inpt_trapesium3MouseClicked(evt);
            }
        });
        jPanel3.add(inpt_trapesium3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 150, -1));

        inpt_trapesium1.setText("Input Alas - A");
        inpt_trapesium1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inpt_trapesium1MouseClicked(evt);
            }
        });
        jPanel3.add(inpt_trapesium1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 150, -1));

        inpt_trapesium2.setText("Input Alas - B");
        inpt_trapesium2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inpt_trapesium2MouseClicked(evt);
            }
        });
        jPanel3.add(inpt_trapesium2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 150, -1));

        label_hasil3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_hasil3.setText("Luas Trapesium = ");
        jPanel3.add(label_hasil3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 310, -1));

        btn_trapesium.setText("Hitung");
        btn_trapesium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trapesiumActionPerformed(evt);
            }
        });
        jPanel3.add(btn_trapesium, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jTabbedPane1.addTab("Trapesium", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inpt_segitiga1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inpt_segitiga1MouseClicked
        inpt_segitiga1.setText("");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_inpt_segitiga1MouseClicked

    private void inpt_segitiga2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inpt_segitiga2MouseClicked
        inpt_segitiga2.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_inpt_segitiga2MouseClicked

    private void bt_segitigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_segitigaActionPerformed
        int alas, tinggi;
        
        alas = Integer.parseInt(inpt_segitiga1.getText());
        tinggi = Integer.parseInt(inpt_segitiga2.getText());
        
        int luas_segitiga = (alas * tinggi)/2;
        label_hasil1.setText("Luas Segitiga = " + String.valueOf(luas_segitiga));
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_segitigaActionPerformed

    private void inpt_lingkaran1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inpt_lingkaran1MouseClicked

        inpt_lingkaran1.setText("");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_inpt_lingkaran1MouseClicked

    private void bt_lingkaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_lingkaranActionPerformed
       
        double jari2;
        
        jari2 = Integer.parseInt(inpt_lingkaran1.getText());
        
        double luas_lingkaran = 3.14 * (jari2*jari2);

        label_hasil2.setText("Luas Lingkaran = " + String.valueOf(luas_lingkaran));
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_lingkaranActionPerformed

    private void inpt_trapesium1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inpt_trapesium1MouseClicked
    
        inpt_trapesium1.setText("");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_inpt_trapesium1MouseClicked

    private void inpt_trapesium2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inpt_trapesium2MouseClicked
        

        inpt_trapesium2.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_inpt_trapesium2MouseClicked

    private void inpt_trapesium3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inpt_trapesium3MouseClicked

         inpt_trapesium3.setText("");
        
// TODO add your handling code here:
    }//GEN-LAST:event_inpt_trapesium3MouseClicked

    private void btn_trapesiumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trapesiumActionPerformed

        int a,b,tinggi,luas_trapesium;
        
        a = Integer.parseInt(inpt_trapesium1.getText());
        b = Integer.parseInt(inpt_trapesium2.getText());
        tinggi = Integer.parseInt(inpt_trapesium3.getText());
        
        luas_trapesium = ((a + b) * tinggi)/2;
        
        label_hasil3.setText("Luas Trapesium = " + String.valueOf(luas_trapesium));

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_trapesiumActionPerformed

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
            java.util.logging.Logger.getLogger(latihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(latihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(latihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(latihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new latihan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_lingkaran;
    private javax.swing.JButton bt_segitiga;
    private javax.swing.JButton btn_trapesium;
    private javax.swing.JTextField inpt_lingkaran1;
    private javax.swing.JTextField inpt_segitiga1;
    private javax.swing.JTextField inpt_segitiga2;
    private javax.swing.JTextField inpt_trapesium1;
    private javax.swing.JTextField inpt_trapesium2;
    private javax.swing.JTextField inpt_trapesium3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label_hasil1;
    private javax.swing.JLabel label_hasil2;
    private javax.swing.JLabel label_hasil3;
    // End of variables declaration//GEN-END:variables
}