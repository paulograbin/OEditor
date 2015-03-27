<!DOCTYPE html>

<%@ page import="org.springframework.samples.service.service.FileManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>O Editor de Texto...</title>

    <!-- CKEditor js -->
    <script src="ckeditor/ckeditor.js"></script>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" />
    <!-- Custom CSS -->
    <link href="<c:url value="/bootstrap/css/heroic-features.css"/>" rel="stylesheet" />
    
</head>
<body>
    
    <%
        	FileManager s = FileManager.getService();
            s.init(request.getRealPath(""));
    %>
    
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">O Editor de Texto</a>
            </div>
            
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-left">
                    <li>
                        <a href="http://www.unisinos.br/">Unisinos</a>
                    </li>
                    <li>
                        <a href="http://moodle.unisinos.br/">Moodle</a>
                    </li>
                    <li>
                        <a href="http://github.com/paulograbin/DevWeb">Código fonte</a>
                    </li>
                </ul>
                
                 <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#">Logar</a>
                    </li>
                 </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <!-- Jumbotron Header -->
        <header class="jumbotron hero-spacer">
            <h1>Olá!</h1>
            <p>Seja bem vindo ao O Editor de Texto. O que você deseja fazer agora?</p>
            <p>
            	<a class="btn btn-primary btn-large" onclick="createEditor();">Criar novo texto</a>
            	<a class="btn btn-primary btn-large" onclick="removeEditor();">Cancelar</a>
            </p>
            
            <!-- This div will hold the editor. -->
            <div id="editor"></div>
            <div id="contents" style="display: none">
                <p>
                    Edited Contents:
                </p>
                <!-- This div will be used to display the editor contents. -->
                <div id="editorcontents">
                </div>
            </div>
            
            <script>

                var editor, html = '';

                function createEditor() {
                    if ( editor )
                        return;

                    // Create a new editor inside the <div id="editor">, setting its value to html
                    var config = {};
                    editor = CKEDITOR.appendTo( 'editor', config, html );
                }

                function removeEditor() {
                    if ( !editor )
                        return;

                    // Retrieve the editor contents. In an Ajax application, this data would be
                    // sent to the server or used in any other way.
                    document.getElementById( 'editorcontents' ).innerHTML = html = editor.getData();
                    document.getElementById( 'contents' ).style.display = '';

                    // Destroy the editor.
                    editor.destroy();
                    editor = null;
                }

            </script>
        </header>

        <hr>
        
       
        <!-- <script type="text/javascript">
            function scriptSalva() {
                alert('Alertou');
        }
        </script>
            
        <script>
            // Test for checking if local storage is available.
            if(typeof(Storage) !== "undefined") {
                // Code for localStorage/sessionStorage.
                 alert('Browser suporta localStorage.');
            } else {
                // Sorry! No Web Storage support..
                 alert('Browser NÃO suporta localStorage.');
            }
        </script> -->
        
        <!-- Title -->
        <div class="row">
            <div class="col-lg-12">
                <h3>Ultimos textos gravados...</h3>
            </div>
        </div>
        <!-- /.row -->

        <!-- Page Features -->
        <div class="row text-center">

            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Feature Label</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                        <p>
                            <a href="#" class="btn btn-primary">Abrir</a> <a href="#" class="btn btn-default">Apagar</a>
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Feature Label</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                        <p>
                            <a href="#" class="btn btn-primary">Abrir</a> <a href="#" class="btn btn-default">Apagar</a>
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Feature Label</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                        <p>
                            <a href="#" class="btn btn-primary">Abrir</a> <a href="#" class="btn btn-default">Apagar</a>
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Feature Label</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                        <p>
                            <a href="#" class="btn btn-primary">Abrir</a> <a href="#" class="btn btn-default">Apagar</a>
                        </p>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.row -->

        <!-- Footer -->        
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Desenvolvido por Alexandre, Matheus, Paulo e Thiago. &copy; Your Website 2014</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="bootstrap/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>