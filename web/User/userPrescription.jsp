<%@page import="java.sql.ResultSet"%>
<%@page import="controller.PrescriptionDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "log" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "log" property = "*" />
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Drug Store</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css" /> 
    </head>
    <body>

        <%
            if (session.getAttribute("email") == null) {
                response.sendRedirect("../control/Login.jsp");
            }
            String email = (String) session.getAttribute("email");
            String firstname = log.takeUserName(email);

            ResultSet table=PrescriptionDao.takeUserPrescription1(email);
        %>


        <div id="header">
            <div class="clearfix">
                <div class="logo">

                </div>
                <ul class="navigation">


                    <li>
                        <a href="user.jsp">User: <%= firstname%></a>
                    </li>
                    <li>
                        <a href="userPrescription.jsp">Prescription</a>
                    </li>

                    <li>
                        <a href="basketChart.jsp">Basket</a>
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
                    <h1>User Main Page</h1>


                    <form action="mainDrugList.jsp" method="post" class="message">
                        <table>

                            <tr>

                                <th>Doctor Name</th>

                                <th>Prescription ID</th>
                                
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
                                    <%out.print(table.getString("drugname"));%>           
                                </td>
                                <td>
                                    <%out.print(table.getString("usinginfo"));%>           
                                </td>

                            </tr>
                            <%}%>
                        </table>
                        <br> <input type="submit" value="Show Drugs"></br>

                    </form>




                </div>
            </div>
        </div>      




    </body>
</html>