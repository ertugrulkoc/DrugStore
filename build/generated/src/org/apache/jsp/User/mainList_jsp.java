package org.apache.jsp.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import controller.DrugDao;

public final class mainList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      controller.ChartDao chart = null;
      synchronized (_jspx_page_context) {
        chart = (controller.ChartDao) _jspx_page_context.getAttribute("chart", PageContext.PAGE_SCOPE);
        if (chart == null){
          chart = new controller.ChartDao();
          _jspx_page_context.setAttribute("chart", chart, PageContext.PAGE_SCOPE);
          out.write('\n');
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("chart"), request);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      beans.Drug drug = null;
      synchronized (_jspx_page_context) {
        drug = (beans.Drug) _jspx_page_context.getAttribute("drug", PageContext.PAGE_SCOPE);
        if (drug == null){
          drug = new beans.Drug();
          _jspx_page_context.setAttribute("drug", drug, PageContext.PAGE_SCOPE);
          out.write('\n');
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("drug"), request);
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
try {
      out.write("\n");
      out.write("        <html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/tableStyle.css\" />\n");
      out.write("        <title>All Drugs</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            ResultSet table = DrugDao.takeAllDrug();


        
      out.write("\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <div class=\"clearfix\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"index.html\" title=\"fff\"></a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"navigation\">\n");
      out.write("                    <li class=\"active\">\n");
      out.write("                        <a href=\"../pages/MainPage.html\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"../pages/adminLogin.html\">Admin Login</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"../pages/Login.html\">Login</a>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"../pages/RegisterPage.html\">Register</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <form action=\"searcheddrugs.jsp\" method=\"post\" class=\"message\">\n");
      out.write("\n");
      out.write("            <center> <input type=\"text\" name=\"search\"  placeholder=\"Search\"  onclick=\" this.value = ''\"/>\n");
      out.write("                <br>\n");
      out.write("                <center><p><input type = \"submit\" name = \"Search1\" value = \"Search\"/></p></center>\n");
      out.write("                \n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <div id=\"contents\">\n");
      out.write("            <div class=\"clearfix\">\n");
      out.write("                <div class=\"main\">\n");
      out.write("                    <h1>All Drugs</h1>\n");
      out.write("                    <form action=\"addChart.jsp\" method=\"post\" class=\"message\">\n");
      out.write("                        <table>\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("\n");
      out.write("                                <th>Drug Name</th>\n");
      out.write("\n");
      out.write("                                <th>Price</th>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            ");
 while (table.next()) {
      out.write("   \n");
      out.write("                            <tr>    \n");
      out.write("\n");
      out.write("\n");
      out.write("                                <td>            \n");
      out.write("                                    ");
out.print(table.getString("drugName"));
      out.write(" \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    ");
out.print(table.getString("price"));
      out.write("           \n");
      out.write("                                </td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("    ");
} catch (Exception e) {
        out.print(e.getMessage());
   }
      out.write('\n');
      out.write('\n');
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
