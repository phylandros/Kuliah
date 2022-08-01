/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

//Folder
import controller.koneksi;
import static gui.login.inp_username;
//Library
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ariyansa
 */
public class dashboard extends javax.swing.JFrame {

    String username = inp_username.getText();
    koneksi con = new koneksi();
    ResultSet rs;
    Statement stmt;
    String kode_buku, kode_anggota, kode_pengembalian, kode_peminjaman, kode_petugas;
    String Buku_Kode, Anggota_Kode, Petugas_Kode, gender;

    void removeTable(JTable jt) {
        DefaultTableModel dt = (DefaultTableModel) jt.getModel();
        int rowCount = dt.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            dt.removeRow(0);
        }
    }

    class Item {

        private String id;
        private String description;

        public Item(String id, String description) {
            this.id = id;
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public String toString() {
            return description;
        }
    }

    public void addBuku(JComboBox cmb) {

        cmb.removeAllItems();
        try {
            cmb.removeAllItems();
            cmb.addItem("-- Pilih Buku --");
            String query = "SELECT * FROM data_buku";
            rs = con.lihatData(query);
            while (rs.next()) {
                String idCmb = rs.getString("kode_buku");
                String Txtcmb = rs.getString("judul_buku").trim();
                Item comboItem = new Item(idCmb, Txtcmb);
                cmb.addItem(comboItem);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    void initMethod() {
        cb_buku_peminjaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JComboBox jc1 = (JComboBox) arg0.getSource();
                Item item_buku_peminjaman = (Item) jc1.getSelectedItem();
                Buku_Kode = item_buku_peminjaman.getId();
            }
        });

        cb_anggota_peminjaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JComboBox jc2 = (JComboBox) arg0.getSource();
                Item item_anggota_peminjaman = (Item) jc2.getSelectedItem();
                Anggota_Kode = item_anggota_peminjaman.getId();
            }
        });

        cb_petugas_peminjaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JComboBox jc3 = (JComboBox) arg0.getSource();
                Item item_petugas_peminjaman = (Item) jc3.getSelectedItem();
                Petugas_Kode = item_petugas_peminjaman.getId();
            }
        });
    }

    public void addAnggota(JComboBox cmb) {
        cmb.removeAllItems();
        try {
            cmb.removeAllItems();
            cmb.addItem("-- Pilih Anggota --");
            String query = "SELECT * FROM data_anggota";
            rs = con.lihatData(query);
            while (rs.next()) {
                String Txtcmb = rs.getString("nama_anggota").trim();
                String idCmb = rs.getString("kode_anggota");
                Item comboItem = new Item(idCmb, Txtcmb);
                cmb.addItem(comboItem);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public void addPetugas(JComboBox cmb) {
        cmb.removeAllItems();
        try {
            cmb.removeAllItems();
            cmb.addItem("-- Pilih Petugas --");
            String query = "SELECT * FROM data_petugas";
            rs = con.lihatData(query);
            while (rs.next()) {
                String Txtcmb = rs.getString("nama").trim();
                String idCmb = rs.getString("kode_petugas");
                Item comboItem = new Item(idCmb, Txtcmb);
                cmb.addItem(comboItem);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    void displayTableDataBuku() {
        removeTable(tabel_databuku);
        String sql = "SELECT * FROM data_buku";
        rs = con.lihatData(sql);
        DefaultTableModel dt = (DefaultTableModel) tabel_databuku.getModel();
        Object rows[];
        try {
            while (rs.next()) {
                kode_buku = rs.getString("kode_buku");
                String judul_buku = rs.getString("judul_buku");
                String penulis = rs.getString("penulis");
                String tahun_penerbit = rs.getString("tahun_penerbit");

                rows = new Object[]{kode_buku, judul_buku, penulis, tahun_penerbit};
                dt.addRow(rows);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }

    void displayTableAnggota() {
        removeTable(tabel_anggota);
        String sql = "SELECT * FROM data_anggota";
        rs = con.lihatData(sql);
        DefaultTableModel dt = (DefaultTableModel) tabel_anggota.getModel();
        Object rows[];
        try {
            while (rs.next()) {
                kode_buku = rs.getString("kode_anggota");
                String npm_anggota = rs.getString("npm_anggota");
                String nama_anggota = rs.getString("nama_anggota");
                String jenis_kelamin_anggota = rs.getString("jenis_kelamin_anggota");
                String jurusan_anggota = rs.getString("jurusan_anggota");
                String alamat_anggota = rs.getString("alamat_anggota");
                String no_hp_anggota = rs.getString("no_hp_anggota");

                rows = new Object[]{kode_buku, npm_anggota, nama_anggota, jenis_kelamin_anggota, jurusan_anggota, alamat_anggota, no_hp_anggota};
                dt.addRow(rows);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }

    void tabel_buku() {
        JTableHeader header_buku = tabel_databuku.getTableHeader();
        header_buku.setFont(new Font("Seqoe UI", Font.BOLD, 13));
        header_buku.setBackground(new Color(102, 102, 102));
    }

    void tabel_peminjaman() {
        JTableHeader header_buku = tabel_peminjaman.getTableHeader();
        header_buku.setFont(new Font("Seqoe UI", Font.BOLD, 12));
        header_buku.setBackground(new Color(102, 102, 102));
    }

    void displayTablePeminjaman() {
        removeTable(tabel_peminjaman);
        String sql = "SELECT p.kode_peminjaman, b.judul_buku, a.nama_anggota, pt.nama, p.tanggal_pinjam, p.tanggal_kembali\n"
                + "FROM data_peminjaman p\n"
                + "JOIN data_petugas pt ON p.kode_petugas = pt.kode_petugas\n"
                + "JOIN data_anggota a ON p.kode_anggota = a.kode_anggota\n"
                + "JOIN data_buku b ON p.kode_buku = b.kode_buku";
        rs = con.lihatData(sql);
        DefaultTableModel dt = (DefaultTableModel) tabel_peminjaman.getModel();
        Object rows[];
        try {
            while (rs.next()) {
                kode_peminjaman = rs.getString("kode_peminjaman");
                String kode_buku = rs.getString("judul_buku");
                String kode_anggota = rs.getString("nama_anggota");
                String kode_petugas = rs.getString("nama");
                String tanggal_pinjam = rs.getString("tanggal_pinjam");
                String tanggal_kembali = rs.getString("tanggal_kembali");

                rows = new Object[]{kode_peminjaman, kode_buku, kode_anggota, kode_petugas, tanggal_pinjam, tanggal_kembali};
                dt.addRow(rows);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }

    public void bookcount() {
        String sql = "SELECT COUNT(*) as Jumlah_Buku FROM data_buku;";
        rs = con.lihatData(sql);
        try {
            while (rs.next()) {
                int count = rs.getInt("Jumlah_Buku");
                label_jumlahbuku.setText(String.valueOf(count));
            }
        } catch (SQLException ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form dashboard
     */
    public dashboard() {
        initComponents();
        bookcount();
        tabel_buku();
        tabel_peminjaman();
        addBuku(cb_buku_peminjaman);
        addAnggota(cb_anggota_peminjaman);
        addPetugas(cb_petugas_peminjaman);
        removeTable(tabel_databuku);
        removeTable(tabel_peminjaman);
        displayTablePeminjaman();
        displayTableDataBuku();
        displayTableAnggota();
        panel_dashboard.show();
        panel_databuku.hide();
        panel_peminjaman.hide();
        panel_dataanggota.hide();
        panel_datapengembalian.hide();
        initMethod();
        AutoCompleteDecorator.decorate(cb_buku_peminjaman);
        AutoCompleteDecorator.decorate(cb_anggota_peminjaman);
        AutoCompleteDecorator.decorate(cb_petugas_peminjaman);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jenis_kelamin = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panel_menu = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        image_logo = new javax.swing.JLabel();
        bt_menu_dashboard = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        bt_menu_pinjam = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        bt_menu_buku = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        bt_logout_menu = new javax.swing.JLabel();
        bt_menu_pengembalian = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        bt_menu_anggota = new javax.swing.JPanel();
        label_anggota = new javax.swing.JLabel();
        panel_header = new javax.swing.JPanel();
        bt_exit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_dashboard = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        label_pengunjung = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        label_peminjaman = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        label_jumlahbuku = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        bt_next_dashboard = new javax.swing.JLabel();
        panel_databuku = new javax.swing.JPanel();
        inp_penulis = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        inp_tahunpenerbit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_databuku = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        bt_insert_databuku = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        bt_delete_databuku = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        bt_update_databuku = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        inp_judulbuku = new javax.swing.JTextField();
        bt_next_databuku = new javax.swing.JLabel();
        bt_back_databuku = new javax.swing.JLabel();
        panel_peminjaman = new javax.swing.JPanel();
        bt_next_peminjaman = new javax.swing.JLabel();
        inp_tgl_pinjam = new com.toedter.calendar.JDateChooser();
        inp_tgl_kembali = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        bt_insert_peminjaman = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        bt_update_peminjaman = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        bt_delete_peminjaman = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        bt_back_peminjaman = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabel_peminjaman = new javax.swing.JTable();
        cb_buku_peminjaman = new javax.swing.JComboBox<>();
        cb_anggota_peminjaman = new javax.swing.JComboBox<>();
        cb_petugas_peminjaman = new javax.swing.JComboBox<>();
        panel_dataanggota = new javax.swing.JPanel();
        inp_npm_anggota = new javax.swing.JTextField();
        inp_nama_anggota = new javax.swing.JTextField();
        rb_pria = new javax.swing.JRadioButton();
        rb_wanita = new javax.swing.JRadioButton();
        inp_jurusan_anggota = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        inp_alamat_anggota = new javax.swing.JTextArea();
        inp_notlp_anggota = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        bt_next_anggota = new javax.swing.JLabel();
        bt_back_anggota = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabel_anggota = new javax.swing.JTable();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        bt_insert_anggota = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        bt_update_anggota = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        bt_delete_anggota = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        panel_datapengembalian = new javax.swing.JPanel();
        inp_tanggalkembali_pengembalian = new com.toedter.calendar.JDateChooser();
        inp_denda_pengembalian = new javax.swing.JTextField();
        inp_totalhari_pengembalian = new javax.swing.JTextField();
        inp_totaldenda_pengembalian = new javax.swing.JTextField();
        inp_kodebuku_pengembalian = new javax.swing.JTextField();
        inp_kodeanggota_pengembalian = new javax.swing.JTextField();
        inp_kodepetugas_pengembalian = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        bt_back_pengembalian = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabel_pengembalian = new javax.swing.JTable();
        bt_insert_pengembalian = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        bt_update_pengembalian = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        bt_delete_pengembalian = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perpustakaan STMIK BANI SALEH");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_menu.setBackground(new java.awt.Color(102, 102, 102));
        panel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Dashboard");
        panel_menu.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        image_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo_kecil.png"))); // NOI18N
        panel_menu.add(image_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 270, 140));

        label_username.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_username.setForeground(new java.awt.Color(255, 255, 255));
        label_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_username.setText(" ");
        panel_menu.add(label_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 270, -1));

        bt_menu_dashboard.setBackground(new java.awt.Color(102, 102, 102));
        bt_menu_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        bt_menu_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_menu_dashboardMouseClicked(evt);
            }
        });
        bt_menu_dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_home_page_20px.png"))); // NOI18N
        jLabel12.setText("Dashboard");
        bt_menu_dashboard.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panel_menu.add(bt_menu_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 250, 40));

        bt_menu_pinjam.setBackground(new java.awt.Color(102, 102, 102));
        bt_menu_pinjam.setForeground(new java.awt.Color(255, 255, 255));
        bt_menu_pinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_menu_pinjamMouseClicked(evt);
            }
        });
        bt_menu_pinjam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_open_box_20px.png"))); // NOI18N
        jLabel13.setText("Peminjaman");
        bt_menu_pinjam.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panel_menu.add(bt_menu_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 250, 40));

        bt_menu_buku.setBackground(new java.awt.Color(102, 102, 102));
        bt_menu_buku.setForeground(new java.awt.Color(255, 255, 255));
        bt_menu_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_menu_bukuMouseClicked(evt);
            }
        });
        bt_menu_buku.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_book_shelf_20px.png"))); // NOI18N
        jLabel14.setText("Data Buku");
        bt_menu_buku.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panel_menu.add(bt_menu_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 250, 40));

        logout.setBackground(new java.awt.Color(102, 102, 102));
        logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_logout_menu.setBackground(new java.awt.Color(102, 102, 102));
        bt_logout_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_logout_menu.setForeground(new java.awt.Color(255, 255, 255));
        bt_logout_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_logout_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_logout_20px.png"))); // NOI18N
        bt_logout_menu.setText("Logout");
        bt_logout_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_logout_menuMouseClicked(evt);
            }
        });
        logout.add(bt_logout_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        panel_menu.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 610, 80, 30));

        label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("Nama Pengguna");
        panel_menu.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 270, -1));

        bt_menu_pengembalian.setBackground(new java.awt.Color(102, 102, 102));
        bt_menu_pengembalian.setForeground(new java.awt.Color(255, 255, 255));
        bt_menu_pengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_menu_pengembalianMouseClicked(evt);
            }
        });
        bt_menu_pengembalian.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_inbox_20px.png"))); // NOI18N
        jLabel20.setText("Pengembalian");
        bt_menu_pengembalian.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panel_menu.add(bt_menu_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 250, 40));

        bt_menu_anggota.setBackground(new java.awt.Color(102, 102, 102));
        bt_menu_anggota.setForeground(new java.awt.Color(255, 255, 255));
        bt_menu_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_menu_anggotaMouseClicked(evt);
            }
        });
        bt_menu_anggota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_anggota.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_anggota.setForeground(new java.awt.Color(255, 255, 255));
        label_anggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_people_20px.png"))); // NOI18N
        label_anggota.setText("Data Anggota");
        bt_menu_anggota.add(label_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panel_menu.add(bt_menu_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 250, 40));

        jPanel1.add(panel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 660));

        panel_header.setBackground(new java.awt.Color(102, 102, 102));
        panel_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_x_20px.png"))); // NOI18N
        bt_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_exitMouseClicked(evt);
            }
        });
        panel_header.add(bt_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PERPUSTAKAAN");
        panel_header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 790, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STMIK BANI SALEH");
        panel_header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 790, -1));

        jPanel1.add(panel_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 790, 200));

        panel_dashboard.setBackground(new java.awt.Color(255, 255, 255));
        panel_dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_people_30px.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        label_pengunjung.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_pengunjung.setForeground(new java.awt.Color(255, 255, 255));
        label_pengunjung.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_pengunjung.setText("jLabel19");
        jPanel2.add(label_pengunjung, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 130, 50));

        panel_dashboard.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 180, 50));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_outbox_30px.png"))); // NOI18N
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        label_peminjaman.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_peminjaman.setForeground(new java.awt.Color(255, 255, 255));
        label_peminjaman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_peminjaman.setText("jLabel19");
        jPanel6.add(label_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 130, 50));

        panel_dashboard.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 180, 50));

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_book_30px.png"))); // NOI18N
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        label_jumlahbuku.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_jumlahbuku.setForeground(new java.awt.Color(255, 255, 255));
        label_jumlahbuku.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_jumlahbuku.setText("jLabel19");
        jPanel7.add(label_jumlahbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 130, 50));

        panel_dashboard.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 180, 50));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Buku Dipinjam");
        panel_dashboard.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 180, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Anggota Terdaftar");
        panel_dashboard.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Jumlah Buku");
        panel_dashboard.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 180, -1));

        label_dashboard.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_dashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_dashboard.setText("Nama Pengguna");
        panel_dashboard.add(label_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 800, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("SELAMAT DATANG");
        panel_dashboard.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 40, 800, -1));

        bt_next_dashboard.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_next_dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_next_page_30px_1.png"))); // NOI18N
        bt_next_dashboard.setText("Next");
        bt_next_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_next_dashboardMouseClicked(evt);
            }
        });
        panel_dashboard.add(bt_next_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, -1, -1));

        jPanel1.add(panel_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 800, 420));

        panel_databuku.setBackground(new java.awt.Color(255, 255, 255));
        panel_databuku.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inp_penulis.setBorder(null);
        panel_databuku.add(inp_penulis, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 140, 20));

        jLabel8.setText("Judul Buku");
        panel_databuku.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        jLabel9.setText("Tahun Penerbit");
        panel_databuku.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        inp_tahunpenerbit.setBorder(null);
        panel_databuku.add(inp_tahunpenerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 140, 20));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jScrollPane1.setToolTipText("");
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tabel_databuku.setAutoCreateRowSorter(true);
        tabel_databuku.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tabel_databuku.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabel_databuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Buku", "Judul Buku", "Penulis", "Tahun Penerbit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_databuku.setToolTipText("");
        tabel_databuku.setFillsViewportHeight(true);
        tabel_databuku.setFocusable(false);
        tabel_databuku.setGridColor(new java.awt.Color(102, 102, 102));
        tabel_databuku.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_databuku.setRowHeight(30);
        tabel_databuku.setRowMargin(0);
        tabel_databuku.setShowGrid(true);
        tabel_databuku.setShowVerticalLines(false);
        tabel_databuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_databukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_databuku);
        if (tabel_databuku.getColumnModel().getColumnCount() > 0) {
            tabel_databuku.getColumnModel().getColumn(0).setResizable(false);
            tabel_databuku.getColumnModel().getColumn(0).setPreferredWidth(15);
            tabel_databuku.getColumnModel().getColumn(1).setResizable(false);
            tabel_databuku.getColumnModel().getColumn(2).setResizable(false);
            tabel_databuku.getColumnModel().getColumn(3).setResizable(false);
        }

        panel_databuku.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 490, 320));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        panel_databuku.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, 10));

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        panel_databuku.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 140, 10));

        bt_insert_databuku.setBackground(new java.awt.Color(255, 255, 255));
        bt_insert_databuku.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt_insert_databuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_insert_databukuMouseClicked(evt);
            }
        });
        bt_insert_databuku.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Insert");
        bt_insert_databuku.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panel_databuku.add(bt_insert_databuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 70, 30));

        bt_delete_databuku.setBackground(new java.awt.Color(255, 255, 255));
        bt_delete_databuku.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt_delete_databuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_delete_databukuMouseClicked(evt);
            }
        });
        bt_delete_databuku.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Delete");
        bt_delete_databuku.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panel_databuku.add(bt_delete_databuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 70, 30));

        bt_update_databuku.setBackground(new java.awt.Color(255, 255, 255));
        bt_update_databuku.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt_update_databuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_update_databukuMouseClicked(evt);
            }
        });
        bt_update_databuku.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Update");
        bt_update_databuku.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panel_databuku.add(bt_update_databuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 70, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("DATA BUKU");
        panel_databuku.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 490, -1));

        jLabel11.setText("Penulis");
        panel_databuku.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        panel_databuku.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 140, 10));

        inp_judulbuku.setBorder(null);
        panel_databuku.add(inp_judulbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 49, 140, 20));

        bt_next_databuku.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_next_databuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_next_page_30px_1.png"))); // NOI18N
        bt_next_databuku.setText("Next");
        bt_next_databuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_next_databukuMouseClicked(evt);
            }
        });
        panel_databuku.add(bt_next_databuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, -1, -1));

        bt_back_databuku.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_back_databuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_back_to_30px.png"))); // NOI18N
        bt_back_databuku.setText("Back");
        bt_back_databuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_back_databukuMouseClicked(evt);
            }
        });
        panel_databuku.add(bt_back_databuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, -1, -1));

        jPanel1.add(panel_databuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 800, 420));

        panel_peminjaman.setBackground(new java.awt.Color(255, 255, 255));
        panel_peminjaman.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_next_peminjaman.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_next_peminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_next_page_30px_1.png"))); // NOI18N
        bt_next_peminjaman.setText("Next");
        bt_next_peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_next_peminjamanMouseClicked(evt);
            }
        });
        panel_peminjaman.add(bt_next_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, -1, -1));

        inp_tgl_pinjam.setBackground(new java.awt.Color(255, 255, 255));
        inp_tgl_pinjam.setOpaque(false);
        panel_peminjaman.add(inp_tgl_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 140, -1));

        inp_tgl_kembali.setBackground(new java.awt.Color(255, 255, 255));
        panel_peminjaman.add(inp_tgl_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 140, -1));

        jLabel7.setText("Tanggal Pinjam");
        panel_peminjaman.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel25.setText("Tanggal Kembali");
        panel_peminjaman.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel27.setText("Kode Buku");
        panel_peminjaman.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel28.setText("Kode Anggota");
        panel_peminjaman.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel29.setText("Kode Petugas");
        panel_peminjaman.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        bt_insert_peminjaman.setBackground(new java.awt.Color(255, 255, 255));
        bt_insert_peminjaman.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt_insert_peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_insert_peminjamanMouseClicked(evt);
            }
        });
        bt_insert_peminjaman.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Insert");
        bt_insert_peminjaman.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        panel_peminjaman.add(bt_insert_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 70, 30));

        bt_update_peminjaman.setBackground(new java.awt.Color(255, 255, 255));
        bt_update_peminjaman.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt_update_peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_update_peminjamanMouseClicked(evt);
            }
        });
        bt_update_peminjaman.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Update");
        bt_update_peminjaman.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panel_peminjaman.add(bt_update_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 70, 30));

        bt_delete_peminjaman.setBackground(new java.awt.Color(255, 255, 255));
        bt_delete_peminjaman.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt_delete_peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_delete_peminjamanMouseClicked(evt);
            }
        });
        bt_delete_peminjaman.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Delete");
        bt_delete_peminjaman.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panel_peminjaman.add(bt_delete_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 70, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("DATA PEMINJAMAN");
        panel_peminjaman.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 490, -1));

        bt_back_peminjaman.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_back_peminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_back_to_30px.png"))); // NOI18N
        bt_back_peminjaman.setText("Back");
        bt_back_peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_back_peminjamanMouseClicked(evt);
            }
        });
        panel_peminjaman.add(bt_back_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, -1, -1));

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jScrollPane6.setToolTipText("");
        jScrollPane6.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jScrollPane6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tabel_peminjaman.setAutoCreateRowSorter(true);
        tabel_peminjaman.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tabel_peminjaman.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabel_peminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Peminjaman", "Judul Buku", "Nama Anggota", "Nama Petugas", "Tanggal Pinjam", "Tanggal Kembali"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_peminjaman.setToolTipText("");
        tabel_peminjaman.setFillsViewportHeight(true);
        tabel_peminjaman.setFocusable(false);
        tabel_peminjaman.setGridColor(new java.awt.Color(102, 102, 102));
        tabel_peminjaman.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_peminjaman.setRowHeight(30);
        tabel_peminjaman.setShowGrid(true);
        tabel_peminjaman.setShowVerticalLines(false);
        tabel_peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_peminjamanMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabel_peminjaman);
        if (tabel_peminjaman.getColumnModel().getColumnCount() > 0) {
            tabel_peminjaman.getColumnModel().getColumn(0).setResizable(false);
            tabel_peminjaman.getColumnModel().getColumn(1).setResizable(false);
            tabel_peminjaman.getColumnModel().getColumn(2).setResizable(false);
            tabel_peminjaman.getColumnModel().getColumn(3).setResizable(false);
            tabel_peminjaman.getColumnModel().getColumn(4).setResizable(false);
            tabel_peminjaman.getColumnModel().getColumn(5).setResizable(false);
        }

        panel_peminjaman.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 500, 320));

        cb_buku_peminjaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_buku_peminjaman.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cb_buku_peminjaman.setFocusable(false);
        panel_peminjaman.add(cb_buku_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 140, -1));

        cb_anggota_peminjaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel_peminjaman.add(cb_anggota_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 140, -1));

        cb_petugas_peminjaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel_peminjaman.add(cb_petugas_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 140, -1));

        jPanel1.add(panel_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 800, 420));

        panel_dataanggota.setBackground(new java.awt.Color(255, 255, 255));
        panel_dataanggota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inp_npm_anggota.setBorder(null);
        panel_dataanggota.add(inp_npm_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 170, -1));

        inp_nama_anggota.setBorder(null);
        panel_dataanggota.add(inp_nama_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));

        rb_pria.setBackground(new java.awt.Color(255, 255, 255));
        jenis_kelamin.add(rb_pria);
        rb_pria.setText("Pria");
        panel_dataanggota.add(rb_pria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        rb_wanita.setBackground(new java.awt.Color(255, 255, 255));
        jenis_kelamin.add(rb_wanita);
        rb_wanita.setText("Wanita");
        panel_dataanggota.add(rb_wanita, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        inp_jurusan_anggota.setBorder(null);
        panel_dataanggota.add(inp_jurusan_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 170, -1));

        inp_alamat_anggota.setColumns(20);
        inp_alamat_anggota.setForeground(new java.awt.Color(102, 102, 102));
        inp_alamat_anggota.setRows(5);
        inp_alamat_anggota.setBorder(null);
        jScrollPane3.setViewportView(inp_alamat_anggota);

        panel_dataanggota.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 170, 100));

        inp_notlp_anggota.setBorder(null);
        panel_dataanggota.add(inp_notlp_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 170, -1));

        jLabel19.setText("NPM");
        panel_dataanggota.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel35.setText("Nama");
        panel_dataanggota.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel36.setText("Jenis Kelamin");
        panel_dataanggota.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel37.setText("Jurusan");
        panel_dataanggota.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel38.setText("Alamat");
        panel_dataanggota.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel39.setText("No Telpon");
        panel_dataanggota.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        bt_next_anggota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_next_anggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_next_page_30px_1.png"))); // NOI18N
        bt_next_anggota.setText("Next");
        bt_next_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_next_anggotaMouseClicked(evt);
            }
        });
        panel_dataanggota.add(bt_next_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, -1, -1));

        bt_back_anggota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_back_anggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_back_to_30px.png"))); // NOI18N
        bt_back_anggota.setText("Back");
        bt_back_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_back_anggotaMouseClicked(evt);
            }
        });
        panel_dataanggota.add(bt_back_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, -1, -1));

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jScrollPane7.setToolTipText("");
        jScrollPane7.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jScrollPane7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tabel_anggota.setAutoCreateRowSorter(true);
        tabel_anggota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tabel_anggota.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabel_anggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Anggota", "NPM", "Nama", "Jenis Kelamin", "Jurusan", "Alamat", "No. Telpon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_anggota.setToolTipText("");
        tabel_anggota.setFillsViewportHeight(true);
        tabel_anggota.setFocusable(false);
        tabel_anggota.setGridColor(new java.awt.Color(102, 102, 102));
        tabel_anggota.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_anggota.setRowHeight(30);
        tabel_anggota.setShowGrid(true);
        tabel_anggota.setShowVerticalLines(false);
        tabel_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_anggotaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabel_anggota);
        if (tabel_anggota.getColumnModel().getColumnCount() > 0) {
            tabel_anggota.getColumnModel().getColumn(0).setResizable(false);
            tabel_anggota.getColumnModel().getColumn(1).setResizable(false);
            tabel_anggota.getColumnModel().getColumn(2).setResizable(false);
            tabel_anggota.getColumnModel().getColumn(3).setResizable(false);
            tabel_anggota.getColumnModel().getColumn(4).setResizable(false);
            tabel_anggota.getColumnModel().getColumn(5).setResizable(false);
            tabel_anggota.getColumnModel().getColumn(6).setResizable(false);
        }

        panel_dataanggota.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 490, 320));

        jSeparator7.setForeground(new java.awt.Color(102, 102, 102));
        panel_dataanggota.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 170, 10));

        jSeparator8.setForeground(new java.awt.Color(102, 102, 102));
        panel_dataanggota.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 170, 10));

        jSeparator9.setForeground(new java.awt.Color(102, 102, 102));
        panel_dataanggota.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 170, 10));

        jSeparator10.setForeground(new java.awt.Color(102, 102, 102));
        panel_dataanggota.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 170, 10));

        bt_insert_anggota.setBackground(new java.awt.Color(255, 255, 255));
        bt_insert_anggota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bt_insert_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_insert_anggotaMouseClicked(evt);
            }
        });
        bt_insert_anggota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Insert");
        bt_insert_anggota.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panel_dataanggota.add(bt_insert_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 70, 30));

        bt_update_anggota.setBackground(new java.awt.Color(255, 255, 255));
        bt_update_anggota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bt_update_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_update_anggotaMouseClicked(evt);
            }
        });
        bt_update_anggota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Update");
        bt_update_anggota.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panel_dataanggota.add(bt_update_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 70, 30));

        bt_delete_anggota.setBackground(new java.awt.Color(255, 255, 255));
        bt_delete_anggota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bt_delete_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_delete_anggotaMouseClicked(evt);
            }
        });
        bt_delete_anggota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Delete");
        bt_delete_anggota.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panel_dataanggota.add(bt_delete_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 70, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("DATA ANGGOTA");
        panel_dataanggota.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 490, -1));

        jPanel1.add(panel_dataanggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 800, 420));

        panel_datapengembalian.setBackground(new java.awt.Color(255, 255, 255));
        panel_datapengembalian.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_datapengembalian.add(inp_tanggalkembali_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 160, -1));

        inp_denda_pengembalian.setText("jTextField8");
        inp_denda_pengembalian.setBorder(null);
        panel_datapengembalian.add(inp_denda_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 160, -1));

        inp_totalhari_pengembalian.setText("jTextField9");
        inp_totalhari_pengembalian.setBorder(null);
        panel_datapengembalian.add(inp_totalhari_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 160, -1));

        inp_totaldenda_pengembalian.setText("jTextField10");
        inp_totaldenda_pengembalian.setBorder(null);
        panel_datapengembalian.add(inp_totaldenda_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 160, -1));

        inp_kodebuku_pengembalian.setText("jTextField11");
        inp_kodebuku_pengembalian.setBorder(null);
        panel_datapengembalian.add(inp_kodebuku_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 160, -1));

        inp_kodeanggota_pengembalian.setText("jTextField12");
        inp_kodeanggota_pengembalian.setBorder(null);
        panel_datapengembalian.add(inp_kodeanggota_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 160, -1));

        inp_kodepetugas_pengembalian.setText("jTextField13");
        inp_kodepetugas_pengembalian.setBorder(null);
        panel_datapengembalian.add(inp_kodepetugas_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 160, -1));

        jLabel40.setText("Kode Buku");
        panel_datapengembalian.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel42.setText("Kode Petugas");
        panel_datapengembalian.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel44.setText("Kode Anggota");
        panel_datapengembalian.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel45.setText("Tanggal Kembali");
        panel_datapengembalian.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel46.setText("Total Hari");
        panel_datapengembalian.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel47.setText("Denda Per Hari");
        panel_datapengembalian.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel48.setText("Total Denda");
        panel_datapengembalian.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        bt_back_pengembalian.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_back_pengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_back_to_30px.png"))); // NOI18N
        bt_back_pengembalian.setText("Back");
        bt_back_pengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_back_pengembalianMouseClicked(evt);
            }
        });
        panel_datapengembalian.add(bt_back_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, -1, -1));

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jScrollPane8.setToolTipText("");
        jScrollPane8.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jScrollPane8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tabel_pengembalian.setAutoCreateRowSorter(true);
        tabel_pengembalian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        tabel_pengembalian.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabel_pengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama Buku", "Nama Anggota", "Nama Petugas", "Tanggal kembali", "Total Hari", "Denda Per Hari", "Total Denda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_pengembalian.setToolTipText("");
        tabel_pengembalian.setFillsViewportHeight(true);
        tabel_pengembalian.setFocusable(false);
        tabel_pengembalian.setGridColor(new java.awt.Color(102, 102, 102));
        tabel_pengembalian.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_pengembalian.setRowHeight(30);
        tabel_pengembalian.setShowGrid(true);
        tabel_pengembalian.setShowVerticalLines(false);
        tabel_pengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pengembalianMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabel_pengembalian);
        if (tabel_pengembalian.getColumnModel().getColumnCount() > 0) {
            tabel_pengembalian.getColumnModel().getColumn(0).setResizable(false);
            tabel_pengembalian.getColumnModel().getColumn(1).setResizable(false);
            tabel_pengembalian.getColumnModel().getColumn(2).setResizable(false);
            tabel_pengembalian.getColumnModel().getColumn(3).setResizable(false);
            tabel_pengembalian.getColumnModel().getColumn(4).setResizable(false);
            tabel_pengembalian.getColumnModel().getColumn(5).setResizable(false);
            tabel_pengembalian.getColumnModel().getColumn(6).setResizable(false);
        }

        panel_datapengembalian.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 490, 320));

        bt_insert_pengembalian.setBackground(new java.awt.Color(255, 255, 255));
        bt_insert_pengembalian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt_insert_pengembalian.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Insert");
        bt_insert_pengembalian.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        panel_datapengembalian.add(bt_insert_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 70, 30));

        bt_update_pengembalian.setBackground(new java.awt.Color(255, 255, 255));
        bt_update_pengembalian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt_update_pengembalian.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Update");
        bt_update_pengembalian.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panel_datapengembalian.add(bt_update_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 70, 30));

        bt_delete_pengembalian.setBackground(new java.awt.Color(255, 255, 255));
        bt_delete_pengembalian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt_delete_pengembalian.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Delete");
        bt_delete_pengembalian.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panel_datapengembalian.add(bt_delete_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 70, 30));

        jSeparator11.setForeground(new java.awt.Color(102, 102, 102));
        panel_datapengembalian.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 160, 10));

        jSeparator12.setForeground(new java.awt.Color(102, 102, 102));
        panel_datapengembalian.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 160, 10));

        jSeparator13.setForeground(new java.awt.Color(102, 102, 102));
        panel_datapengembalian.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 160, 10));

        jSeparator14.setForeground(new java.awt.Color(102, 102, 102));
        panel_datapengembalian.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 160, 10));

        jSeparator15.setForeground(new java.awt.Color(102, 102, 102));
        panel_datapengembalian.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 160, 10));

        jSeparator16.setForeground(new java.awt.Color(102, 102, 102));
        panel_datapengembalian.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 160, 10));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("DATA PENGEMBALIAN");
        panel_datapengembalian.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 480, -1));

        jPanel1.add(panel_datapengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 800, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_exitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bt_exitMouseClicked

    private void bt_menu_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_menu_dashboardMouseClicked
        // TODO add your handling code here:
        panel_dashboard.show();
        panel_databuku.hide();
        panel_peminjaman.hide();
        panel_dataanggota.hide();
        panel_datapengembalian.hide();

    }//GEN-LAST:event_bt_menu_dashboardMouseClicked

    private void bt_menu_pinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_menu_pinjamMouseClicked
        // TODO add your handling code here:
        panel_dashboard.hide();
        panel_databuku.hide();
        panel_peminjaman.show();
        panel_dataanggota.hide();
        panel_datapengembalian.hide();

    }//GEN-LAST:event_bt_menu_pinjamMouseClicked

    private void bt_menu_bukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_menu_bukuMouseClicked
        // TODO add your handling code here:
        panel_dashboard.hide();
        panel_databuku.show();
        panel_peminjaman.hide();
        panel_dataanggota.hide();
        panel_datapengembalian.hide();

    }//GEN-LAST:event_bt_menu_bukuMouseClicked

    private void bt_logout_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_logout_menuMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new login().setVisible(true);
    }//GEN-LAST:event_bt_logout_menuMouseClicked

    private void bt_insert_databukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_insert_databukuMouseClicked
        // TODO add your handling code here:
        try {
            String judul_buku = inp_judulbuku.getText();
            String penulis = inp_penulis.getText();
            String tahun_penerbit = inp_tahunpenerbit.getText();
            String sql = "SELECT * FROM data_buku ORDER BY kode_buku DESC";
            rs = con.lihatData(sql);
            if (rs.next()) {
                String autokode = rs.getString("kode_buku").substring(2);
                String B = "" + (Integer.parseInt(autokode) + 1);
                String Nol = "";
                if (B.length() == 1) {
                    Nol = "000";
                } else if (B.length() == 2) {
                    Nol = "00";
                } else if (B.length() == 3) {
                    Nol = "0";
                } else if (B.length() == 4) {
                    Nol = "";
                }
                kode_buku = "B" + Nol + B;
            } else {
                kode_buku = "B0001";
            }

            String sql2 = "INSERT INTO `data_buku` (`kode_buku`, `judul_buku`, `penulis`, `tahun_penerbit`, `time_report`) VALUES ('" + kode_buku + "', '" + judul_buku + "', '" + penulis + "', '" + tahun_penerbit + "', current_timestamp());";
            con.dmlData(sql2);

            inp_penulis.setText("");
            inp_judulbuku.setText("");
            inp_tahunpenerbit.setText("");
            displayTableDataBuku();
            bookcount();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }//GEN-LAST:event_bt_insert_databukuMouseClicked

    private void bt_delete_databukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_delete_databukuMouseClicked
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Yakin?");
        if (confirm == 0) {
            String sql = "DELETE FROM data_buku WHERE kode_buku='" + kode_buku + "';";
            con.dmlData(sql);
            displayTableDataBuku();
        } else {
            JOptionPane.showMessageDialog(null, "Delete Error");
        }
    }//GEN-LAST:event_bt_delete_databukuMouseClicked

    private void bt_update_databukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_update_databukuMouseClicked
        // TODO add your handling code here:
        String sqlUpdate = "UPDATE `data_buku` SET `judul_buku` = '" + inp_judulbuku.getText() + "', `penulis` = '" + inp_penulis.getText() + "', `tahun_penerbit` = '" + inp_tahunpenerbit.getText() + "' WHERE `kode_buku` = '" + kode_buku + "';";
        con.dmlData(sqlUpdate);
        displayTableDataBuku();
    }//GEN-LAST:event_bt_update_databukuMouseClicked

    private void tabel_databukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_databukuMouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel dt = (DefaultTableModel) tabel_databuku.getModel();
            int rowId = tabel_databuku.getSelectedRow();
            kode_buku = dt.getValueAt(rowId, 0).toString();
            String sql = "SELECT * FROM data_buku WHERE kode_buku='" + kode_buku + "'";
            rs = con.lihatData(sql);
            while (rs.next()) {
                inp_judulbuku.setText(rs.getString("judul_buku"));
                inp_penulis.setText(rs.getString("penulis"));
                inp_tahunpenerbit.setText(rs.getString("tahun_penerbit"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }

    }//GEN-LAST:event_tabel_databukuMouseClicked

    private void bt_next_databukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_next_databukuMouseClicked
        // TODO add your handling code here:
        panel_dashboard.hide();
        panel_databuku.hide();
        panel_peminjaman.hide();
        panel_dataanggota.show();
        panel_datapengembalian.hide();
    }//GEN-LAST:event_bt_next_databukuMouseClicked

    private void bt_back_databukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_back_databukuMouseClicked
        // TODO add your handling code here:
        panel_dashboard.hide();
        panel_peminjaman.show();
        panel_databuku.hide();
        panel_dataanggota.hide();
        panel_datapengembalian.hide();
    }//GEN-LAST:event_bt_back_databukuMouseClicked

    private void bt_next_peminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_next_peminjamanMouseClicked
        // TODO add your handling code here:
        panel_dashboard.hide();
        panel_peminjaman.hide();
        panel_databuku.show();
        panel_dataanggota.hide();
        panel_datapengembalian.hide();
    }//GEN-LAST:event_bt_next_peminjamanMouseClicked

    private void bt_menu_pengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_menu_pengembalianMouseClicked
        // TODO add your handling code here:
        panel_dashboard.hide();
        panel_databuku.hide();
        panel_peminjaman.hide();
        panel_dataanggota.hide();
        panel_datapengembalian.show();
    }//GEN-LAST:event_bt_menu_pengembalianMouseClicked

    private void bt_menu_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_menu_anggotaMouseClicked
        // TODO add your handling code here:
        panel_dashboard.hide();
        panel_databuku.hide();
        panel_peminjaman.hide();
        panel_dataanggota.show();
        panel_datapengembalian.hide();
    }//GEN-LAST:event_bt_menu_anggotaMouseClicked

    private void bt_next_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_next_dashboardMouseClicked
        // TODO add your handling code here:
        panel_dashboard.hide();
        panel_peminjaman.show();
        panel_databuku.hide();
        panel_dataanggota.hide();
        panel_datapengembalian.hide();
    }//GEN-LAST:event_bt_next_dashboardMouseClicked

    private void bt_back_peminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_back_peminjamanMouseClicked
        // TODO add your handling code here:
        panel_dashboard.show();
        panel_peminjaman.hide();
        panel_databuku.hide();
        panel_dataanggota.hide();
        panel_datapengembalian.hide();
    }//GEN-LAST:event_bt_back_peminjamanMouseClicked

    private void bt_next_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_next_anggotaMouseClicked
        // TODO add your handling code here:
        panel_dashboard.hide();
        panel_peminjaman.hide();
        panel_databuku.hide();
        panel_dataanggota.hide();
        panel_datapengembalian.show();
    }//GEN-LAST:event_bt_next_anggotaMouseClicked

    private void bt_back_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_back_anggotaMouseClicked
        // TODO add your handling code here:
        panel_dashboard.hide();
        panel_peminjaman.hide();
        panel_databuku.show();
        panel_dataanggota.hide();
        panel_datapengembalian.hide();
    }//GEN-LAST:event_bt_back_anggotaMouseClicked

    private void bt_back_pengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_back_pengembalianMouseClicked
        // TODO add your handling code here:
        panel_dashboard.hide();
        panel_peminjaman.hide();
        panel_databuku.hide();
        panel_dataanggota.show();
        panel_datapengembalian.hide();
    }//GEN-LAST:event_bt_back_pengembalianMouseClicked

    private void tabel_peminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_peminjamanMouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel dt = (DefaultTableModel) tabel_peminjaman.getModel();
            int rowId = tabel_peminjaman.getSelectedRow();
            kode_peminjaman = dt.getValueAt(rowId, 0).toString();
            String sql = "SELECT p.kode_peminjaman,b.kode_buku, b.judul_buku, a.kode_anggota, a.nama_anggota, pt.kode_petugas, pt.nama, p.tanggal_pinjam, p.tanggal_kembali\n"
                    + "FROM data_peminjaman p\n"
                    + "JOIN data_petugas pt ON p.kode_petugas = pt.kode_petugas\n"
                    + "JOIN data_anggota a ON p.kode_anggota = a.kode_anggota\n"
                    + "JOIN data_buku b ON p.kode_buku = b.kode_buku"
                    + " WHERE p.kode_peminjaman='" + kode_peminjaman + "';";
            rs = con.lihatData(sql);
            while (rs.next()) {
                String TxtBuku = rs.getString("judul_buku").trim();
                String idCmb = rs.getString("kode_buku");
                Item comboItem = new Item(idCmb, TxtBuku);
                cb_buku_peminjaman.setSelectedItem(comboItem);

                String TxtAnggota = rs.getString("nama_anggota").trim();
                String idCmb2 = rs.getString("kode_anggota");
                Item comboItem2 = new Item(idCmb2, TxtAnggota);
                cb_anggota_peminjaman.setSelectedItem(comboItem2);

                String TxtPetugas = rs.getString("nama").trim();
                String idCmb3 = rs.getString("kode_petugas");
                Item comboItem3 = new Item(idCmb3, TxtPetugas);
                cb_petugas_peminjaman.setSelectedItem(comboItem3);

                Date tanggal_pinjam = new SimpleDateFormat("yyyy-MM-dd").parse((String) rs.getString("tanggal_pinjam"));
                inp_tgl_pinjam.setDate(tanggal_pinjam);

                Date tanggal_kembali = new SimpleDateFormat("yyyy-MM-dd").parse((String) rs.getString("tanggal_kembali"));
                inp_tgl_kembali.setDate(tanggal_kembali);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }//GEN-LAST:event_tabel_peminjamanMouseClicked

    private void tabel_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_anggotaMouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel dt = (DefaultTableModel) tabel_anggota.getModel();
            int rowId = tabel_anggota.getSelectedRow();
            kode_anggota = dt.getValueAt(rowId, 0).toString();
            String sql = "SELECT * FROM data_anggota WHERE kode_anggota='" + kode_anggota + "'";
            rs = con.lihatData(sql);
            while (rs.next()) {
                
                inp_npm_anggota.setText(rs.getString("npm_anggota"));
                inp_nama_anggota.setText(rs.getString("nama_anggota"));
                String gender = rs.getString("jenis_kelamin_anggota");
                if (gender.equals("Pria")) {
                    rb_pria.setSelected(true);
                }
                if (gender.equals("Wanita")) {
                    rb_wanita.setSelected(true);
                }
                inp_jurusan_anggota.setText(rs.getString("jurusan_anggota"));
                inp_alamat_anggota.setText(rs.getString("alamat_anggota"));
                inp_notlp_anggota.setText(rs.getString("no_hp_anggota"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }//GEN-LAST:event_tabel_anggotaMouseClicked

    private void tabel_pengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pengembalianMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabel_pengembalianMouseClicked

    private void bt_insert_peminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_insert_peminjamanMouseClicked
        // TODO add your handling code here:
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String tanggal_pinjam = dateFormat.format(inp_tgl_pinjam.getDate());
            String tanggal_kembali = dateFormat.format(inp_tgl_kembali.getDate());
            String sql = "SELECT * FROM data_peminjaman ORDER BY kode_peminjaman DESC";
            rs = con.lihatData(sql);
            if (rs.next()) {
                String autokode = rs.getString("kode_peminjaman").substring(2);
                String Pn = "" + (Integer.parseInt(autokode) + 1);
                String Nol = "";
                if (Pn.length() == 1) {
                    Nol = "00";
                } else if (Pn.length() == 2) {
                    Nol = "0";
                } else if (Pn.length() == 3) {
                    Nol = "";
                }
                kode_peminjaman = "Pn" + Nol + Pn;
            } else {
                kode_peminjaman = "Pn001";
            }

            String sql2 = "INSERT INTO `data_peminjaman` (`kode_peminjaman`, `tanggal_pinjam`, `tanggal_kembali`, `kode_buku`, `kode_anggota`, `kode_petugas`, `time_report`) "
                    + "VALUES ("
                    + "'" + kode_peminjaman + "',"
                    + "STR_TO_DATE('" + tanggal_pinjam + "','%d-%m-%Y'),"
                    + "STR_TO_DATE('" + tanggal_kembali + "','%d-%m-%Y'),"
                    + "'" + Buku_Kode + "', "
                    + "'" + Anggota_Kode + "', "
                    + "'" + Petugas_Kode + "', "
                    + "current_timestamp());";
            con.dmlData(sql2);

            displayTablePeminjaman();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }//GEN-LAST:event_bt_insert_peminjamanMouseClicked

    private void bt_update_peminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_update_peminjamanMouseClicked
        // TODO add your handling code here:
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String tanggal_pinjam = dateFormat.format(inp_tgl_pinjam.getDate());
        String tanggal_kembali = dateFormat.format(inp_tgl_kembali.getDate());
        String query = "UPDATE data_peminjaman SET  "
                + "tanggal_pinjam =STR_TO_DATE('" + tanggal_pinjam + "','%d-%m-%Y'),"
                + "tanggal_kembali =STR_TO_DATE('" + tanggal_kembali + "','%d-%m-%Y'),"
                + "kode_buku ='" + Buku_Kode + "',"
                + "kode_anggota ='" + Anggota_Kode + "',"
                + "kode_petugas ='" + Petugas_Kode + "'"
                + "WHERE kode_peminjaman ='" + kode_peminjaman + "';";
        con.dmlData(query);
        displayTablePeminjaman();
    }//GEN-LAST:event_bt_update_peminjamanMouseClicked

    private void bt_delete_peminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_delete_peminjamanMouseClicked
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Yakin?");
        if (confirm == 0) {
            String sql = "DELETE FROM data_peminjaman WHERE kode_peminjaman='" + kode_peminjaman + "';";
            System.out.println(sql);
            con.dmlData(sql);

            displayTablePeminjaman();
        } else {
            JOptionPane.showMessageDialog(null, "Delete Error");
        }
    }//GEN-LAST:event_bt_delete_peminjamanMouseClicked

    private void bt_insert_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_insert_anggotaMouseClicked
        // TODO add your handling code here:
        try {
            String npm_anggota = inp_npm_anggota.getText();
            String nama_anggota = inp_nama_anggota.getText();
            String jurusan_anggota = inp_jurusan_anggota.getText();
            String alamat_anggota = inp_alamat_anggota.getText();
            String notlp_anggota = inp_notlp_anggota.getText();
            String sql = "SELECT * FROM data_anggota ORDER BY kode_anggota DESC";
            rs = con.lihatData(sql);

            if (rb_pria.isSelected()) {
                gender = "Pria";
            }
            if (rb_wanita.isSelected()) {
                gender = "Wanita";
            }

            if (rs.next()) {
                String autokode = rs.getString("kode_anggota").substring(2);
                String A = "" + (Integer.parseInt(autokode) + 1);
                String Nol = "";
                if (A.length() == 1) {
                    Nol = "000";
                } else if (A.length() == 2) {
                    Nol = "00";
                } else if (A.length() == 3) {
                    Nol = "0";
                } else if (A.length() == 4) {
                    Nol = "";
                }
                kode_anggota = "A" + Nol + A;
            } else {
                kode_anggota = "A0001";
            }

            String sql2 = "INSERT INTO `data_anggota` (`kode_anggota`, `npm_anggota`, `nama_anggota`, `jenis_kelamin_anggota`, `jurusan_anggota`, `alamat_anggota`, `no_hp_anggota`) "
                    + "VALUES ("
                    + "'" + kode_anggota + "', "
                    + "'" + npm_anggota + "', "
                    + "'" + nama_anggota + "', "
                    + "'" + gender + "', "
                    + "'" + jurusan_anggota + "', "
                    + "'" + alamat_anggota + "', "
                    + "'" + notlp_anggota + "'"
                    + ");";
            con.dmlData(sql2);
            inp_npm_anggota.setText("");
            inp_nama_anggota.setText("");
            inp_jurusan_anggota.setText("");
            inp_alamat_anggota.setText("");
            inp_notlp_anggota.setText("");
            displayTableAnggota();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }//GEN-LAST:event_bt_insert_anggotaMouseClicked

    private void bt_update_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_update_anggotaMouseClicked
        // TODO add your handling code here:
        String sqlUpdate = "UPDATE `data_anggota` SET "
                + "`npm_anggota`='"+inp_npm_anggota.getText()+"',"
                + "`nama_anggota`='"+inp_nama_anggota.getText()+"',"
                + "`jenis_kelamin_anggota`='"+gender+"',"
                + "`jurusan_anggota`='"+inp_jurusan_anggota.getText()+"',"
                + "`alamat_anggota`='"+inp_alamat_anggota.getText()+"',"
                + "`no_hp_anggota`='"+inp_notlp_anggota.getText()+"'"
                + " WHERE `kode_anggota` = '"+kode_anggota+"';";
      
        con.dmlData(sqlUpdate);
        displayTableAnggota();
        
    }//GEN-LAST:event_bt_update_anggotaMouseClicked

    private void bt_delete_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_delete_anggotaMouseClicked
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Yakin?");
        if (confirm == 0) {
            String sql = "DELETE FROM data_anggota WHERE kode_anggota='" + kode_anggota + "';";
            con.dmlData(sql);
            displayTableAnggota();
        } else {
            JOptionPane.showMessageDialog(null, "Delete Error");
        }
    }//GEN-LAST:event_bt_delete_anggotaMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bt_back_anggota;
    private javax.swing.JLabel bt_back_databuku;
    private javax.swing.JLabel bt_back_peminjaman;
    private javax.swing.JLabel bt_back_pengembalian;
    private javax.swing.JPanel bt_delete_anggota;
    private javax.swing.JPanel bt_delete_databuku;
    private javax.swing.JPanel bt_delete_peminjaman;
    private javax.swing.JPanel bt_delete_pengembalian;
    private javax.swing.JLabel bt_exit;
    private javax.swing.JPanel bt_insert_anggota;
    private javax.swing.JPanel bt_insert_databuku;
    private javax.swing.JPanel bt_insert_peminjaman;
    private javax.swing.JPanel bt_insert_pengembalian;
    private javax.swing.JLabel bt_logout_menu;
    private javax.swing.JPanel bt_menu_anggota;
    private javax.swing.JPanel bt_menu_buku;
    private javax.swing.JPanel bt_menu_dashboard;
    private javax.swing.JPanel bt_menu_pengembalian;
    private javax.swing.JPanel bt_menu_pinjam;
    private javax.swing.JLabel bt_next_anggota;
    private javax.swing.JLabel bt_next_dashboard;
    private javax.swing.JLabel bt_next_databuku;
    private javax.swing.JLabel bt_next_peminjaman;
    private javax.swing.JPanel bt_update_anggota;
    private javax.swing.JPanel bt_update_databuku;
    private javax.swing.JPanel bt_update_peminjaman;
    private javax.swing.JPanel bt_update_pengembalian;
    private javax.swing.JComboBox<String> cb_anggota_peminjaman;
    private javax.swing.JComboBox<String> cb_buku_peminjaman;
    private javax.swing.JComboBox<String> cb_petugas_peminjaman;
    private javax.swing.JLabel image_logo;
    private javax.swing.JTextArea inp_alamat_anggota;
    private javax.swing.JTextField inp_denda_pengembalian;
    private javax.swing.JTextField inp_judulbuku;
    private javax.swing.JTextField inp_jurusan_anggota;
    private javax.swing.JTextField inp_kodeanggota_pengembalian;
    private javax.swing.JTextField inp_kodebuku_pengembalian;
    private javax.swing.JTextField inp_kodepetugas_pengembalian;
    private javax.swing.JTextField inp_nama_anggota;
    private javax.swing.JTextField inp_notlp_anggota;
    private javax.swing.JTextField inp_npm_anggota;
    private javax.swing.JTextField inp_penulis;
    private javax.swing.JTextField inp_tahunpenerbit;
    private com.toedter.calendar.JDateChooser inp_tanggalkembali_pengembalian;
    private com.toedter.calendar.JDateChooser inp_tgl_kembali;
    private com.toedter.calendar.JDateChooser inp_tgl_pinjam;
    private javax.swing.JTextField inp_totaldenda_pengembalian;
    private javax.swing.JTextField inp_totalhari_pengembalian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.ButtonGroup jenis_kelamin;
    public static final javax.swing.JLabel label1 = new javax.swing.JLabel();
    private javax.swing.JLabel label_anggota;
    public static final javax.swing.JLabel label_dashboard = new javax.swing.JLabel();
    private javax.swing.JLabel label_jumlahbuku;
    private javax.swing.JLabel label_peminjaman;
    private javax.swing.JLabel label_pengunjung;
    public static final javax.swing.JLabel label_username = new javax.swing.JLabel();
    private javax.swing.JPanel logout;
    private javax.swing.JPanel panel_dashboard;
    private javax.swing.JPanel panel_dataanggota;
    private javax.swing.JPanel panel_databuku;
    private javax.swing.JPanel panel_datapengembalian;
    private javax.swing.JPanel panel_header;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JPanel panel_peminjaman;
    private javax.swing.JRadioButton rb_pria;
    private javax.swing.JRadioButton rb_wanita;
    private javax.swing.JTable tabel_anggota;
    private javax.swing.JTable tabel_databuku;
    private javax.swing.JTable tabel_peminjaman;
    private javax.swing.JTable tabel_pengembalian;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
