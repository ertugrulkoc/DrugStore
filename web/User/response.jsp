<%@page import="controller.DrugDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="controller.ChartDao"%>
<%@page import="controller.LoginDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.PrescriptionDao"%>
<jsp:useBean id = "dbbean" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "dbbean" property = "*" />

<jsp:useBean id = "login" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "login" property = "*" />


<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Response</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" /> 
    </head>
    <body>
        <%
            if (session.getAttribute("email") == null) {
                response.sendRedirect("../control/Login.jsp");
            }
            String email = (String) session.getAttribute("email");
            String firstname = login.takeUserName(email);
        %> <%
            String firstname1 = firstname;
            String emailadress = email;
            String adress = request.getParameter("adress");
            String creditcardno = request.getParameter("creditcardno");
            String expirationdate = request.getParameter("expirationdate");
            String cvc2 = request.getParameter("cvc2");
            boolean isSuccess = false;

            if (ChartDao.checkCart(email)) {
                if (creditcardno != null && expirationdate != null && cvc2 != null && adress != null) {
                    isSuccess = ChartDao.finishShopping(firstname1, emailadress, adress, creditcardno, expirationdate, cvc2);
                    ResultSet ab=ChartDao.getNames(email);
                    ChartDao.deleteAllCart();
                    
                    
                  while(ab.next()){
                     DrugDao.ejectStock(ab.getString("name"));  
                  }
         
                    
                }
            }

            if (isSuccess) {


        %>
        <div id="header">
            <div class="clearfix">
                <div class="logo">

                </div>
                <ul class="navigation">
                          <li>
                        <a href="user.jsp">User: <%= firstname%></a>
                    </li>
                    <li>
                        <a href="userPrescription.jsp">Prescription</a>
                    </li>

                    <li>
                        <a href="basketChart.jsp">Basket</a>
                    </li>


                    <li>
                        <a href="../control/Logout.jsp">Logout</a>
                    </li>
                </ul>
            </div>
        </div>


        <br><p style="margin-left: 150px; font-size: 50px" >You buyed drugs successfully</p>
        <br><a style="margin-left: 170px; font-size: 35px" href="mainDrugList.jsp">Go to Home</a>
        <%} else {%><p style="margin-left: 150px; font-size: 50px">You couldnt buy drugs successfully</p>
        <br><a style="margin-left: 170px; font-size: 35px" href="mainDrugList.jsp">Go to Home</a>
        <%}%>




    </body>
</html>

