package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import beans.User;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registration Form</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
      beans.User user = null;
      synchronized (request) {
        user = (beans.User) _jspx_page_context.getAttribute("user", PageContext.REQUEST_SCOPE);
        if (user == null){
          user = new beans.User();
          _jspx_page_context.setAttribute("user", user, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write(" \n");
      out.write("        <form action=\"RegisterController\" method=\"post\">\n");
      out.write("            <center>\n");
      out.write("                <table border=\"1\" width=\"15%\" cellpadding=\"5\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th colspan=\"2\">Register Form</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>    \n");
      out.write("                            <td>First Name : </td>\n");
      out.write("                            <td><input type=\"text\" name=\"firstname\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((beans.User)_jspx_page_context.findAttribute("user")).getFirstName())));
      out.write("\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>    \n");
      out.write("                            <td>Last Name : </td>\n");
      out.write("                            <td><input type=\"text\" name=\"lastname\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((beans.User)_jspx_page_context.findAttribute("user")).getLastName())));
      out.write("\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>    \n");
      out.write("                            <td>Username : </td>\n");
      out.write("                            <td><input type=\"text\" name=\"email\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((beans.User)_jspx_page_context.findAttribute("user")).getEmail())));
      out.write("\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Password : </td>\n");
      out.write("                            <td><input type=\"password\" name=\"password\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((beans.User)_jspx_page_context.findAttribute("user")).getPassword())));
      out.write("\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><center><input type=\"reset\" value=\"Reset\" /></center></td>\n");
      out.write("                            <td><center><input type=\"submit\" value=\"Register\"></center></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>             \n");
      out.write("                </table>\n");
      out.write("            </center>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <div style=\"position: relative\">\n");
      out.write("            <div style=\"position: fixed ; bottom: 0 ; width:100% ; text-align:center \">\n");
      out.write("                <p><a href=\"https://www.youtube.com/user/TechWorld3g?sub_confirmation=1\">CLICK HERE TO SUBSCRIBE</a></p>\n");
      out.write("            </div>\n");
      out.write("        </div>                  \n");
      out.write("                        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
