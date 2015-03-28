<!DOCTYPE html>

<%@page import="java.io.File"%>
<%@ page import="com.unisinos.devweb.backend.Gerenciador"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>

    <%
    	Gerenciador g = Gerenciador.getService();
        g.init(request.getRealPath(""));
    %>

</head>
<body>

	<p>Listando arquivos no output do servidor...</p>
	
	<% 
		System.out.println("Pasta contem: " + g.getFileCount() + " arquivos...");
	
		if (g.getFileCount() > 0) {
			File[] files = g.getFiles();
			
			for(File f : files) {
				System.out.println(g.getConteudo(f.getAbsolutePath()));
			}
		}
	%>

</body>