/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import controller.koneksi;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ariya
 */
public class transaksi extends javax.swing.JFrame {

    String tanggal;
    public DefaultTableModel model;
    
    
    public void totalBiaya(){
        int jumlahBaris = tabel_transaksi.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(tabel_transaksi.getValueAt(i, 5).toString());
            hargaBarang = Integer.parseInt(tabel_transaksi.getValueAt(i, 6).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        txt_total.setText(String.valueOf(totalBiaya));
        scrn_total.setText("Rp "+ totalBiaya +",00");
    }
    
    private void autonumber(){
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM data_transaksi ORDER BY no_transaksi DESC";
            ResultSet r = st.executeQuery(sql);
            if (r.next()) {
                String no_transaksi = r.getString("no_transaksi").substring(2);
                String TR = "" +(Integer.parseInt(no_transaksi)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "000";}
                else if(TR.length()==2)
                {Nol = "00";}
                else if(TR.length()==3)
                {Nol = "0";}
                else if(TR.length()==4)
                {Nol = "";}
                txt_transaksi.setText("TR" + Nol + TR);

            } else {
                txt_transaksi.setText("TR0001");
            }
            r.close();
            st.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }
    
    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) tabel_transaksi.getModel();
        model.addRow(new Object[]{
            txt_transaksi.getText(),
            txt_idcust.getText(),
            txt_namacust.getText(),
            txt_idmenu.getText(),
            txt_namamenu.getText(),
            txt_jumlahbarang.getText(),
            txt_hargamenu.getText(),
            txt_total.getText()
        });
    }
    
    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) tabel_transaksi.getModel();
        
        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    
    public void utama(){
        txt_transaksi.setText("");
        txt_idmenu.setText("");
        txt_namamenu.setText("");
        txt_hargamenu.setText("");
        txt_jumlahbarang.setText("");
        autonumber();
    }
    
    public void clear(){
        txt_idcust.setText("");
        txt_namacust.setText("");
        scrn_total.setText("0");
        scrn_pembayaran.setText("0");
        txt_kembalian.setText("Rp 0");
        txt_total.setText("Rp 0");
    }
    
    public void clear2(){
        txt_idmenu.setText("");
        txt_namamenu.setText("");
        txt_hargamenu.setText("");
        txt_jumlahbarang.setText("");
    }
    
    public void tambahTransaksi(){
        int jumlah, harga, total;
        
        jumlah = Integer.valueOf(txt_jumlahbarang.getText());
        harga = Integer.valueOf(txt_hargamenu.getText());
        total = jumlah * harga;
        
        txt_total.setText(String.valueOf(total));
        
        loadData();
        totalBiaya();
        clear2();
        txt_idmenu.requestFocus();
    }
    
    public transaksi() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2 - this.getSize().height/2);
        

        model = new DefaultTableModel();
        
        tabel_transaksi.setModel(model);
        
        model.addColumn("No Transaksi");
        model.addColumn("ID Customer");
        model.addColumn("Nama Customer");
        model.addColumn("ID Menu");
        model.addColumn("Nama Menu");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total");
        
        utama();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        
        txt_tanggal.setText(s.format(date));
        txt_total.setText("0");
        scrn_pembayaran.setText("0");
        txt_kembalian.setText("Rp 0");
        txt_idcust.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        scrn_total = new javax.swing.JTextField();
        scrn_pembayaran = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txt_transaksi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_idcust = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_namacust = new javax.swing.JTextField();
        txt_idmenu = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_namamenu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_hargamenu = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_jumlahbarang = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_bayar = new javax.swing.JButton();
        txt_tanggal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_kembalian = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menu_laporan = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rumah Makan Rizki");
        setFocusCycleRoot(false);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        setMaximumSize(new java.awt.Dimension(880, 461));
        setMinimumSize(new java.awt.Dimension(880, 461));
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Total Payment");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Total Bill");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 80, -1));

        scrn_total.setBackground(new java.awt.Color(255, 99, 99));
        scrn_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        scrn_total.setText("Rp 0");
        jPanel2.add(scrn_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 188, 41));

        scrn_pembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scrn_pembayaranActionPerformed(evt);
            }
        });
        jPanel2.add(scrn_pembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 160, -1));

        tabel_transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_transaksi);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 640, 270));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("No. Transaction");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 20));

        txt_transaksi.setEnabled(false);
        jPanel2.add(txt_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 160, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("ID Customer");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 20));

        txt_idcust.setEnabled(false);
        jPanel2.add(txt_idcust, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 90, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Nama Customer");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 20));

        txt_namacust.setEnabled(false);
        jPanel2.add(txt_namacust, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 160, -1));

        txt_idmenu.setEnabled(false);
        jPanel2.add(txt_idmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 90, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("ID Menu");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 20));

        txt_namamenu.setEnabled(false);
        jPanel2.add(txt_namamenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 160, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Nama Menu");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Harga Menu");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 20));

        txt_hargamenu.setEnabled(false);
        jPanel2.add(txt_hargamenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 160, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Jumlah Pesanan");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 20));

        txt_jumlahbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahbarangActionPerformed(evt);
            }
        });
        jPanel2.add(txt_jumlahbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 160, -1));

        btn_tambah.setText("Tambahkan");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_bayar.setText("Bayar");
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(btn_bayar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btn_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 110, 160));

        txt_tanggal.setText("tanggal");
        jPanel2.add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, -1, -1));

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 60, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel1.setText("RUMAH MAKAN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel4.setText("RIZKI");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jLabel5.setText("Kembalian");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, -1, 20));

        jLabel6.setText("Total Bayar");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, 20));

        txt_kembalian.setEnabled(false);
        jPanel2.add(txt_kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 400, 150, -1));

        txt_total.setEnabled(false);
        jPanel2.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 140, -1));

        jButton2.setText("Cari");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 60, -1));

        jMenu3.setText("File");

        jMenuItem1.setText("Data Menu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Data Customer");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        menu_laporan.setText("Laporan");
        menu_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_laporanActionPerformed(evt);
            }
        });
        jMenu3.add(menu_laporan);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar3.add(jMenu3);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Kasir Ayam Bakar PA 'CE'");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void txt_jumlahbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahbarangActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_txt_jumlahbarangActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabel_transaksi.getModel();
        int row = tabel_transaksi.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
        scrn_pembayaran.setText("0");
        txt_kembalian.setText("Rp 0");
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void scrn_pembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scrn_pembayaranActionPerformed
        // TODO add your handling code here:
        int total, bayar, kembalian = 0;
        
        total = Integer.valueOf(txt_total.getText());
        bayar = Integer.valueOf(scrn_pembayaran.getText());
            
        if (total > bayar) {
            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk melakukan pembayaran");
        } else {
            kembalian = bayar - total;
            
            JOptionPane.showMessageDialog(null, "kembalian "
                    + "\n\n Rp" + kembalian);
        }
        txt_kembalian.setText(String.valueOf("Rp " + kembalian));
        
    }//GEN-LAST:event_scrn_pembayaranActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        data_menu a = new data_menu();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        list_menu a = new list_menu();
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        list_pelanggan a = new list_pelanggan();
        a.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        data_pelanggan a = new data_pelanggan();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabel_transaksi.getModel();
        int total, bayar, kembalian = 0;
        
        total = Integer.valueOf(txt_total.getText());
        bayar = Integer.valueOf(scrn_pembayaran.getText());
            
        if (total > bayar) {
            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk melakukan pembayaran");
        } else {
            kembalian = bayar - total;
            
            JOptionPane.showMessageDialog(null, "kembalian "
                    + "\n\n Rp" + kembalian);
        }

        txt_kembalian.setText(String.valueOf("Rp " + kembalian));

        String no_faktur = txt_transaksi.getText();
        String tanggal = txt_tanggal.getText();
        String idCustomer = txt_idcust.getText();
        String total2 = txt_total.getText();
        
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "INSERT INTO data_transaksi VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, no_faktur);
            ps.setString(2, tanggal);
            ps.setString(3, idCustomer);
            ps.setString(4, total2);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "simpan penjualan error");
        }
        
        try {
            Connection con = koneksi.getKoneksi();
            int baris = tabel_transaksi.getRowCount();
            
            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO data_transaksi_rinci(no_transaksi, id_menu, nama_menu, jumlah, harga, total) VALUES('"
                        + tabel_transaksi.getValueAt(i, 0) +"','"
                        + tabel_transaksi.getValueAt(i, 3) +"','"
                        + tabel_transaksi.getValueAt(i, 4) +"','"
                        + tabel_transaksi.getValueAt(i, 5) +"','"
                        + tabel_transaksi.getValueAt(i, 6) +"','"
                        + tabel_transaksi.getValueAt(i, 7) +"')";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.executeUpdate();
                ps.close();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "simpan penjualan rinci error");
           
        }
        clear();
        utama();
        autonumber();
        kosong();
        scrn_total.setText("Rp 0");
        JOptionPane.showMessageDialog(null, "Pembayaran Selesai");
    }//GEN-LAST:event_btn_bayarActionPerformed

    private void menu_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_laporanActionPerformed
        // TODO add your handling code here:
        laporan a = new laporan();
        a.setVisible(true);
    }//GEN-LAST:event_menu_laporanActionPerformed

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
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menu_laporan;
    public javax.swing.JTextField scrn_pembayaran;
    public javax.swing.JTextField scrn_total;
    public javax.swing.JTable tabel_transaksi;
    public static javax.swing.JTextField txt_hargamenu;
    public static javax.swing.JTextField txt_idcust;
    public static javax.swing.JTextField txt_idmenu;
    private javax.swing.JTextField txt_jumlahbarang;
    private javax.swing.JTextField txt_kembalian;
    public static javax.swing.JTextField txt_namacust;
    public static javax.swing.JTextField txt_namamenu;
    private javax.swing.JLabel txt_tanggal;
    private javax.swing.JTextField txt_total;
    public javax.swing.JTextField txt_transaksi;
    // End of variables declaration//GEN-END:variables
}
