package org.apache.jsp.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import controller.PrescriptionDao;

public final class maşnpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      controller.LoginDao dbbean = null;
      synchronized (_jspx_page_context) {
        dbbean = (controller.LoginDao) _jspx_page_context.getAttribute("dbbean", PageContext.PAGE_SCOPE);
        if (dbbean == null){
          dbbean = new controller.LoginDao();
          _jspx_page_context.setAttribute("dbbean", dbbean, PageContext.PAGE_SCOPE);
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
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/tableStyle.css\" />\n");
      out.write("        <title>All Donations</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            if (session.getAttribute("email") == null) {
                response.sendRedirect("drugspage.html");
            }
            String email = (String) session.getAttribute("email");
            String firstname = dbbean.takeDoctorName(email);

            ResultSet table = PrescriptionDao.takeAllPrescription();

        
      out.write("\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <div class=\"clearfix\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"index.html\" title=\"fff\"></a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"navigation\">\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"DoctorProfile.jsp\">Doctor: ");
      out.print( firstname);
      out.write("</a>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"Register.html\">Logout</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"contents\">\n");
      out.write("            <div class=\"clearfix\">\n");
      out.write("                <div class=\"main\">\n");
      out.write("                    <h1>All Prescriptions</h1>\n");
      out.write("                    <form action=\"DeleteDrug.jsp\" method=\"post\" class=\"message\">\n");
      out.write("                        <table>\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <th>prescriptionID</th>\n");
      out.write("\n");
      out.write("                                <th>drugName</th>\n");
      out.write("\n");
      out.write("                                <th>type</th>\n");
      out.write("                                \n");
      out.write("                                <th>date</th>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            ");
 while (table.next()) {
      out.write("   \n");
      out.write("                            <tr>    \n");
      out.write("\n");
      out.write("                                <td>            \n");
      out.write("                                    ");
out.print(table.getString("prescriptionID"));
      out.write(" \n");
      out.write("                                </td>\n");
      out.write("                                <td>            \n");
      out.write("                                    ");
out.print(table.getString("drugName"));
      out.write(" \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    ");
out.print(table.getString("type"));
      out.write("           \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    ");
out.print(table.getString("date"));
      out.write("           \n");
      out.write("                                </td>\n");
      out.write("                                <td>            \n");
      out.write("                                    <input type=\"radio\" name=\"uid\" value=\"\">\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </table>\n");
      out.write("\n");
      out.write("                        &nbsp;\n");
      out.write("\n");
      out.write("                        <center><p><input type = \"submit\" name = \"Submit\" value = \"Delete\"/></p></center>\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
