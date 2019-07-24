<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "dbbean" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "dbbean" property = "*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <%
            String submit = request.getParameter("Login");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
        %>        
        <%      if (dbbean.loginAdmin(email, password)) {
                session.setAttribute("email", email);
                response.sendRedirect("../Admin/admin.jsp");
            } else {%>
        <jsp:forward page="../control/LoginError.jsp"/>

        <%}%>        
    </body>
</html>
