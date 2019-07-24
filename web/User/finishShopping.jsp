<%@page import="controller.ChartDao"%>
<%@page import="controller.LoginDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.PrescriptionDao"%>
<jsp:useBean id = "dbbean" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "dbbean" property = "*" />

<jsp:useBean id = "login" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "login" property = "*" />


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Drug Store</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" /> 
    </head>
    <body>
        <%
               if (session.getAttribute("email") == null) {
                response.sendRedirect("../control/Login.jsp");
            }
            String email = (String) session.getAttribute("email");
            String firstname = login.takeUserName(email);
        %> 

        <div id="header">
            <div class="clearfix">
                <div class="logo">

                </div>
                <ul class="navigation">
                    <li class="active">
                        <a href="user.jsp">Home</a>
                    </li>

                    <li>
                        <a href="user.jsp">User: <%= firstname%></a>
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
                    <h1>Continue Shopping : <%= firstname%></h1>
                    <form action="response.jsp" method="post" class="message">
                        
                        <label>Adress:  </label>
                        <input type="text" name="adress"  placeholder="adress" onclick=" this.value = ''"/>
                        <label>Credit Card No:  </label>
                        <input type="text" name="creditcardno"  placeholder="creditcardno" onclick=" this.value = ''"/>
                        <label>Expiration Date:  </label>
                        <input type="text" name="expirationdate"  placeholder="expirationdate" onclick=" this.value = ''"/>
                        <label>Cvc 2:  </label>
                        <input type="text" name="cvc2"  placeholder="cvc2" onclick=" this.value = ''"/>
                        &nbsp;
                        <br> <input type="submit" name ="create" value="Finish" ></br>
                    </form>
                </div>
            </div>
        </div>


    </body>
</html>
