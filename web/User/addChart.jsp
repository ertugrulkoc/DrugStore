<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.ChartDao"%>
<%@page import="controller.PrescriptionDao"%>

<jsp:useBean id = "login" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "login" property = "*" />



<jsp:useBean id = "drug" class = "beans.Drug" >
</jsp:useBean>
<jsp:setProperty name = "drug" property = "*" />
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Drug Store</title>
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

            String submit = request.getParameter("Add");

                String name = request.getParameter("drugname");
                String presid = request.getParameter("presid");
                String presid1 = request.getParameter("presid1");
                drug.setDrugname(name);
                ChartDao.createBasket(drug, email);
                
                
             
                response.sendRedirect("../User/basketChart.jsp");
         
        %>

    </body>
</html>
