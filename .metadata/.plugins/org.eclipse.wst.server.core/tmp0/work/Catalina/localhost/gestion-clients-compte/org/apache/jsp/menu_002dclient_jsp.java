/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.41
 * Generated at: 2020-04-02 18:11:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_002dclient_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\"\r\n");
      out.write("\tcontent=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">\r\n");
      out.write("<meta name=\"generator\" content=\"Jekyll v3.8.6\">\r\n");
      out.write("    <title>menu principal</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("<link href=\"assets/styles/bootstrap.min.css\" rel=\"stylesheet\" >\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"assets/styles/styleMenu.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"assets/css/dashboard.css\" rel=\"stylesheet\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div class=\"d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm\" >\r\n");
      out.write("  <h5 class=\"my-0 mr-md-auto font-weight-normal\">Gestion des clients</h5>\r\n");
      out.write("  \r\n");
      out.write("  <!-- on test la présence de l'attribut de session 'isLogged' dans la session -->\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center\">\r\n");
      out.write("  <h1 class=\"display-4\">Menu gestion des clients</h1>\r\n");
      out.write("  <p class=\"lead\">Faites votre choix</p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("  <div class=\"card-deck mb-3 text-center\">\r\n");
      out.write("  \r\n");
      out.write("  \t<div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("  \t<form class=\"form-signin\" method=\"post\" action=\"gestion-client-servlet\">\r\n");
      out.write("     <div class=\"card-body\">\r\n");
      out.write("      \t<h1 class=\"card-title pricing-card-title\">Liste des clients</h1>\r\n");
      out.write("      \t <input type=\"hidden\" name=\"action\" value=\"liste\"/>\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-lg btn-block btn-outline-primary\" >Afficher </button>\r\n");
      out.write("      </div><!-- end card-body -->\r\n");
      out.write("     </form>\r\n");
      out.write("    </div><!-- end card mb-4 shadow-sm -->\r\n");
      out.write("    <div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("    <form class=\"form-signin\" method=\"post\" action=\"gestion-client-servlet\">\r\n");
      out.write("     <div class=\"card-body\">\r\n");
      out.write("      \t<h1 class=\"card-title pricing-card-title\">Ajout d'un client</h1>\r\n");
      out.write("      \t<input type=\"hidden\" name=\"action\" value=\"ajout\"/>\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-lg btn-block btn-outline-primary\" >Ajouter</button>\r\n");
      out.write("      </div><!-- end card-body -->\r\n");
      out.write("       </form>\r\n");
      out.write("    </div><!-- end card mb-4 shadow-sm -->\r\n");
      out.write("    <div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("    <form class=\"form-signin\" method=\"post\" action=\"gestion-client-servlet\">\r\n");
      out.write("     <div class=\"card-body\">\r\n");
      out.write("      \t<h1 class=\"card-title pricing-card-title\">Modifification d'un client</h1>\r\n");
      out.write("      \t<input type=\"hidden\" name=\"action\" value=\"modif\"/>\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-lg btn-block btn-outline-primary\" >Modifier</button>\r\n");
      out.write("      </div><!-- end card-body -->\r\n");
      out.write("      </form>\r\n");
      out.write("      </div>\r\n");
      out.write("    <div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("    <form class=\"form-signin\" method=\"post\" action=\"gestion-client-servlet\">\r\n");
      out.write("      <div class=\"card-body\">\r\n");
      out.write("      \t<h1 class=\"card-title pricing-card-title\">Suppression d'un client</h1>\r\n");
      out.write("          <input type=\"hidden\" name=\"action\" value=\"supprimer\"/>\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-lg btn-block btn-primary\">Supprimer</button>\r\n");
      out.write("      </div>\r\n");
      out.write("       </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link active\" href=\"gestion-pages-servlet?action=chercherClient\">\r\n");
      out.write("              Chercher un client\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write(" </form> \r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /menu-client.jsp(33,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty isLogged}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("  <a class=\"btn btn-outline-primary\" href=\"authentification-servlet?destroy=true\">Se déconnecter</a>\r\n");
          out.write("  ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}
