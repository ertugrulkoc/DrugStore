<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.DrugDao"%>
<jsp:useBean id = "dbbean" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "dbbean" property = "*" />

<jsp:useBean id = "drug" class = "beans.Drug" >
</jsp:useBean>
<jsp:setProperty name = "drug" property = "*" />

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
            String firstname = dbbean.takeAdminName(email);
              
          try{
            String drugname = request.getParameter("drugname");
            String price = request.getParameter(String.valueOf("price"));
            String info = request.getParameter("info");
            String stock = request.getParameter(String.valueOf("stock"));

            if (drugname != null && price != null && info !=null && stock !=null ) {
                      boolean isSuccess = DrugDao.editDrug(drug);
                    if(isSuccess){%>
                     <jsp:forward page="../Admin/admin.jsp"/>
                     <% }
                    else{%>
                     <jsp:forward page="../Admin/errorAddDrug.jsp"/>
                     <% }
                        
                        }     
         
              }catch(NumberFormatException e){
                    out.println("Error: price and stock must be a integer " + e.getMessage());
          }  
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
                    <h1>Update Drug</h1>
                    <form action="editDrug.jsp" method="post" class="message">
   
                 
                        <label>Drug Name:  </label>
                        <input type="text" name="drugname"  placeholder="Drug Name" onclick=" this.value = ''">

                        <label>Price: </label>
                        <input type="text" name="price"  placeholder="Price" onclick=" this.value = ''"/>
                        
                        <label>Drug Info:  </label>
                        <input type="text" name="info"  placeholder="Drug Information" onclick=" this.value = ''">

                        <label>Stock: </label>
                        <input type="text" name="stock"  placeholder="Stock" onclick=" this.value = ''"/>
                        
                        &nbsp;
                        <br> <input type="submit" name ="update" value="Update"></br>  
                       
               
                    </form>
                </div>
            </div>
        </div>


    </body>
</html>
