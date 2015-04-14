var app = angular.module('EditorTexto', ['ngSanitize']);
app.controller('EditorTextoCtrl', function($scope) {
	var count = 0;
	var editor, html = '';
	$scope.botaoSalvarHabilitado = false;
	
	var getConteudo = function () {
		// Get editor contents
        var editor = CKEDITOR.instances.editor1;
        console.log("Texto retornado: " + editor.getData());
        
		return editor.getData();
	};
	
	$scope.listaTextos = [];
	$scope.adicionarTextoSalvo = function () {
		count = count + 1;
        console.log("Função: adicionarTextoSalvo no index " + count);
		
		var texto = {};
		texto.conteudo = getConteudo();
		texto.nome = "teste" + count;

		$scope.listaTextos.push(texto);
        
        // Limpa conteudos do editor
        clearContents();
	};
	
	$scope.abrirTexto = function (index) {
        console.log("Função: abrirTexto, index: " + index+1);
		var textValue = $scope.listaTextos[index];
		setContents(textValue);
	};
	
	$scope.apagarTexto = function (index) {
		$scope.listaTextos.splice(index, 1);
	};
    
    function clearContents() {
        console.log("Função: clearContents");
        setContents("");
    }
	
	// Seta conteúdo no editor
	function setContents(text) {
        console.log("Função: setContents");
        console.log("Texto settado: " + text);
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.editor1;

		// Set editor contents (replace current contents).
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-setData
		editor.setData(text);
	}
});
