<%@page import="controller.RegisterDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "doctor" scope = "application" class = "beans.Doctor" >
</jsp:useBean>
<jsp:setProperty name = "doctor" property = "*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <%
            doctor.setName(request.getParameter("name"));
            doctor.setEmail(request.getParameter("lastName"));
            doctor.setEmail(request.getParameter("email"));
            doctor.setPassword(request.getParameter("password"));

            boolean isSuccess = RegisterDao.registerDoctor(doctor);
            if (isSuccess) {%>
        <jsp:forward page="../pages/MainPage.html"/>
        <% } else {%>
        <jsp:forward page="../pages/Register.html"/>
        <% }

        %>
    </body>
</html>
