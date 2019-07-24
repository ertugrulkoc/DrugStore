<%@page import="controller.LoginDao"%>
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
                String type = LoginDao.typeCheck(email, password);
           
          
        %>        
        <%  if (type.equals("user")) {
                if (dbbean.checkUser(email, password)) {
                    session.setAttribute("email", email);
                    response.sendRedirect("../User/user.jsp");
                } else {%>
        <jsp:forward page="LoginError.jsp"/>
        <%}
        } else if (type.equals("admin")) {
            if (dbbean.checkUser(email, password)) {
                session.setAttribute("email", email);
                response.sendRedirect("../Admin/admin.jsp");
                } else {%>
        <jsp:forward page="LoginError.jsp"/>
        <%}
        } else if (type.equals("doctor")) {
            if (dbbean.checkUser(email, password)) {
                session.setAttribute("email", email);
                response.sendRedirect("../Doctor/Doctor.jsp");
                } else {%>
        <jsp:forward page="LoginError.jsp"/>
        <%}
            } else {%>
        <jsp:forward page="LoginError.jsp"/>
        <%}%>        
    </body>
</html>
