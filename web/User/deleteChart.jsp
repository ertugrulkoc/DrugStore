<%@page import="java.sql.ResultSet"%>
<%@page import="controller.ChartDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<jsp:useBean id = "drug" class = "beans.Drug" >
</jsp:useBean>
<jsp:setProperty name = "drug" property = "*" /> 


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Drug</title>
    </head>
    <body>
        <%
            
            String submit = request.getParameter("Delete");

            if (submit.equals("Delete")) {
                String name = request.getParameter("name");

                boolean isSuccess = ChartDao.deleteBasket(name);

                if (isSuccess) {%>
        <jsp:forward page="basketChart.jsp"/>
        <% } else {%>
        <jsp:forward page="basketChart.jsp"/>
        <% }
            }
        %>

    </body>
</html>
