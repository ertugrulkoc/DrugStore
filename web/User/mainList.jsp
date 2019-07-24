<%@page import="java.sql.ResultSet"%>
<%@page import="controller.DrugDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "chart" class = "controller.ChartDao" >
</jsp:useBean>
<jsp:setProperty name = "chart" property = "*" />


<jsp:useBean id = "drug" class = "beans.Drug" >
</jsp:useBean>
<jsp:setProperty name = "drug" property = "*" />
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
            ResultSet table = DrugDao.takeAllDrug();


        %>
        <div id="header">
            <div class="clearfix">
                <div class="logo">
                    <a href="index.html" title="fff"></a>
                </div>
                <ul class="navigation">
                    <li class="active">
                        <a href="../pages/MainPage.html">Home</a>
                    </li>
                    <li>
                        <a href="../pages/adminLogin.html">Admin Login</a>
                    </li>

                    <li>
                        <a href="../pages/Login.html">Login</a>

                    </li>

                    <li>
                        <a href="../pages/RegisterPage.html">Register</a>
                    </li>
                </ul>
            </div>
        </div>
        <form action="searcheddrugs.jsp" method="post" class="message">

            <center> <input type="text" name="search"  placeholder="Search"  onclick=" this.value = ''"/>
                <br>
                <center><p><input type = "submit" name = "Search1" value = "Search"/></p></center>
                
        </form>

        <div id="contents">
            <div class="clearfix">
                <div class="main">
                    <h1>All Drugs</h1>
                    <form action="addChart.jsp" method="post" class="message">
                        <table>

                            <tr>

                                <th>Drug Name</th>

                                <th>Price</th>
                            </tr>


                            <% while (table.next()) {%>   
                            <tr>    


                                <td>            
                                    <%out.print(table.getString("drugName"));%> 
                                </td>
                                <td>
                                    <%out.print(table.getString("price"));%>           
                                </td>

                            </tr>
                            <%}%>
                        </table>
                    </form>

                </div>
            </div>
        </div>

    </body>
</html>