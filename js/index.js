var app = angular.module('EditorTexto', ['ngSanitize']);
app.controller('EditorTextoCtrl', function($scope) {
	var count = 0;
	var editor, html = '';
	$scope.indiceTextoEdicao = null;
	$scope.textoBotaoSalvar = 'Salvar Novo Texto';
    
    // Função que retorna o conteudo atual do editor
	var getConteudo = function () {
		// Get editor contents
        var editor = CKEDITOR.instances.editor1;        
		return editor.getData();
	};
	
	$scope.listaTextos = [];
 
  	var salvarOuEditarTexto = function () {
  		var texto = null;
		//Se estiver diferente de nulo, significa que é uma edição
		if ($scope.indiceTextoEdicao) {
			texto = $scope.listaTextos[$scope.indiceTextoEdicao];
			texto.conteudo = getConteudo();
			console.log("Função: adicionarTextoSalvo no index " + $scope.indiceTextoEdicao);
	
		//Se for nulo significa que é um novo texto		
		}else{
			texto = {};
			count = count + 1;
			texto.nome = "Texto " + count;
			texto.conteudo = getConteudo();
			$scope.listaTextos.push(texto);
			console.log("Função: adicionarTextoSalvo no index " + count);	
		}    
  	}

    // Função que salva um novo texto
	$scope.adicionarTextoSalvo = function () {
		
		 // Testa se o conteudo do editor não é vazio
        if(getConteudo().length == 0) {    
            alert("Por favor, digite alguma coisa no Editor.");
            return;
        }

		salvarOuEditarTexto();
        console.log("Tamanho da string de texto contida no editor: " + getConteudo().length);
   
        // Limpa conteudos do editor
        clearContents();
	};

	$scope.cancelarTexto = function () {
        clearContents();
	}

	$scope.abrirTexto = function (index) {
        console.log("Função: abrirTexto, index: " + index+1);
		var texto = $scope.listaTextos[index];
		if(texto){
			setContents(texto.conteudo);
			$scope.indiceTextoEdicao = index;
			$scope.textoBotaoSalvar = 'Salvar ' + texto.nome;	
		}	

	};
	
	$scope.apagarTexto = function (index) {
		$scope.listaTextos.splice(index, 1);
		clearContents();
	};
    
    // Função que limpa conteudo do editor
    function clearContents() {
        console.log("Função: clearContents");
        
        // Chama a função que seta o texto passando parametro vazio
        setContents("");
        $scope.indiceTextoEdicao = null;
       	$scope.textoBotaoSalvar = 'Salvar Novo Texto';
    }
	
	// Função que seta conteúdo no editor
	function setContents(text) {
        console.log("Função: setContents, setando texto: " + text);
        
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.editor1;

		// Set editor contents (replace current contents).
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-setData
		editor.setData(text);
	}
});
