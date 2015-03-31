<cfmodule template="../../Includes/CriNetHeaderAreaRestrita.cfm" bodyBGColor="##FCFCFC">
<cfoutput>
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
</cfoutput>
<script>
	location = 'listaImagens.cfm';
</script>


</body>
</html>    
