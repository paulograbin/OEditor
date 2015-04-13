<cfmodule template="../../Includes/CriNetHeaderAreaRestrita.cfm" bodyBGColor="##FCFCFC">

<style>
body{	background-image           :  url(file:///F|/Projetos/Aplicativos/Museu/Integra/HTDOCS/AreaRestrita/Includes/rte/Img/Logo.gif);
		background-attachment      : fixed;
		background-repeat          : no-repeat;
		background-position        : 50% 50%;
		scrollbar-face-color       : #FFFFFF;
	    scrollbar-highlight-color  : #CCCCCC;
	    scrollbar-shadow-color     : #CCCCCC;
	    scrollbar-3dlight-color    : #FFFFFF;
	    scrollbar-arrow-color      : #CCCCCC;
	    scrollbar-track-color      : #FFFFFF;
	    scrollbar-darkshadow-color : #CCCCCC;
}
.title{ font-family : Arial;
	    font-weight : bold;
	    font-size   : 15px;
		color   : yellow;
	    bolor       : black;
		background-color: #172c7b;
}
.title2{ font-family : Arial;
	    font-weight : bold;
	    font-size   : 10px;
		color   : yellow;
	    bolor       : black;
		background-color: #172c7b;
}
.titleCol{	font-family : Arial;
		    font-weight : bold;
		    font-size   : 12px;
			color   	: navy;
		    bolor       : black;
			border-bottom : solid 1px navy;

}
.item{		font-family : Arial;
		    font-size   : 12px;
			color   	: #3a3a3a;
		    bolor       : black;
			border-bottom : solid 1px silver;

}

.subtitle{ font-family : Arial;
	       font-weight : bold;
	       font-size   : 11px;
	       color       : black;
}
</style>

<cfset myfile=#Trim(URL.ds)#>
<cfheader name="content-disposition" value="attachment;filename=#Trim(URL.name)#">
<cfcontent type="unknown" file="#myfile#" deleteFile="no">



<script>
	location = 'listaImagens.cfm';
</script>

</div>
</body>
</html>
