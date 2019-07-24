package controller;

import database.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChartDao {

    public static void createBasket(beans.Drug d, String userEmail) {

        String drugname = d.getDrugname();
        double price = d.getPrice();

        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("insert into basket_info(name,price,userEmail) values(?,?,?)");
            ps.setString(1, drugname);
            ps.setDouble(2, price);
            ps.setString(3, userEmail);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static ResultSet takeAllBasket(String email) throws SQLException {

        Connection con = ConnectionProvider.getCon();

        Statement pstmt = con.createStatement();

        ResultSet rs = pstmt.executeQuery("select * from basket_info where userEmail='" + email + "';");

        return rs;
    }
    public static int takeAllBasketPrice(String email) throws SQLException {
        int sum=0;
        Connection con = ConnectionProvider.getCon();

        Statement pstmt = con.createStatement();

        ResultSet rs = pstmt.executeQuery("select * from basket_info where userEmail='" + email + "';");
        
        while(rs.next()){
            sum+=Double.parseDouble(rs.getString("price"));
        }

        return sum;
    }

    public static boolean checkPres(String prescriptionid, String useremail, String drugname) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;
        
        PreparedStatement ps = con.prepareStatement("select * from prescriptions where prescriptionid='"+prescriptionid+"' and useremail='"+useremail+"' and drugname='"+drugname+"';");


        rs = ps.executeQuery();
        

        if (rs.first()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean deleteBasket(String name) throws SQLException {
        try {

            Connection con = ConnectionProvider.getCon();

            PreparedStatement pstmt = con.prepareStatement("delete from basket_info where name = ?");
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
     public static boolean deleteAllCart() throws SQLException {
        try {

            Connection con = ConnectionProvider.getCon();

            Statement pstmt = con.createStatement();
           
            pstmt.executeUpdate("truncate basket_info");
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean finishShopping(String firstname, String email, String adress, String creditcardno, String expirationdate, String cvc2) throws SQLException {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("insert into user_buyed(firstname,email,adress,creditcardno,expirationdate,cvc2) values(?,?,?,?,?,?)");
            ps.setString(1, firstname);
            ps.setString(2, email);
            ps.setString(3, adress);
            ps.setString(4, creditcardno);
            ps.setString(5, expirationdate);
            ps.setString(6, cvc2);

            ps.executeUpdate();

            return true;
        } catch (Exception e) {
        }
        return false;
    }
       public static boolean checkCart(String email) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;

        PreparedStatement ps = con.prepareStatement("select * from basket_info where userEmail = ? ");
        ps.setString(1, email);
        rs = ps.executeQuery();

        rs.first();

        if (rs.first()) {
            return true;
        } else {
            return false;
        }
    }
       
         public static ResultSet getNames(String email) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        ResultSet rs;

        Statement ps = con.createStatement();
       
        rs = ps.executeQuery("select * from basket_info where userEmail = '"+ email+"'; ");

        rs.first();

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
       
}
