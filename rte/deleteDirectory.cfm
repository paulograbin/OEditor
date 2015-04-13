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

<CFDIRECTORY ACTION="Delete"
    DIRECTORY="#Trim(session.ds_path)##Trim(session.ds_path_atual)#">

<cfset Variables.id = 1>
<cfset Variables.id = #find("\",session.ds_path_atual,Variables.id)#>
<cfset Variables.newURL = #mid(session.ds_path_atual,1, Variables.id)#>
<cfloop condition="Val(Variables.id) GT 0">
	<cfset Variables.id = Variables.id + 1>
	<cfset Variables.id = #find("\",session.ds_path_atual,Variables.id)#>
	<cfif (#Variables.id# EQ #len(session.ds_path_atual)#) OR #Variables.id# EQ 0>
		<cfset Variales.id = 0>
	<cfelse>
		<cfset Variables.newURL = #mid(session.ds_path_atual,1, Variables.id)#>
	</cfif>
</cfloop>


<cfset session.ds_path_atual = Variables.newURL>

<script>
	location = 'listaImagens.cfm'	
</script>

</div>
</body>
</html>
