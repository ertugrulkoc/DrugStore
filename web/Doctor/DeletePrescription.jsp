<%@page import="java.sql.ResultSet"%>
<%@page import="controller.PrescriptionDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "doctor" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "doctor" property = "*" />

<jsp:useBean id = "prescription" class = "beans.Prescription" >
</jsp:useBean>
<jsp:setProperty name = "prescription" property = "*" /> 


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Donation Action</title>
    </head>
    <body>
        <%
            if (session.getAttribute("email") == null) {
                response.sendRedirect("../control/Login.jsp");
            }
            String email = (String) session.getAttribute("email");
            String firstname = doctor.takeDoctorName(email);

            String submit = request.getParameter("Delete");

            String doctorName = request.getParameter("presid");

            boolean isSuccess = PrescriptionDao.deletePrescription(doctorName);

            if (isSuccess) {%>
        <jsp:forward page="ListPrescription.jsp"/>
        <% } else {%>
        <jsp:forward page="ListPrescription.jsp"/>
        <% }

        %>

    </body>
</html>
