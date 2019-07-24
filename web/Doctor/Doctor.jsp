<%@page import="java.sql.ResultSet"%>
<%@page import="controller.PrescriptionDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "dbbean" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "dbbean" property = "*" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Drug Store</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" /> 
    </head>
    <body>
        <%
            if (session.getAttribute("email") == null) {
                response.sendRedirect("../control/Login.jsp");
            }
            String email = (String) session.getAttribute("email");
            
            String firstname = dbbean.takeUserName(email);
            
            ResultSet table = PrescriptionDao.takeUserPrescription(firstname);
        %>

        <div id="header">
            <div class="clearfix">
                <div class="logo">

                </div>
                <ul class="navigation">
                    <li class="active">
                        <a href="Doctor.jsp">Doctor: <%= firstname%></a>

                    </li>
                     <li>
                        <a href="CreationPrescriptionPage.jsp">Create Prescription</a>
                    </li>
                    
                    <li>
                        <a href="../control/Logout.jsp">Logout</a>
                    </li>
                </ul>
            </div>
        </div>

         <div id="contents">
            <div class="clearfix">
                <div class="main">
                    <h1>All Prescriptions</h1>
                    <form action="DeletePrescription.jsp" method="post" class="message">
                        <table>

                            <tr>
                                <th>User ID</th>

                                <th>Prescription ID</th>

                                <th>Drug Name</th>
                            </tr>


                            <% while (table.next()) {%>   
                            <tr>    

                                <td>            
                                    <%out.print(table.getString("doctorname"));%> 
                                </td>
                                 <td>            
                                    <%out.print(table.getString("prescriptionid"));%> 
                                </td>
                                <td>            
                                    <%out.print(table.getString("useremail"));%> 
                                </td>
                                <td>
                                    <%out.print(table.getString("drugname"));%>           
                                </td>
                                 <td>
                                    <%out.print(table.getString("usinginfo"));%>           
                                </td>
                                <td>            
                                    <input type="radio" name="presid" value="<%out.print(table.getString("prescriptionid"));%>">
                                </td>
                            </tr>
                            <%}%>
                        </table>

                        &nbsp;

                        <center><p><input type = "submit" name = "Submit" value = "Delete"/></p></center>

                    </form>

                </div>
            </div>
        </div>


    </body>
</html>
