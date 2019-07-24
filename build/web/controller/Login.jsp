<%@page import="controller.LoginDao"%>  
<jsp:useBean id="obj" class="beans.User"/> 
  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
int status= LoginDao.login(obj);  
if(status>0)  
out.print("You are successfully registered");  
else
out.print("errorr");
  
%>

