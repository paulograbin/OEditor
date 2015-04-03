var app = angular.module('EditorTexto', ['ngSanitize']);
app.controller('EditorTextoCtrl', function($scope) {
	var count = 0;
	var editor, html = '';
	$scope.botaoSalvarHabilitado = false;
	
	var getConteudo = function () {
		if(!editor) return;
		// Get editor contents
		return editor.getData();
	};
	
	$scope.listaTextos = [];
	$scope.adicionarTextoSalvo = function () {
		count = count + 1;
		
		var texto = {};
		texto.conteudo = getConteudo();
		texto.nome = "teste" + count;
		$scope.listaTextos.push(texto);
		$scope.removerEditor();
	};
	
	// Exibe o editor
	$scope.criarEditor = function () {
		if (editor)	return;

		// Create a new editor inside the <div id="editor">, setting its value to html
		var config = {};
		editor = CKEDITOR.appendTo('editor', config, html);
		$scope.botaoSalvarHabilitado = true;
	};
	
	$scope.removerEditor = function () {
		if (!editor)
			return;
		
		document.getElementById('editorcontents').innerHTML = html = editor.getData();
		document.getElementById('contents').style.display = '';

		// Destroy the editor.
		editor.destroy(true);
		editor = null;
		$scope.botaoSalvarHabilitado = false;
	};
	
	$scope.apagarTexto = function (index) {
		$scope.listaTextos.splice(index, 1);
	};
	
	// Seta conteúdo no editor
	function SetContents() {
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.editor1;
		var value = document.getElementById('htmlArea').value;

		// Set editor contents (replace current contents).
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-setData
		editor.setData(value);
	}

});
