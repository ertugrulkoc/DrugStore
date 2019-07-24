<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "user" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "user" property = "*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%
            session.invalidate();
            response.sendRedirect("../pages/MainPage.html");
        %>
        
    </body>
</html>
