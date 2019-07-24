<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.RegisterDao"%>
<jsp:useBean id = "dbbean" class = "beans.Doctor" >
</jsp:useBean>
<jsp:setProperty name = "dbbean" property = "*" />


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Doctor Action</title>
    </head>
    <body>
        <%
               String submit=request.getParameter("Delete");
               if(submit.equals("Delete")){
                   String name = request.getParameter("name");
               
           

            boolean isSuccess = RegisterDao.deleteDoctor1(name);
            if (isSuccess) {%>
        <jsp:forward page="admin.jsp"/>
        <% } else {%>
        <jsp:forward page="admin.jsp"/>
        <% }}
        %>

    </body>
</html>
