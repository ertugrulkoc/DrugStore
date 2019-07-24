package controller;

import database.ConnectionProvider;
import java.sql.*;

public class LoginDao {

    public static boolean loginAdmin(String email, String password) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;
        PreparedStatement ps = con.prepareStatement("select * from admin where email = ? and password = ?");
        ps.setString(1, email);
        ps.setString(2, password);

        rs = ps.executeQuery();
        rs.first();

        if (rs.first()) {
            return true;
        } else {
            return false;
        }
    }

    public String takeDoctorName(String email) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;
        PreparedStatement ps = con.prepareStatement("select name from doctor where email = ?");
        ps.setString(1, email);
        rs = ps.executeQuery();
        rs.first();

        return rs.getString("name");
    }

    public String takeUserName(String email) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;
        PreparedStatement ps = con.prepareStatement("select firstname from user where email = ?");
        ps.setString(1, email);
        rs = ps.executeQuery();
        rs.first();

        return rs.getString("firstname");
    }

    public String takeAdminName(String email) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;
        PreparedStatement ps = con.prepareStatement("select firstname from user where email = ?");
        ps.setString(1, email);
        rs = ps.executeQuery();
        rs.first();

        return rs.getString("firstname");
    }

    public static boolean editDoctor(String email) throws SQLException {
        try {
            Connection con = ConnectionProvider.getCon();
            ResultSet rs;

            PreparedStatement ps = con.prepareStatement("update user set firstname = ?, lastname = ?, email = ?, password = ?");

            ps.setString(1, email);

            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean checkDoctor(String email, String password) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;

        PreparedStatement ps = con.prepareStatement("select * from doctor where email = ? and password = ?");
        ps.setString(1, email);
        ps.setString(2, password);

        rs = ps.executeQuery();
        rs.first();

        if (rs.first()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkUser(String email, String password) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;

        PreparedStatement ps = con.prepareStatement("select * from user where email = ? and password = ?");
        ps.setString(1, email);
        ps.setString(2, password);

        rs = ps.executeQuery();
        rs.first();

        if (rs.first()) {
            return true;
        } else {
            return false;
        }

    }

    public static String typeCheck(String email, String password) throws SQLException {
        String a;
        try {
            Connection con = ConnectionProvider.getCon();

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM user where email='" + email + "'  and password='" + password + "' ;");

            rs.next();
            a = rs.getString("type");
        } catch (Exception e) {
            return "hata" + e;
        }

        return a;
    }

    public static ResultSet checkStatu() throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;

        PreparedStatement ps = con.prepareStatement("select * from doctor where status = 'approved' ");

        rs = ps.executeQuery();

        return rs;
    }
}
