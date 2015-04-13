<cfmodule template="../../Includes/CriNetHeaderAreaRestrita.cfm" bodyBGColor="##FCFCFC">

<style>
body{	background-image           :  url(Img/Logo.gif);
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

<CFFILE ACTION="Delete"
    FILE="#Trim(session.ds_path)##Trim(session.ds_path_atual)##Trim(URL.ds)#">


<script>
	location = 'listaImagens.cfm';
</script>

</div>
</body>
</html>
