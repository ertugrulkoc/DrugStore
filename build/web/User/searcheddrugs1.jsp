<%@page import="java.sql.ResultSet"%>
<%@page import="controller.DrugDao"%>
<%@page import="controller.PrescriptionDao"%>
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

            ResultSet table = DrugDao.takesearchedDrugs(request.getParameter("search"));

            String drugname = request.getParameter("drugname");
            String price = request.getParameter("price");
            String prescriptionID = request.getParameter("prescriptionid");
            
          
           if(drugname!=null && price!=null){
                    chart.createBasket(drug, email);
           }
           
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
                        <a href="basketChart.jsp">Basket</a>
                    </li>
                    <li>
                        <a href="Register.html">Logout</a>
                    </li>
                </ul>
            </div>
        </div>


        <div id="contents">
            <div class="clearfix">
                <div class="main">
                    <h1>All Drugs</h1>
                    
                    <form action="searcheddrugs1.jsp" method="post" class="message">

            <center> <input type="text" name="search"  placeholder="Search"  onclick=" this.value = ''"/>
                <br>
                <center><p><input type = "submit" name = "Search1" value = "Search"/></p></center>
                     </form>
                    <form action="addChart.jsp" method="post" class="message">
                        <table>

                            <tr>

                                <th>Drug Name</th>

                                <th>Price</th>
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

                                    <input type="radio" name="drugname" value="<%out.print(table.getString("drugname"));%>"> 
                                    <input type="hidden" name="price" value="<%out.print(table.getString("price"));%>"> 
                                 

                                </td>
                            </tr>
                            <%}%>
                        </table>

                        &nbsp;

                        <center><p><input type = "submit" name = "Add" value = "Add"/></p></center>

                    </form>

                </div>
            </div>
        </div>

    </body>
</html>