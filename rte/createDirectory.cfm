<cfmodule template="../../Includes/CriNetHeaderAreaRestrita.cfm" bodyBGColor="##FCFCFC">

<style>
body{	background-image           :  url(../Img/Logo.gif);
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

<cfif #ParameterExists(Form.upload_now)#>
	<CFDIRECTORY ACTION="Create"
			    DIRECTORY="#Trim(session.ds_path)##Trim(session.ds_path_atual)##Form.ul_path#"
			    NEWDIRECTORY="#Form.ul_path#">
	<script>
		opener.location = opener.location;
		this.close();
	</script>
	<cfabort>
</cfif>
<cfoutput>
<body bgcolor="##FFFFFF" bottommargin="0" leftmargin="0" topmargin="0" rightmargin="0">
<div align="center">
<table border="0" cellpadding="1" cellspacing="0" width="100%" height="100%">
	<form method="post" name="upload_form" enctype="multipart/form-data" id="upload_form"> 	
	<tr>
		<td class="title2" align="left" valign="c"><img src="/img/folderOpened.gif">&nbsp;&nbsp;#Trim(session.ds_path_atual)#</td>
		<td class="title2" align="right">Criar Pasta</td>
	</tr>
	<tr>
		<td height="100%" valign="center" colspan="100%">
			<input type="Text" name="ul_path" id="ul_path">
		</td>
	</tr>
	<tr>
		<td align="center" class="title" colspan="2"><input type="submit" name="upload_now" value="Criar"></td>
	</tr>
	</form>
</table>
</div>
</body>
</html>
</cfoutput>