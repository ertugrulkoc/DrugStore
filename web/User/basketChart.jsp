<%@page import="java.sql.ResultSet"%>
<%@page import="controller.ChartDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "chart" class = "controller.ChartDao" >
</jsp:useBean>
<jsp:setProperty name = "chart" property = "*" />

<jsp:useBean id = "login" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "login" property = "*" />

<jsp:useBean id = "drug" class = "beans.Drug" >
</jsp:useBean>
<jsp:setProperty name = "drug" property = "*" />

<jsp:useBean id = "user" class = "beans.User" >
</jsp:useBean>
<jsp:setProperty name = "user" property = "*" />
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
            String firstname = login.takeUserName(email);

            ResultSet table = ChartDao.takeAllBasket(email);

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
                    <h1>All Drugs</h1>
                    <form action="deleteChart.jsp" method="post" class="message">
                        <table>

                            <tr>

                                <th>Drug Name</th>

                                <th>Price</th>
                            </tr>


                            <% while (table.next()) {%>   
                            <tr>    

                                <td>            
                                    <%out.print(table.getString("name"));%> 
                                </td>
                                <td>
                                    <%out.print(table.getString("price"));%>           
                                </td>
                                <td>            
                                    <input type="radio" name="name" value="<%out.print(table.getString("name"));%>"> 
                                    <input type="hidden" name="price" value="<%out.print(table.getString("price"));%>"> 

                                </td>
                            </tr>
                            <%}%>
                        </table>

                        &nbsp;
                                
                        <center><p><input type = "submit" name = "Delete" value = "Delete"/></p></center>

                    </form>
                        <center><p><a href="mainDrugList.jsp">Continue Shopping</a> </p></center>
                        <center><p><a href="finishShopping.jsp">Finish Shopping</a> </p></center>
                        
                        Total Price : <%out.print(ChartDao.takeAllBasketPrice(email));%>

                </div>
            </div>
        </div>

    </body>
</html>