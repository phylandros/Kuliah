/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import controller.koneksi;
import gui.employee_gui;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ariya
 */
public class departement_form extends javax.swing.JFrame {

    /**
     * Creates new form departement_form
     */
    
    koneksi con = new koneksi();
    ResultSet rs;
    DefaultTableModel dt;

     
    public departement_form() {
        initComponents();
        removeTable(tabel_show_dept);
        displayTable();
    }
    
    void removeTable(JTable jt) {

        dt = (DefaultTableModel) tabel_show_dept.getModel();
        int rowCount = dt.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            dt.removeRow(0);
        }
    }

    void displayTable() {

        removeTable(tabel_show_dept);
        String sql = "SELECT * FROM departement";
        System.out.println("SQL : " + sql);
        rs = con.lihatData(sql);
        DefaultTableModel dt = (DefaultTableModel) tabel_show_dept.getModel();
        Object rows[];
        try {
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String depcode = rs.getString("deptcode");
                String depname = rs.getString("deptname");
                String deploka = rs.getString("location");
                
                
                rows = new Object[]{id, depcode, depname, deploka};
                dt.addRow(rows);
        
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inp_namdep = new javax.swing.JTextField();
        inp_kode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        inp_lokdep = new javax.swing.JTextArea();
        bt_update = new javax.swing.JButton();
        bt_insert = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        bt_search = new javax.swing.JButton();
        inp_search = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_show_dept = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Departement Form");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, -1));

        jLabel2.setText("Lokasi Departement");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 30));

        jLabel3.setText("Kode Departement");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 30));

        jLabel4.setText("Nama Departement");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 30));
        jPanel1.add(inp_namdep, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 350, -1));
        jPanel1.add(inp_kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 350, -1));

        inp_lokdep.setColumns(20);
        inp_lokdep.setRows(5);
        jScrollPane1.setViewportView(inp_lokdep);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 350, -1));

        bt_update.setText("Update");
        jPanel1.add(bt_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 90, -1));

        bt_insert.setText("Insert");
        bt_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_insertActionPerformed(evt);
            }
        });
        jPanel1.add(bt_insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 80, -1));

        bt_delete.setText("Delete");
        jPanel1.add(bt_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 90, -1));

        bt_search.setText("Search");
        jPanel1.add(bt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 90, -1));
        jPanel1.add(inp_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 160, -1));

        tabel_show_dept.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Dept. Kode", "Dept. Name", "Dept. Lokasi"
            }
        ));
        jScrollPane3.setViewportView(tabel_show_dept);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 550, 180));

        jMenu1.setText("Departement");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Employee");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        new departement_form().setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        new employee_gui().setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void bt_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_insertActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "insert into departement(deptcode,deptname,location)"
                    + "VALUES ('" + inp_kode.getText() + "','" + inp_namdep.getText() + "','" + inp_lokdep.getText() + "')";

            System.out.println("SQL : " + sql);
            con.dmlData(sql);            
            displayTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error :" + e);
        }
    }//GEN-LAST:event_bt_insertActionPerformed

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
            java.util.logging.Logger.getLogger(departement_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(departement_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(departement_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(departement_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new departement_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_insert;
    private javax.swing.JButton bt_search;
    private javax.swing.JButton bt_update;
    private javax.swing.JTextField inp_kode;
    private javax.swing.JTextArea inp_lokdep;
    private javax.swing.JTextField inp_namdep;
    private javax.swing.JTextField inp_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabel_show_dept;
    // End of variables declaration//GEN-END:variables
}