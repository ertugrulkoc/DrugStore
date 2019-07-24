<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "dbbean" scope = "application" class = "controller.RegisterDao" >
</jsp:useBean>
<jsp:setProperty name = "dbbean" property = "*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Foundation Action</title>
    </head>
    <body>
        <%

                String demail = request.getParameter("email");
                String status = request.getParameter("status");

                boolean isSuccess = dbbean.updateDoctorStatus(demail, status);
                if (isSuccess) {
        %>
        <jsp:forward page="../Admin/admin.jsp"/>
        <% } else {%>
        <jsp:forward page="../Admin/admin.jsp"/>
        <% }
            
        %>

    </body>
</html>