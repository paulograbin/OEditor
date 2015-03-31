package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.unisinos.devweb.backend.Gerenciador;

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

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    ");

    	Gerenciador g = Gerenciador.getGerenciador();
            g.init(request.getRealPath(""));
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <title>O Editor de Texto</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- CKEditor js -->\r\n");
      out.write("    <script src=\"ckeditor/ckeditor.js\"></script>\r\n");
      out.write("    <!-- Bootstrap Core CSS -->\r\n");
      out.write("    <link href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- Custom CSS -->\r\n");
      out.write("    <link href=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\" />\r\n");
      out.write("    \r\n");
      out.write("    <script>\r\n");
      out.write("    \r\n");
      out.write("        var count = 0;\r\n");
      out.write("        \r\n");
      out.write("        // Retorna o conteúdo do editor\r\n");
      out.write("        function getContents() {\r\n");
      out.write("            // Get the editor instance that you want to interact with.\r\n");
      out.write("            var editor = CKEDITOR.instances.editor1;\r\n");
      out.write("\r\n");
      out.write("            // Get editor contents\r\n");
      out.write("            // http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-getData\r\n");
      out.write("            \r\n");
      out.write("            return editor.getData();\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        // Adiciona div contendo o texto salvo\r\n");
      out.write("        function adicionaTextoSalvo() {\r\n");
      out.write("            count = count + 1;\r\n");
      out.write("            console.log(\"adicionando texto na div \" + count);\r\n");
      out.write("            \r\n");
      out.write("            var texto = getContents();\r\n");
      out.write("            var nome = \"teste\" + count;\r\n");
      out.write("            var proximoNome = \"teste\" + (count+1);\r\n");
      out.write("            console.log(nome);\r\n");
      out.write("            \r\n");
      out.write("            var div = document.getElementById(nome);\r\n");
      out.write("            \r\n");
      out.write("            var divCodigo = '<div class=\"col-md-3 col-sm-6 hero-feature id=' + nome + '\">' +\r\n");
      out.write("                                '<div class=\"thumbnail\">' +\r\n");
      out.write("                                    '<div class=\"caption\">' +\r\n");
      out.write("                                        '<h3>Feature Label</h3>' +\r\n");
      out.write("                                        '<p>'+ texto + '</p>' +\r\n");
      out.write("                                        '<p>' +\r\n");
      out.write("                                            '<a href=\"#\" class=\"btn btn-primary\">Abrir</a>' +\r\n");
      out.write("                                            '<a href=\"#\" onclick=\"apagaDiv(' + nome + ')\" class=\"btn btn-default\">Apagar</a></p>' +\r\n");
      out.write("                                    '</div>' + '</div>' + ' </div>' + \r\n");
      out.write("                                    \r\n");
      out.write("                                    '<div id=\"' + proximoNome + '\"></div>';\r\n");
      out.write("            \r\n");
      out.write("            console.log(\"Código da div: \" + divCodigo);\r\n");
      out.write("            \r\n");
      out.write("            div.innerHTML = divCodigo;\r\n");
      out.write("            \r\n");
      out.write("            removeEditor();\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        function apagaDiv(int) {\r\n");
      out.write("            console.log(\"apagando div: \" + int);\r\n");
      out.write("            \r\n");
      out.write("            var div = document.getElementById(int);\r\n");
      out.write("            \r\n");
      out.write("            div.parentElement.innerHTML = '';\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("     // Seta conteúdo no editor\r\n");
      out.write("        function SetContents() {\r\n");
      out.write("        \t// Get the editor instance that we want to interact with.\r\n");
      out.write("        \tvar editor = CKEDITOR.instances.editor1;\r\n");
      out.write("        \tvar value = document.getElementById( 'htmlArea' ).value;\r\n");
      out.write("\r\n");
      out.write("        \t// Set editor contents (replace current contents).\r\n");
      out.write("        \t// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-setData\r\n");
      out.write("        \teditor.setData( value );\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        var editor, html = '';\r\n");
      out.write("\r\n");
      out.write("        // Exibe o editor\r\n");
      out.write("        function createEditor() {\r\n");
      out.write("            if ( editor )\r\n");
      out.write("                return;\r\n");
      out.write("\r\n");
      out.write("            // Create a new editor inside the <div id=\"editor\">, setting its value to html\r\n");
      out.write("            var config = {};\r\n");
      out.write("            editor = CKEDITOR.appendTo( 'editor', config, html );\r\n");
      out.write("                    \r\n");
      out.write("            // Cria botão salvar abaixo do editor\r\n");
      out.write("            document.getElementById( 'buttonSave' ).innerHTML = '<br><a class=\"btn btn-primary\" onclick=\"adicionaTextoSalvo()\">Salvar!</a>';\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        // Esconde o editor\r\n");
      out.write("        function removeEditor() {\r\n");
      out.write("            if ( !editor )\r\n");
      out.write("                return;\r\n");
      out.write("\r\n");
      out.write("            // Retrieve the editor contents. In an Ajax application, this data would be\r\n");
      out.write("            // sent to the server or used in any other way.\r\n");
      out.write("            document.getElementById( 'editorcontents' ).innerHTML = html = editor.getData();\r\n");
      out.write("            document.getElementById( 'contents' ).style.display = '';\r\n");
      out.write("\r\n");
      out.write("            // Destroy the editor.\r\n");
      out.write("            editor.destroy();\r\n");
      out.write("            editor = null;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        // Alerta\r\n");
      out.write("        function scriptSalva() {\r\n");
      out.write("            alert('Alertou');\r\n");
      out.write("        }\r\n");
      out.write("                \r\n");
      out.write("    </script>\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <!-- Navigation -->\r\n");
      out.write("    <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("            <div class=\"navbar-header\">\r\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\r\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                </button>\r\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">O Editor de Texto</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("                <ul class=\"nav navbar-nav navbar-left\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"http://www.unisinos.br/\">Unisinos</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"http://moodle.unisinos.br/\">Moodle</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"http://github.com/paulograbin/DevWeb\">Código fonte</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                \r\n");
      out.write("                 <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">Logar</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                 </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.navbar-collapse -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.container -->\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <!-- Page Content -->\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Jumbotron Header -->\r\n");
      out.write("        <header class=\"jumbotron hero-spacer\">\r\n");
      out.write("            <h1>Olá!</h1>\r\n");
      out.write("            \r\n");
      out.write("            <p>Seja bem vindo ao O Editor de Texto. O que você deseja fazer agora?</p>\r\n");
      out.write("            <p>\r\n");
      out.write("            \t<a class=\"btn btn-primary btn-large\" onclick=\"createEditor();\">Criar novo texto</a>\r\n");
      out.write("            \t<!-- <a class=\"btn btn-primary btn-large\" onclick=\"getCount();\">Cancelar</a> -->\r\n");
      out.write("            \t<a class=\"btn btn-primary btn-large\" onclick=\"removeEditor();\">Cancelar</a>\r\n");
      out.write("            </p>\r\n");
      out.write("            \r\n");
      out.write("            <!-- This div will hold the editor. -->\r\n");
      out.write("            <div id=\"editor\"></div>\r\n");
      out.write("            <div id=\"contents\" style=\"display: none\">\r\n");
      out.write("                <p> Edited Contents: </p>\r\n");
      out.write("                \r\n");
      out.write("                <!-- This div will be used to display the editor contents. -->\r\n");
      out.write("                <div id=\"editorcontents\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div id=\"buttonSave\"></div>\r\n");
      out.write("            \r\n");
      out.write("        </header>\r\n");
      out.write("\r\n");
      out.write("        <!-- Title -->\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-lg-12\">\r\n");
      out.write("                <h3>Ultimos textos gravados...</h3>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Page Features -->\r\n");
      out.write("        <div class=\"row text-center\">\r\n");
      out.write("            \r\n");
      out.write("            <div id=\"teste1\"></div>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("            <div class=\"col-md-3 col-sm-6 hero-feature\">\r\n");
      out.write("                <div class=\"thumbnail\">\r\n");
      out.write("                    <div class=\"caption\">\r\n");
      out.write("                        <h3>Feature Label</h3>\r\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <a href=\"#\" class=\"btn btn-primary\">Abrir</a> <a href=\"#\" class=\"btn btn-default\">Apagar</a>\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-md-3 col-sm-6 hero-feature\">\r\n");
      out.write("                <div class=\"thumbnail\">\r\n");
      out.write("                    <div class=\"caption\">\r\n");
      out.write("                        <h3>Feature Label</h3>\r\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <a href=\"#\" class=\"btn btn-primary\">Abrir</a> <a href=\"#\" class=\"btn btn-default\">Apagar</a>\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-md-3 col-sm-6 hero-feature\">\r\n");
      out.write("                <div class=\"thumbnail\">\r\n");
      out.write("                    <div class=\"caption\">\r\n");
      out.write("                        <h3>Feature Label</h3>\r\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <a href=\"#\" class=\"btn btn-primary\">Abrir</a> <a href=\"#\" class=\"btn btn-default\">Apagar</a>\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-md-3 col-sm-6 hero-feature\">\r\n");
      out.write("                <div class=\"thumbnail\">\r\n");
      out.write("                    <div class=\"caption\">\r\n");
      out.write("                        <h3>Feature Label</h3>\r\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <a href=\"#\" class=\"btn btn-primary\">Abrir</a> <a href=\"#\" class=\"btn btn-default\">Apagar</a>\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Footer -->        \r\n");
      out.write("        <footer>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-12\">\r\n");
      out.write("                    <p>Desenvolvido por Alexandre, Matheus, Paulo e Thiago. &copy; Editor de Texto 2015</p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.container -->\r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery -->\r\n");
      out.write("    <script src=\"bootstrap/js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\r\n");
      out.write("    <script src=\"bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
    // /index.jsp(27,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /index.jsp(29,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
