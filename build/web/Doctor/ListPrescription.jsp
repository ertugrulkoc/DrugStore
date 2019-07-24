<%@page import="java.sql.ResultSet"%>
<%@page import="controller.PrescriptionDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "dbbean" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "dbbean" property = "*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tableStyle.css" />
        <title>All Donations</title>
    </head>
    <body>
        <%
            if (session.getAttribute("email") == null) {
                response.sendRedirect("../control/Login.jsp");
            }
            String email = (String) session.getAttribute("email");
            String firstname = dbbean.takeDoctorName(email);
            ResultSet table = PrescriptionDao.takeUserPrescription(firstname);

        %>
        <div id="header">
            <div class="clearfix">
                <div class="logo">
                    <a href="index.html" title="fff"></a>
                </div>
                <ul class="navigation">
                    <li>
                        <a href="Doctor.jsp">Doctor: <%= firstname%></a>

                    </li>
                    <li>
                        <a href="Doctor.jsp">Main</a>
                    </li>
                    <li>
                        <a href="../pages/MainPage.html">Logout</a>
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
                                <th>Dcotr name</th>

                                <th>Prescription ID</th>

                                <th>User Email</th>
                                
                                <th>Drug Name</th>
                                
                                <th>Using Info</th>
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