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
                        <br> <input type="submit" value="Show Drugs"></br>

                    </form>



                </div>
            </div>
        </div>      


    </body>
</html>