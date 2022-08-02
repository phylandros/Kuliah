/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ariya
 */
public class koneksi {
    Connection con;
    Statement stmt;
    ResultSet rs;

    public koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inisialisasi Class : " + e);
        }

        try {
            stmt = DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan", "root", "").createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error koneksi ke database : " + e);
        }
    }

    public ResultSet lihatData(String sql) {
        try {
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error koneksi ke database : " + e);
        }
        return rs;
    }

    public void dmlData(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Query :" + e);
        }
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
