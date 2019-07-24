package controller;

import java.sql.*;
import database.ConnectionProvider;

public class RegisterDao {

    public static boolean registerUser(beans.User u) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("insert into user(firstname,lastname,email,password,type) values(?,?,?,?,?)");
            ps.setString(1, u.getFirstname());
            ps.setString(2, u.getLastname());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getType());
            

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
     public static boolean checkRegister(String email) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;

        PreparedStatement ps = con.prepareStatement("select * from user where email=?");
        ps.setString(1, email);

        rs = ps.executeQuery();
        rs.first();

        if (rs.first()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean registerDoctor(beans.Doctor d) {
        try {

            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("insert into doctor(name,lastName,email,password,status) values(?,?,?,?,?)");

            ps.setString(1, d.getName());
            ps.setString(2, d.getLastName());
            ps.setString(3, d.getEmail());
            ps.setString(4, d.getPassword());
            ps.setString(5, "pending");

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public ResultSet takeDoctor(String status) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;
        PreparedStatement ps = con.prepareStatement("select * from doctor where status = ?");
        ps.setString(1, status);

        rs = ps.executeQuery();

        return rs;
    }

    public String takeDoctorName(String doctorID) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;
        PreparedStatement ps = con.prepareStatement("select doctorName from user where email = ?");
        ps.setString(1, doctorID);

        rs = ps.executeQuery();
        rs.first();

        return rs.getString("doctorID");
    }

    public boolean updateDoctorStatus(String demail, String status) {
        try {
            if (status.equals("approved")) {
                Connection con = ConnectionProvider.getCon();

                PreparedStatement ps = con.prepareStatement("update doctor set status = ? where email = ?");
                ps.setString(1, status);
                ps.setString(2, demail);
                ps.executeUpdate();

               

        Statement stmt = con.createStatement();
 
        ResultSet rs = stmt.executeQuery("SELECT * FROM doctor where email='" + demail + "' ;");
        rs.next();

                PreparedStatement pstmt = con.prepareStatement("insert into user(firstname,lastname,email,password,type) values (?,?,?,?,?)");
                pstmt.setString(1, rs.getString("name"));
                pstmt.setString(2, rs.getString("lastName"));
                pstmt.setString(3, rs.getString("email"));
                pstmt.setString(4, rs.getString("password"));
                pstmt.setString(5, "doctor");
                pstmt.executeUpdate();

            } else {
                Connection con = ConnectionProvider.getCon();

                PreparedStatement ps = con.prepareStatement("delete from doctor where email = ?");
                ps.setString(1, demail);
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean deleteDoctor(String demail, String status) throws SQLException {
        try {
            if (status.equals("approved")) {
                Connection con = ConnectionProvider.getCon();

                PreparedStatement ps = con.prepareStatement("update doctor set status = ? where email = ?");
                ps.setString(1, status);
                ps.setString(2, demail);
                ps.executeUpdate();
            } else {
                Connection con = ConnectionProvider.getCon();

                PreparedStatement ps = con.prepareStatement("delete from doctor where email = ?");
                ps.setString(1, demail);
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean deleteDoctor1(String name) throws SQLException {
        try {

            Connection con = ConnectionProvider.getCon();

            PreparedStatement ps = con.prepareStatement("delete from doctor where name = ?");

            ps.setString(1, name);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }

    public static ResultSet takeAllDoctor() throws SQLException {

        Connection con = ConnectionProvider.getCon();

        PreparedStatement pstmt = con.prepareStatement("select * from doctor WHERE status='approved'");

        ResultSet rs = pstmt.executeQuery();

        return rs;
    }
}
