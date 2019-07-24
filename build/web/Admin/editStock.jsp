<%@page import="java.sql.ResultSet"%>
<%@page import="controller.DrugDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:setProperty name = "dbbean" property = "*" />


<jsp:useBean id = "drug" class = "beans.Drug" >
</jsp:useBean>
<jsp:setProperty name = "drug" property = "*" /> 


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Stock</title>
    </head>
    <body>
        <%

            String submit = request.getParameter("Delete");

            String drugname = request.getParameter("drugname");
            String stock = request.getParameter("stock");
            boolean isSuccess = DrugDao.takeStock(drugname, stock);

            if (isSuccess) {%>
        <jsp:forward page="stockList.jsp"/>
        <% } else {%>
        <jsp:forward page="admin.jsp"/>
        <% }

        %>

    </body>
</html>
