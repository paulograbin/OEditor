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
	    font-size   : 20px;
		color   : yellow;
	    bolor       : black;
		background-color: #172c7b;
}
.title2{font-family : Arial;
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


<script>
	function abreDiretorio(ds){
		location = 'setDirectory.cfm?ds='+ds;
	}
	function setImg(img){
		opener.addImage_f4w(img);
		close();
	}
	function deleteArquivo(ds){
		location = 'deleteFile.cfm?ds='+ds;
	}
	function downloadArquivo(ds,name){
		return window.open('downloadArquivo.cfm?ds='+ds+'&name='+name,'winUpGS',"height=120,width=300,status=0,scrollbars=1,resizable=1,screenX=0,screenY=0,left=0,top=0");
	}
	
	function criarPasta(){
		return window.open('createDirectory.cfm','winUpGS',"height=120,width=300,status=0,scrollbars=1,resizable=1,screenX=0,screenY=0,left=0,top=0");
	}
	function voltaPasta(){
		location = 'upDirectory.cfm';
	}
	function upload(){
		return window.open('upload.cfm','winUpGS',"height=120,width=300,status=0,scrollbars=1,resizable=1,screenX=0,screenY=0,left=0,top=0");
	}
</script>

<cfif Find('..', session.ds_path_atual) GT 0>
	NÃO PODE (..)!!
	<cfabort>
</cfif>

<cfloop list="#session.list_cnpj#" index="Variables.cnpj">
    <cfmodule template="../../Includes/ajustaVariaveis.cfm" cnpj="#Variables.cnpj#">
</cfloop>

<cfdirectory directory = "#Trim(Variables.ds_path)##Trim(session.ds_path_atual)#"
			 name      = "myDirectory"
			 sort      = "type ASC, name ASC, size DESC">

<cfoutput>
<body bgcolor="##FFFFFF" bottommargin="0" leftmargin="0" topmargin="0" rightmargin="0">
<div align="center">
<table border="0" cellpadding="1" cellspacing="0" width="95%" height="100%">
	<tr>
		<td height="100%" valign="top">
			<table border="0" cellpadding="2" cellspacing="0" width="100%">
				<tr>
					<td class="grupoTitle" bgcolor="" colspan="100%">&nbsp;<img src="/img/pastaUp.gif" onClick="voltaPasta();" style="cursor:hand;" title="Voltar">&nbsp;
						<img src="/img/uploadfile.gif" onClick="upload(this);" style="cursor:hand;" title="Upload">&nbsp;
						<!--- <img src="/img/novaPasta.gif" onClick="criarPasta(this);" style="cursor:hand;" title="Criar Pasta">&nbsp; --->
						<img src="/img/refresh2.gif" onClick="location=location;" style="cursor:hand;" title="Refresh">
						<cfif #session.ds_path_atual# NEQ '\'>
							<!--- <img src="/img/excluirArquivo.gif" onClick="location='deleteDirectory.cfm';" style="cursor:hand;" title="Exclui Pasta"> --->
						</cfif>
						<br>
						&nbsp;<img src="/img/folderOpened.gif">&nbsp;#session.ds_path_atual#
					</td>
				</tr>
				<tr>
					<td class="titleCol">
						Nome
					</td>
					<td class="titleCol" align="right" nowrap>
						Tamanho&nbsp;&nbsp;
					</td>
					<td class="titleCol">
						Modificado
					</td>
				</tr>
				<cfloop query = "myDirectory">
					<cfif #Name# NEQ "." and #Name# NEQ "..">
						<cfif #type# EQ "Dir">
                            <tr onClick="TrocaCorObjeto(this)">
                        <cfelse>
                            <tr onClick="TrocaCorObjeto(this)" onDblClick="setImg('/Img/#Trim(session.ds_path_atual)#/#Name#')">
                        </cfif>
                            <td class="item" valign="middle">
                                <cfif #type# EQ "Dir">
                                    <img src="/img/folderClosed.gif" style="cursor:hand;">
                                    <font onclick="abreDiretorio('#Name#')" style="text-decoration:underline;cursor:hand">#Name#</font>
                                <cfelse>
                                    <!--- <img src="/img/excluirArquivo.gif" onClick="deleteArquivo('#Name#')" style="cursor:hand;" title="Excluir"> --->
                                    <font onclick="downloadArquivo('#replace(Variables.ds_path,'\','/','all')#/#replace(session.ds_path_atual,'\','/','all')#/#Name#','#Name#')" style="text-decoration:underline;cursor:hand">#Name#</font>
                                </cfif>
                            </td>
                            <td align="right" class="item" nowrap>
                                #NumberFormat(Val(Size/1024), "9999999999")#&nbsp;KB&nbsp;&nbsp;
                            </td>
                            <td class="item">
                                #DateFormat(dateLastModified,session.ds_marcara_data_usuario)#
                            </td>
                        </tr>
					</cfif>
				</cfloop>
			</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>    
<script>
	this.focus();
</script>
</cfoutput>