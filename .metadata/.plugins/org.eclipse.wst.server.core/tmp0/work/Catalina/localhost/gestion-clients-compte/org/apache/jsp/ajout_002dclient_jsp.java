/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.41
 * Generated at: 2020-04-02 18:26:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.intiformation.gestion.model.Client;

public final class ajout_002dclient_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1585301799285L));
    _jspx_dependants.put("jar:file:/C:/Users/IN-DF-029/Documents/Cours/JSP-SERVLET/03_JSP-SERVLET/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/02_projet_gestion_clients_compte/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153377882000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.intiformation.gestion.model.Client");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>ajout client</title>\r\n");
      out.write("<!-- Bootstrap core CSS -->\r\n");
      out.write("<link href=\"assets/styles/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("      .bd-placeholder-img {\r\n");
      out.write("        font-size: 1.125rem;\r\n");
      out.write("        text-anchor: middle;\r\n");
      out.write("        -webkit-user-select: none;\r\n");
      out.write("        -moz-user-select: none;\r\n");
      out.write("        -ms-user-select: none;\r\n");
      out.write("        user-select: none;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      @media (min-width: 768px) {\r\n");
      out.write("        .bd-placeholder-img-lg {\r\n");
      out.write("          font-size: 3.5rem;\r\n");
      out.write("        }\r\n");
      out.write("      }\r\n");
      out.write("    </style>\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"assets/styles/styleModif.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"bg-light\">\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("<div class=\"py-5 text-center\">\r\n");
      out.write("    <img class=\"d-block mx-auto mb-4\" src=\"assets/images/banque.jpg\" alt=\"\" width=\"72\" height=\"72\">\r\n");
      out.write("    <h2>Ajouter un client</h2>\r\n");
      out.write("   \r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"col-md-8 order-md-1\">\r\n");
      out.write("      <h4 class=\"mb-3\">Coordonnées du client</h4>\r\n");
      out.write("      <form class=\"needs-validation\" novalidate method=\"post\" action=\"gestion-client-servlet\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-md-6 mb-3\">\r\n");
      out.write("            <label for=\"firstName\">Nom</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"firstName\" placeholder=\"\" name=\"pNom\"  required>\r\n");
      out.write("            <div class=\"invalid-feedback\">\r\n");
      out.write("              Valid first name is required.\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-md-6 mb-3\">\r\n");
      out.write("            <label for=\"lastName\">Prénom</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"lastName\" placeholder=\"\" name=\"pPrenom\"  required>\r\n");
      out.write("            <div class=\"invalid-feedback\">\r\n");
      out.write("              Valid last name is required.\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"mb-3\">\r\n");
      out.write("          <label for=\"address\">Adresse</label>\r\n");
      out.write("          <input type=\"text\" class=\"form-control\" id=\"address\" placeholder=\"6 rue Monge\" name=\"pAdresse\"  required>\r\n");
      out.write("          <div class=\"invalid-feedback\">\r\n");
      out.write("            Veuillez renseigner l'adresse\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("     \r\n");
      out.write("          <div class=\"col-md-4 mb-3\">\r\n");
      out.write("            <label for=\"state\">Ville</label>\r\n");
      out.write("            <input type=\"text\" name=\"pVille\" />\r\n");
      out.write("            <select class=\"custom-select d-block w-100\" id=\"state\" required>\r\n");
      out.write("              <option value=\"\">Choose...</option>\r\n");
      out.write("              <option>Paris</option>\r\n");
      out.write("              <option>Lyon</option>\r\n");
      out.write("              <option>Marseille</option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <div class=\"invalid-feedback\">\r\n");
      out.write("              Entrez une ville valide.\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-md-3 mb-3\">\r\n");
      out.write("            <label for=\"zip\">Code Postal</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"zip\" placeholder=\"75000\" name=\"pCodePostal\" required>\r\n");
      out.write("            <div class=\"invalid-feedback\">\r\n");
      out.write("              Code postal requis.\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-md-3 mb-3\">\r\n");
      out.write("            <label for=\"zip\">Téléphone</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"\" placeholder=\"0102136548\" name=\"pTelephone\"  required>\r\n");
      out.write("           \r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-md-6 mb-3\">\r\n");
      out.write("            <label for=\"lastName\">Identifiant du conseiller</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"lastName\" placeholder=\"\" name=\"pConseillerID\" >\r\n");
      out.write("            \r\n");
      out.write("          </div>\r\n");
      out.write("      \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("     \r\n");
      out.write("       \r\n");
      out.write("        \r\n");
      out.write("        <hr class=\"mb-4\">\r\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"ajouter\"/>\r\n");
      out.write("        <button class=\"btn btn-primary btn-lg btn-block\" type=\"submit\">Ajouter</button>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}