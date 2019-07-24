package controller;

import beans.Prescription;
import java.sql.*;
import database.ConnectionProvider;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.*;

public class PrescriptionDao {

    public static void createPrescription(beans.Prescription d) {

        String doctorname = d.getDoctorname();
        String prescriptionid = d.getPrescriptionid();
        String useremail = d.getUseremail();
        String drugname = d.getDrugname();
        String usinginfo = d.getUsinginfo();

        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("insert into prescriptions(doctorname,prescriptionid,useremail,drugname,usinginfo) values(?,?,?,?,?)");
            ps.setString(1, doctorname);
            ps.setString(2, prescriptionid);
            ps.setString(3, useremail);
            ps.setString(4, drugname);
            ps.setString(5, usinginfo);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    
     public static boolean checkPrescription(String prescriptionid) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;

        PreparedStatement ps = con.prepareStatement("select * from prescriptions where prescriptionid=?");
        ps.setString(1, prescriptionid);

        rs = ps.executeQuery();
        rs.first();

        if (rs.first()) {
            return true;
        } else {
            return false;
        }

    }


    public static ResultSet takeAllPrescription() throws SQLException {

        Connection con = ConnectionProvider.getCon();
        PreparedStatement pstmt = con.prepareStatement("select * from prescriptions");
        ResultSet rs = pstmt.executeQuery();

        return rs;
    }
    
    
     public static ResultSet takeUserPrescription(String name) throws SQLException {

        Connection con = ConnectionProvider.getCon();
        PreparedStatement pstmt = con.prepareStatement("select * from prescriptions where doctorname='" + name+ "' ;");
        ResultSet rs = pstmt.executeQuery();

        return rs;
    }
     public static ResultSet takeUserPrescription1(String name) throws SQLException {

        Connection con = ConnectionProvider.getCon();
        PreparedStatement pstmt = con.prepareStatement("select * from prescriptions where useremail='" + name+ "' ;");
        ResultSet rs = pstmt.executeQuery();

        return rs;
    }
     public static boolean takepresid(String drugname,String email,String presid) throws SQLException {

        Connection con = ConnectionProvider.getCon();
        PreparedStatement pstmt = con.prepareStatement("select * from prescriptions where useremail='" + email+ "' and drugname='"+drugname+"' and prescriptionid='"+presid+"' ;");
       
        ResultSet rs = pstmt.executeQuery();
        
        
        return rs.first();

        
    }

    public static ResultSet takeAllPres() throws SQLException {

        Connection con = ConnectionProvider.getCon();

        PreparedStatement pstmt = con.prepareStatement("select * from prescriptions");

        ResultSet rs = pstmt.executeQuery();

        return rs;
    }

    public static String takePres(String prescriptionid) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        PreparedStatement pstmt = con.prepareStatement("select prescriptionid from prescriptions where prescriptionid = ?");
        pstmt.setString(1, prescriptionid);
        ResultSet rs = pstmt.executeQuery();
        rs.first();
        return rs.getString("prescriptionid");
    }

    public static boolean deletePrescription(String prescriptionid) throws SQLException {
        try {

            Connection con = ConnectionProvider.getCon();

            PreparedStatement pstmt = con.prepareStatement("delete from prescriptions where prescriptionid= ?");
            pstmt.setString(1, prescriptionid);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

}
