<!DOCTYPE html>

<%@ page import="com.unisinos.devweb.backend.Gerenciador"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
	
	<%
		Gerenciador g = Gerenciador.getGerenciador();
		g.init(request.getRealPath(""));
	%>
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>O Editor de Texto</title>
	
	<script>
		function Focus() {
		CKEDITOR.instances.editor1.focus();
		}
		
		function onFocus() {
			document.getElementById( 'eMessage' ).innerHTML = '<b>' + this.name + ' is focused </b>';
		}
		
		function onBlur() {
			document.getElementById( 'eMessage' ).innerHTML = this.name + ' lost focus';
		}
	</script>
	
	<script src="js/angular.min.js"></script>
	<script src="js/angular.min.js.map"></script>
	
	<script src="js/angular-sanitize.min.js"></script>
	<script src="js/angular-sanitize.min.js.map"></script>
	
	<!-- CKEditor js -->
	<script src="ckeditor/ckeditor.js"></script>
	
	<!-- Bootstrap Core CSS -->
	<link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" />
	<!-- Custom CSS -->
	<link href="<c:url value="/bootstrap/css/heroic-features.css"/>" rel="stylesheet" />
	
	<script src="js/index.js"></script>
	
	</head>
	<body>
	
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">O Editor de Texto</a>
				</div>
	
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-left">
						<li><a href="http://www.unisinos.br/">Unisinos</a></li>
						<li><a href="http://moodle.unisinos.br/">Moodle</a></li>
						<li><a href="http://github.com/paulograbin/DevWeb">Código fonte</a></li>
					</ul>
	
					<ul class="nav navbar-nav navbar-right">
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container -->
		</nav>
	
		<!-- Page Content -->
		<div class="container" ng-app="EditorTexto" ng-controller="EditorTextoCtrl">
			<!-- Jumbotron Header -->
			<header class="jumbotron hero-spacer">
				<h1>Olá, digite seu texto abaixo:</h1>
				
				<!-- <p>Seja bem vindo ao O Editor de Texto. O que você deseja fazer	agora?</p> -->
				<textarea cols="100" id="editor1" name="editor1" rows="10">&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using &lt;a href="http://ckeditor.com/"&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;</textarea>

		<script>
			// Replace the <textarea id="editor1"> with an CKEditor instance.
			CKEDITOR.replace( 'editor1', {
				on: {
					focus: onFocus,
					blur: onBlur,

					// Check for availability of corresponding plugins.
					pluginsLoaded: function( evt ) {
						var doc = CKEDITOR.document, ed = evt.editor;
						if ( !ed.getCommand( 'bold' ) )
							doc.getById( 'exec-bold' ).hide();
						if ( !ed.getCommand( 'link' ) )
							doc.getById( 'exec-link' ).hide();
					}
				}
			});
		</script>
				<p>
					<a class="btn btn-primary btn-large" ng-click="adicionarTextoSalvo()">Salvar!</a>
				</p>
	
				<!-- This div will hold the editor. -->
				<div id="editor"></div>
				<div id="contents" style="display: none">
					<p>Edited Contents:</p>
	
					<!-- This div will be used to display the editor contents. -->
					<div id="editorcontents"></div>
				</div>
	
				<div ng-if="botaoSalvarHabilitado">
					<br/>
				 </div>
	
			</header>
	
			<!-- Title -->
			<div class="row">
				<div class="col-lg-12">
					<h3>Ultimos textos gravados...</h3>
				</div>
			</div>
			<!-- /.row -->
	
			<!-- Page Features -->
			<div class="row text-center">
				<div ng-repeat="entidade in listaTextos">
					<div class="col-md-3 col-sm-6 hero-feature id={{entidade.nome}}">
						<div class="thumbnail">
							<div class="caption">
								<h3>{{entidade.nome}}</h3>
								<p ng-bind-html="entidade.conteudo"></p>
								<p>
									<a href="#" class="btn btn-primary" ng-click="abrirTexto($index)">Abrir</a>
									<a href="#" class="btn btn-default" ng-click="apagarTexto($index)">Apagar</a>
								</p>
							</div>
						</div>
					 </div>	
				</div>
			</div>
			<!-- /.row -->
	
			<!-- Footer -->
			<footer>
				<div class="row">
					<div class="col-lg-12">
						<p>Desenvolvido por Alexandre, Matheus, Paulo e Thiago. &copy; Editor de Texto 2015</p>
					</div>
				</div>
			</footer>
	
		</div>
		<!-- /.container -->
	
		<!-- jQuery -->
		<script src="bootstrap/js/jquery.js"></script>
	
		<!-- Bootstrap Core JavaScript -->
		<script src="bootstrap/js/bootstrap.min.js"></script>
		
		<p id="eMessage" style="visibility: hidden;">
		</p>	
	</body>
</html>