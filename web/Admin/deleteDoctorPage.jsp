<%@page import="java.sql.ResultSet"%>
<jsp:useBean id = "doctor" scope = "application" class = "controller.RegisterDao" >
</jsp:useBean>
<jsp:setProperty name = "doctor" property = "*" />
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Drug Store</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css" /> 
    </head>
    <body>
        <%
            
            ResultSet table = doctor.takeAllDoctor();
        %>


        <div id="header">
            <div class="clearfix">
                <div class="logo">
                    <a href="index.html" title="fff"></a>
                </div>
                <ul class="navigation">
                    <li>
                        <a href="index.html">Home</a>
                    </li>
                    <li>
                        <a href="about.html">About</a>
                    </li>

                    <li>
                        <a href="Login.html">Login</a>

                    </li>
                    <li class="active">
                        <a href="Register.html">Register</a>
                    </li>
                </ul>
            </div>
        </div>

        <div id="contents">
            <div class="clearfix">
                <div class="main">
                    <h1>Register</h1>
                    <form action="deleteDoctor.jsp" method="post" class="message">
                        <table>
                            <tr>
                                <th>Doctor Name</th>
                                <th>Last Name</th>
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
                                    <input type="radio" name="name" value="<%out.print(table.getString("name"));%>">
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
                         <p><input type = "submit" name = "Submit" value = "Submit" /></p>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>


