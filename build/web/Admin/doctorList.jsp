<%@page import="java.sql.ResultSet"%>
<%@page import="controller.LoginDao"%>
<%@page import="controller.RegisterDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "dbbean" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "dbbean" property = "*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tableStyle.css" />
        <title>All Doctors</title>
    </head>
    <body>
        <%
            if (session.getAttribute("email") == null) {
                response.sendRedirect("../control/Login.jsp");
            }
            String email = (String) session.getAttribute("email");
            String firstname = dbbean.takeAdminName(email);

            ResultSet table = RegisterDao.takeAllDoctor();
          
        %>
        <div id="header">
            <div class="clearfix">
                <div class="logo">
                    <a href="index.html" title="fff"></a>
                </div>
                <ul class="navigation">

                    <li>
                        <a href="admin.jsp">Admin: <%= firstname%></a>
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
                    <center><h1>All Doctors</h1>
                        <form action="deleteDoctor.jsp" method="post" class="message">
                            <table>

                                <tr>


                                    <th>First Name</th>

                                    <th>Last Name</th>

                                    <th>Email</th>

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

                            &nbsp;

                            <p><input type = "submit" name = "Delete" value = "Delete"/></p></center>

                </div>
            </div>
        </div>

    </body>
</html>
