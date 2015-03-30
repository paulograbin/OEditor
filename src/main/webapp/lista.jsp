<!DOCTYPE html>

<%@page import="com.unisinos.devweb.backend.Texto"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.unisinos.devweb.backend.Gerenciador"%>
<%@ page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%-- <jsp:useBean id="g" class="com.unisinos.devweb.backend.Gerenciador" /> --%>

<html>
<head>

	<%
    	Gerenciador g = Gerenciador.getGerenciador();
        g.init(request.getRealPath(""));
    %>

</head>
<body>

	<p>Listando arquivos no output do servidor...</p>
	
	<% ArrayList<Texto> textos = g.getTextos(); 
	   
		for(Texto t : textos) {
			out.println(t);
		}
	%>
	
	
	
	<%-- <c:forEach var="file" items="${g.get }">
	</c:forEach> --%>
	
	<%-- <% 
		System.out.println("Pasta contem: " + g.getFileCount() + " arquivos...");
	
		if (g.getFileCount() > 0) {
			File[] files = g.getFiles();
			
			for(File f : files) {
				System.out.println(g.getConteudo(f.getAbsolutePath()));
			}
		}
	%> --%>

</body>