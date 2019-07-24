package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Drug Store</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/style.css\" /> \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            if (session.getAttribute("email") == null) {
                response.sendRedirect("../control/Login.jsp");
            }
            String email = (String) session.getAttribute("email");
            String firstname = dbbean.takeAdminName(email);
        
      out.write("\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <div class=\"clearfix\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"index.html\" title=\"fff\"></a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"navigation\">\n");
      out.write("                    <li class=\"active\">\n");
      out.write("                        <a href=\"admin.jsp\">Admin: ");
      out.print( firstname);
      out.write("</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"acceptDoctor.jsp\">Accept Doctor</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"../control/Logout.jsp\">Logout</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"contents\">\n");
      out.write("            <div class=\"clearfix\">\n");
      out.write("                <div class=\"main\">\n");
      out.write("                    <h1>Admin Main Page</h1>\n");
      out.write("\n");
      out.write("                    <form action=\"addDrug.jsp\" method=\"post\" class=\"message\">\n");
      out.write("                         <input type=\"submit\" value=\"Add New Drug\">\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                    <form action=\"drugList.jsp\" method=\"post\" class=\"message\">\n");
      out.write("                         <input type=\"submit\" value=\"Drugs List\">\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <form action=\"doctorList.jsp\" method=\"post\" class=\"message\">\n");
      out.write("                         <input type=\"submit\" value=\"Doctors List\">\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
