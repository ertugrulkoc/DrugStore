<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.PrescriptionDao"%>
<jsp:useBean id = "dbbean" scope = "session" class = "controller.LoginDao" >
</jsp:useBean>
<jsp:setProperty name = "dbbean" property = "*" />

<jsp:useBean id = "drug" class = "beans.Prescription" >
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
                response.sendRedirect("../pages/MainPage.html");
            }
            String email = (String) session.getAttribute("email");
            String firstname = dbbean.takeDoctorName(email);
        %> 
        <%
            drug.setDoctorname(firstname);
            
            String doctorname = firstname;
            String useremail = request.getParameter("useremail");
            String prescriptionid = request.getParameter("prescriptionid");
            String drugname = request.getParameter("drugname");
            String usinginfo = request.getParameter("usinginfo");

             if (useremail != null && prescriptionid != null && drugname !=null && usinginfo !=null ) {
                    boolean isSuccess = PrescriptionDao.checkPrescription(prescriptionid);
                    if(!isSuccess){
                         PrescriptionDao.createPrescription(drug);
                    }else{%>
                     <jsp:forward page="../Admin/errorAddDrug.jsp"/>
                     <% }
                        
                        }     
        %>
        <div id="header">
            <div class="clearfix">
                <div class="logo">
                    <a href="index.html" title="fff"></a>
                </div>
                <ul class="navigation">
                    <li>
                        <a href="Doctor.jsp">Doctor: <%= firstname%></a>

                    </li>
                    <li>
                        <a href="Doctor.jsp">Main</a>
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
                    <h1>Create Prescription</h1>
                    <form action="CreationPrescriptionPage.jsp" method="post" class="message">
                        
                        <label>Prescription ID: </label>
                        <input type="text" name="prescriptionid"  placeholder="Prescription ID" onclick=" this.value = ''"/>
                        
                        <label>User E-mail: </label>
                        <input type="text" name="useremail"  placeholder="User E-mail" onclick=" this.value = ''"/>
                        
                         <label>Drug Name:  </label>
                        <input type="text" name="drugname"  placeholder="Drug Name" onclick=" this.value = ''"/>
                        
                        <label>How to use: </label>
                        <input type="text" name="usinginfo"  placeholder="How to use" onclick=" this.value = ''"/>

                       

                        
                        &nbsp;
                        <br> <input type="submit" name ="create" value="Create" ></br>
                    </form>
                </div>
            </div>
        </div>


    </body>
</html>
