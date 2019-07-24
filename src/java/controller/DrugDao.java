package controller;

import beans.Drug;
import java.sql.*;
import database.ConnectionProvider;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.*;

public class DrugDao {

    public static void addDrug(beans.Drug d) {

        String drugid = d.getDrugid();
        String drugname = d.getDrugname();
        String info = d.getInfo();
        double price = d.getPrice();
        int stock = d.getStock();
        String statu = d.getStatu();

        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("insert into drug(drugid,drugname,price,info,stock,statu) values(?,?,?,?,?,?)");

            ps.setString(1, drugid);
            ps.setString(2, drugname);
            ps.setDouble(3, price);
            ps.setString(4, info);
            ps.setInt(5, stock);
            ps.setString(6, statu);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static boolean editDrug(beans.Drug d) throws SQLException {

        String drugname = d.getDrugname();
        String info = d.getInfo();
        double price = d.getPrice();
        int stock = d.getStock();
        String statu = d.getStatu();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("update drug set  price = ?, info = ?, stock = ?,statu=? where drugname = ?");

            ps.setDouble(1, price);
            ps.setString(2, info);
            ps.setInt(3, stock);
            ps.setString(4, statu);
            ps.setString(5, drugname);

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean checkDrug(String drugid) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;

        PreparedStatement ps = con.prepareStatement("select * from drug where drugid = ? ");
        ps.setString(1, drugid);
        rs = ps.executeQuery();

        rs.first();

        if (rs.first()) {
            return true;
        } else {
            return false;
        }
    }

    public static ResultSet takeAllDrug() throws SQLException {

        Connection con = ConnectionProvider.getCon();

        PreparedStatement pstmt = con.prepareStatement("select * from drug");

        ResultSet rs = pstmt.executeQuery();

        return rs;
    }

    public static boolean deleteDrug(String drugname) {
        try {

            Connection con = ConnectionProvider.getCon();

            PreparedStatement pstmt = con.prepareStatement("delete from drug where drugname = ?");
            pstmt.setString(1, drugname);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static ResultSet takesearchedDrugs(String drugname) throws SQLException {

        Connection con = ConnectionProvider.getCon();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM drug where drugname='" + drugname + "' ;");

        return rs;
    }

    public static boolean takeStock(String drugname, String stock) throws SQLException {

        int sum;
        Connection con = ConnectionProvider.getCon();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM drug where drugname='" + drugname + "' ;");

        rs.next();

        int newStock = Integer.parseInt(stock);
        int oldStock;
        oldStock = rs.getInt("stock");

        sum = newStock + oldStock;

        try {

            PreparedStatement ps = con.prepareStatement("update drug set stock = ? where drugname='" + drugname + "' ;");

            ps.setInt(1, sum);

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;

    }
    public static boolean ejectStock(String drugname) throws SQLException {

        int sum;
        Connection con = ConnectionProvider.getCon();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM drug where drugname='" + drugname + "' ;");

        rs.first();

        
        int oldStock;
        oldStock = rs.getInt("stock");

        sum = oldStock-1; 

        try {

            PreparedStatement ps = con.prepareStatement("update drug set stock = ? where drugname='" + drugname + "' ;");

            ps.setInt(1, sum);

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;

    }
}
