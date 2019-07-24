package org.apache.jsp.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Doctor_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      controller.LoginDao dbbean = null;
      synchronized (session) {
        dbbean = (controller.LoginDao) _jspx_page_context.getAttribute("dbbean", PageContext.SESSION_SCOPE);
        if (dbbean == null){
          dbbean = new controller.LoginDao();
          _jspx_page_context.setAttribute("dbbean", dbbean, PageContext.SESSION_SCOPE);
          out.write('\n');
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("dbbean"), request);
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\" />\n");
      out.write("    <title>User Page</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");

        if(session.getAttribute("email") == null){
            response.sendRedirect("drugspage.html");
        }
        String email = (String)session.getAttribute("email");
        String firstname = dbbean.takeDoctorName(email);
    
      out.write("\n");
      out.write("     <div id=\"header\">\n");
      out.write("            <div class=\"clearfix\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"index.html\" title=\"fff\"></a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"navigation\">\n");
      out.write("                    <li class=\"active\">\n");
      out.write("                        <a href=\"index.html\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"about.html\">About</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"news.html\">Login</a>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                         <a href=\"Register.html\">Register</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"featured\">\n");
      out.write("            <h2>Drugs</h2>\n");
      out.write("            <ul class=\"clearfix\">\n");
      out.write("                <li>\n");
      out.write("                    <div class=\"frame1\">\n");
      out.write("                        <div class=\"box\">\n");
      out.write("                            <img src=\"images/meeting.jpg\" alt=\"Img\" height=\"130\" width=\"197\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <p>\n");
      out.write("                        <b>Drug 1\n");
      out.write("                    </p>\n");
      out.write("                    <a href=\"index.html\" class=\"more\">Add To Cart</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <div class=\"frame1\">\n");
      out.write("                        <div class=\"box\">\n");
      out.write("                            <img src=\"images/handshake.jpg\" alt=\"Img\" height=\"130\" width=\"197\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <p>\n");
      out.write("                        <b>Drug 2\n");
      out.write("                    </p>\n");
      out.write("                    <a href=\"index.html\" class=\"more\">Add To Cart</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <div class=\"frame1\">\n");
      out.write("                        <div class=\"box\">\n");
      out.write("                            <img src=\"images/smile.jpg\" alt=\"Img\" height=\"130\" width=\"197\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <p>\n");
      out.write("                        <b>Drug 3\n");
      out.write("                    </p>\n");
      out.write("                    <a href=\"index.html\" class=\"more\">Add To Cart</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <div class=\"frame1\">\n");
      out.write("                        <div class=\"box\">\n");
      out.write("                            <img src=\"images/family-small.jpg\" alt=\"Img\" height=\"130\" width=\"197\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <p>\n");
      out.write("                        <b>Drug 4\n");
      out.write("                    </p>\n");
      out.write("                    <a href=\"index.html\" class=\"more\">Add To Cart</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("</body>\n");
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
