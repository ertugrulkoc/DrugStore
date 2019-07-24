<%@page import="controller.RegisterDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "user" scope = "application" class = "beans.User" >
</jsp:useBean>
<jsp:setProperty name = "user" property = "*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <%
            user.setFirstname(request.getParameter("firstname"));
            user.setLastname(request.getParameter("lastname"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setPassword(request.getParameter("type"));
            
            boolean isSuccess = RegisterDao.registerUser(user);
            if (isSuccess) {%>
        <jsp:forward page="../MainPage.html"/>
        <% } else {%>
        <jsp:forward page="Register.html"/>
        <% }

        %>
    </body>
</html>
