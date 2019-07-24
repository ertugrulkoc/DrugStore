package org.apache.jsp.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LoginError_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <title>Login Error</title>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/style.css\" />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"pagewidth\">\n");
      out.write("\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <!-- TITLE -->\n");
      out.write("            <h1><a href=\"index.jsp\">Drug Store</a></h1> \n");
      out.write("            <!-- END TITLE -->\n");
      out.write("        </div>\n");
      out.write(" <div id=\"header\">\n");
      out.write("            <div class=\"clearfix\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"index.html\" title=\"fff\"></a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"navigation\">\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"index.html\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"about.html\">About</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"active\">\n");
      out.write("                        <a href=\"pages/Login.html\">Login</a>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"Register.html\">Register</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"page-wrap\">\n");
      out.write("            <div class=\"content\">\n");
      out.write("\n");
      out.write("                <!-- CONTENT -->\n");
      out.write("                \n");
      out.write("                <h2>Error acquired!</h2>\n");
      out.write("                <p>Something went wrong. Please check your informations and try again.</p>\n");
      out.write("                \n");
      out.write("              \n");
      out.write("         \n");
      out.write("                <!-- END CONTENT -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"clear\"></div>\t\t\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("     \n");
      out.write("    </div>\n");
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
