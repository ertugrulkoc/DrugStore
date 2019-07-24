package org.apache.jsp.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.DrugDao;

public final class addDrugPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      controller.LoginDao dbbean = null;
      synchronized (session) {
        dbbean = (controller.LoginDao) _jspx_page_context.getAttribute("dbbean", PageContext.SESSION_SCOPE);
        if (dbbean == null){
          dbbean = new controller.LoginDao();
          _jspx_page_context.setAttribute("dbbean", dbbean, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("dbbean"), request);
      out.write("\r\n");
      out.write("\r\n");
      beans.Drug drug = null;
      synchronized (_jspx_page_context) {
        drug = (beans.Drug) _jspx_page_context.getAttribute("drug", PageContext.PAGE_SCOPE);
        if (drug == null){
          drug = new beans.Drug();
          _jspx_page_context.setAttribute("drug", drug, PageContext.PAGE_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("drug"), request);
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <title>Drug Store</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/style.css\" /> \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("     \r\n");
      out.write("        ");

           
            String prescriptionid = request.getParameter("prescriptionID");
            String drugname = request.getParameter("drugName");
             String type = request.getParameter("type");
            String date = request.getParameter("date");

            if (prescriptionid != null && drugname != null) {
                System.out.println("presid: " + prescriptionid + " drgunmae: " + drugname);
                DrugDao.addDrug(drug);
                
            }
        
      out.write("\r\n");
      out.write("        <div id=\"header\">\r\n");
      out.write("            <div class=\"clearfix\">\r\n");
      out.write("                <div class=\"logo\">\r\n");
      out.write("                    <a href=\"index.html\" title=\"fff\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <ul class=\"navigation\">\r\n");
      out.write("                    \r\n");
      out.write("\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"Login.html\">Logout</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"contents\">\r\n");
      out.write("            <div class=\"clearfix\">\r\n");
      out.write("                <div class=\"main\">\r\n");
      out.write("                    <h1>Add Drug</h1>\r\n");
      out.write("                    <form action=\"addDrugPage.jsp\" method=\"post\" class=\"message\">\r\n");
      out.write("\r\n");
      out.write("                       \r\n");
      out.write("\r\n");
      out.write("                        <label>Prescription ID: </label>\r\n");
      out.write("                        <input type=\"text\" name=\"prescriptionID\"  placeholder=\"Prescription ID\" onclick=\" this.value = ''\"/>\r\n");
      out.write("\r\n");
      out.write("                        <label>Drug Name:  </label>\r\n");
      out.write("                          <input type=\"text\" name=\"drugName\"  placeholder=\"Drug Name\" onclick=\" this.value = ''\">\r\n");
      out.write("                         \r\n");
      out.write("                         <label>Type: </label>\r\n");
      out.write("                        <input type=\"text\" name=\"type\"  placeholder=\"Type\" onclick=\" this.value = ''\"/>\r\n");
      out.write("                        \r\n");
      out.write("                         <label>Date: </label>\r\n");
      out.write("                        <input type=\"text\" name=\"date\"  placeholder=\"Expiration Date\" onclick=\" this.value = ''\"/>\r\n");
      out.write("                        &nbsp;\r\n");
      out.write("                        <br> <input type=\"submit\" name =\"create\" value=\"Create\" ></br>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
