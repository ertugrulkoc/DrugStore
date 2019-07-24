<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "dbbean" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "dbbean" property = "*" />

<jsp:useBean id = "reg" scope = "session" class = "controller.RegisterDao" >
</jsp:useBean>
<jsp:setProperty name = "reg" property = "*" />

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
            String firstname = dbbean.takeAdminName(email);
            
            ResultSet table = reg.takeDoctor("pending");
            
        %>
        <div id="header">
            <div class="clearfix">
                <div class="logo">
                    <a href="index.html" title="fff"></a>
                </div>
                <ul class="navigation">
                    <li class="active">
                        <a href="admin.jsp">Admin: <%= firstname%></a>
                    </li>
                    
                    <li>
                        <a href="doctorList.jsp">Doctor List</a>
                    </li>
                    
                    <li>
                        <a href="drugList.jsp">Drugs</a>
                    </li>
                    <li>
                        <a href="stockList.jsp">Stock List</a>
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
                    <h1>Accept Doctor</h1>
                    <form action="checkDoctor.jsp" method="post" class="message">
                        <table>
                            <tr>
                                <th>Doctor Name</th>
                                <th>Doctor Last Name</th>
                                <th>email</th>
                                <th>Password</th>


                            </tr>
                            <% while (table.next()) {%>   
                            <tr>       
                                <td>
                                    <%out.print(table.getString("name"));%> 
                                </td>
                                <td>            
                                    <%out.print(table.getString("lastName"));%> 
                                </td>
                                <td>
                                    <%out.print(table.getString("email"));%>           
                                </td>
                                <td>
                                    <%out.print(table.getString("password"));%>           
                                </td>

                                <td>
                                    <input type="radio" name="email" value="<%out.print(table.getString("email"));%>">
                                </td>
                            </tr>
                            <%}%>
                        </table>

                        <p></p>

                        <table>
                            <tr>
                                <td>
                                    <select size = "1" name = "status">
                                        <option value = "approved">Approve</option>
                                        <option value = "rejected">Reject</option>
                                    </select>
                                </td>

                            </tr>
                        </table>
                        &nbsp;
                        <p><input type = "submit" name = "Submit" value = "Apply" /></p>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>


