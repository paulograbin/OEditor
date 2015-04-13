<cfmodule template="../../Includes/CriNetHeaderAreaRestrita.cfm" bodyBGColor="##FCFCFC">
<cfif Find('..', URL.ds) GT 0>
	NÃO PODE (..)!!
	<cfabort>
</cfif>
<cfset session.ds_path_atual = Trim(session.ds_path_atual) & ds & "\">

<script>
	location = 'listaImagens.cfm';
</script>

</body>
</html>    
