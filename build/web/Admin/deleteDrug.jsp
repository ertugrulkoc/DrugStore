<%@page import="java.sql.ResultSet"%>
<%@page import="controller.DrugDao"%>
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
                String drugName = request.getParameter("drugName");

                boolean isSuccess = DrugDao.deleteDrug(drugName);

                if (isSuccess) {%>
        <jsp:forward page="drugList.jsp"/>
        <% } else {%>
        <jsp:forward page="drugList.jsp"/>
        <% }
            }
        %>

    </body>
</html>
