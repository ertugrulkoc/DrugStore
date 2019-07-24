<%@page import="java.sql.ResultSet"%>
<%@page import="controller.DrugDao"%>
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
        <title>All Drugs</title>
    </head>
    <body>
        <%
            if (session.getAttribute("email") == null) {
                response.sendRedirect("../control/Login.jsp");
            }
            String email = (String) session.getAttribute("email");
            String firstname = dbbean.takeAdminName(email);

            ResultSet table = DrugDao.takeAllDrug();

        %>
        <div id="header">
            <div class="clearfix">
                <div class="logo">
                   
                </div>
                <ul class="navigation">
                    <li>
                        <a href="admin.jsp">Admin: <%= firstname%></a>
                    </li>

                    <li>
                        <a href="addDrug.jsp">Add Drug</a>
                    </li>
                    
                    <li>
                        <a href="editDrug.jsp">Edit Drug</a>
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
                    <center><h1>List Drugs</h1>
                        <form action="deleteDrug.jsp" method="post" class="message">
                            <table>

                                <tr>

     
                                    <th>Drug Name</th>

                                    <th>Price</th>
                                    
                                    <th>Drug Information</th>

                                    <th>Stock</th>
                                    
                                </tr>


                                <% while (table.next()) {%>   
                                <tr>    

                                    <td>            
                                        <%out.print(table.getString("drugname"));%> 
                                    </td>
                                   
                                    <td>
                                        <%out.print(table.getString("price"));%>           
                                    </td>
                                     <td>
                                        <%out.print(table.getString("info"));%>           
                                    </td>
                                     <td>
                                        <%out.print(table.getString("stock"));%>           
                                    </td>
                                    <td>            
                                        <input type="radio" name="drugName" value="<%out.print(table.getString("drugname"));%>"> 
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