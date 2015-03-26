package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>O Editor de Texto...</title>\n");
      out.write("\n");
      out.write("    <!-- CKEditor js -->\n");
      out.write("    <script src=\"ckeditor/ckeditor.js\"></script>\n");
      out.write("    <!-- Bootstrap Core CSS -->\n");
      out.write("    <link href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\" />\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link href=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\" />\n");
      out.write("    \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("    <!-- Navigation -->\n");
      out.write("    <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">O Editor de Texto</a>\n");
      out.write("            </div>\n");
      out.write("            <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"http://www.unisinos.br/\">Unisinos</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"http://moodle.unisinos.br/\">Moodle</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"http://github.com/paulograbin/DevWeb\">Código fonte</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-collapse -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container -->\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <!-- Page Content -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("        <!-- Jumbotron Header -->\n");
      out.write("        <header class=\"jumbotron hero-spacer\">\n");
      out.write("            <h1>Olá!</h1>\n");
      out.write("            <p>Seja bem vindo ao O Editor de Texto. O que você deseja fazer agora?</p>\n");
      out.write("            <p><a class=\"btn btn-primary btn-large\" onclick=\"createEditor();\">Criar novo texto</a>\n");
      out.write("            </p>\n");
      out.write("            \n");
      out.write("            <!-- This div will hold the editor. -->\n");
      out.write("            <div id=\"editor\"></div>\n");
      out.write("            <div id=\"contents\" style=\"display: none\">\n");
      out.write("                <p>\n");
      out.write("                    Edited Contents:\n");
      out.write("                </p>\n");
      out.write("                <!-- This div will be used to display the editor contents. -->\n");
      out.write("                <div id=\"editorcontents\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <!-- <script>\n");
      out.write("\n");
      out.write("                var editor, html = '';\n");
      out.write("\n");
      out.write("                function createEditor() {\n");
      out.write("                    if ( editor )\n");
      out.write("                        return;\n");
      out.write("\n");
      out.write("                    // Create a new editor inside the <div id=\"editor\">, setting its value to html\n");
      out.write("                    var config = {};\n");
      out.write("                    editor = CKEDITOR.appendTo( 'editor', config, html );\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                function removeEditor() {\n");
      out.write("                    if ( !editor )\n");
      out.write("                        return;\n");
      out.write("\n");
      out.write("                    // Retrieve the editor contents. In an Ajax application, this data would be\n");
      out.write("                    // sent to the server or used in any other way.\n");
      out.write("                    document.getElementById( 'editorcontents' ).innerHTML = html = editor.getData();\n");
      out.write("                    document.getElementById( 'contents' ).style.display = '';\n");
      out.write("\n");
      out.write("                    // Destroy the editor.\n");
      out.write("                    editor.destroy();\n");
      out.write("                    editor = null;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            </script> -->\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <hr>\n");
      out.write("        \n");
      out.write("       \n");
      out.write("        <!-- <script type=\"text/javascript\">\n");
      out.write("            function scriptSalva() {\n");
      out.write("                alert('Alertou');\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("            \n");
      out.write("        <script>\n");
      out.write("            // Test for checking if local storage is available.\n");
      out.write("            if(typeof(Storage) !== \"undefined\") {\n");
      out.write("                // Code for localStorage/sessionStorage.\n");
      out.write("                 alert('Browser suporta localStorage.');\n");
      out.write("            } else {\n");
      out.write("                // Sorry! No Web Storage support..\n");
      out.write("                 alert('Browser NÃO suporta localStorage.');\n");
      out.write("            }\n");
      out.write("        </script> -->\n");
      out.write("        \n");
      out.write("        <!-- Title -->\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-12\">\n");
      out.write("                <h3>Ultimos textos gravados...</h3>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.row -->\n");
      out.write("\n");
      out.write("        <!-- Page Features -->\n");
      out.write("        <div class=\"row text-center\">\n");
      out.write("\n");
      out.write("            <div class=\"col-md-3 col-sm-6 hero-feature\">\n");
      out.write("                <div class=\"thumbnail\">\n");
      out.write("                    <div class=\"caption\">\n");
      out.write("                        <h3>Feature Label</h3>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>\n");
      out.write("                        <p>\n");
      out.write("                            <a href=\"#\" class=\"btn btn-primary\">Abrir</a> <a href=\"#\" class=\"btn btn-default\">Apagar</a>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"col-md-3 col-sm-6 hero-feature\">\n");
      out.write("                <div class=\"thumbnail\">\n");
      out.write("                    <div class=\"caption\">\n");
      out.write("                        <h3>Feature Label</h3>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>\n");
      out.write("                        <p>\n");
      out.write("                            <a href=\"#\" class=\"btn btn-primary\">Abrir</a> <a href=\"#\" class=\"btn btn-default\">Apagar</a>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"col-md-3 col-sm-6 hero-feature\">\n");
      out.write("                <div class=\"thumbnail\">\n");
      out.write("                    <div class=\"caption\">\n");
      out.write("                        <h3>Feature Label</h3>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>\n");
      out.write("                        <p>\n");
      out.write("                            <a href=\"#\" class=\"btn btn-primary\">Abrir</a> <a href=\"#\" class=\"btn btn-default\">Apagar</a>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"col-md-3 col-sm-6 hero-feature\">\n");
      out.write("                <div class=\"thumbnail\">\n");
      out.write("                    <div class=\"caption\">\n");
      out.write("                        <h3>Feature Label</h3>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>\n");
      out.write("                        <p>\n");
      out.write("                            <a href=\"#\" class=\"btn btn-primary\">Abrir</a> <a href=\"#\" class=\"btn btn-default\">Apagar</a>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- /.row -->\n");
      out.write("\n");
      out.write("        <!-- Footer -->        \n");
      out.write("        <footer>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <p>Desenvolvido por Alexandre, Matheus, Paulo e Thiago. &copy; Your Website 2014</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /.container -->\n");
      out.write("\n");
      out.write("    <!-- jQuery -->\n");
      out.write("    <script src=\"bootstrap/js/jquery.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /index.jsp(22,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/bootstrap/css/bootstrap.min.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /index.jsp(24,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/bootstrap/css/heroic-features.css");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }
}
