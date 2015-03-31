var count = 0;

// Retorna o conteúdo do editor
function getContents() {
	// Get the editor instance that you want to interact with.
	var editor = CKEDITOR.instances.editor1;

	// Get editor contents
	// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-getData

	return editor.getData();
}

// Adiciona div contendo o texto salvo
function adicionaTextoSalvo() {
	count = count + 1;
	console.log("adicionando texto na div " + count);

	var texto = getContents();
	var nome = "teste" + count;
	var proximoNome = "teste" + (count + 1);
	console.log(nome);

	var div = document.getElementById(nome);

	var divCodigo = '<div class="col-md-3 col-sm-6 hero-feature id=' + nome + '">' + 
						'<div class="thumbnail">' + '<div class="caption">'
							+ '<h3>Feature Label</h3>' + '<p>' + texto + '</p>' + '<p>'
								+ '<a href="#" class="btn btn-primary">Abrir</a>'
								+ '<a href="#" onclick="apagaDiv(' + nome
							+ ')" class="btn btn-default">Apagar</a></p>' + '</div>' + '</div>'
							+ ' </div>' +

							'<div id="' + proximoNome + '"></div>';

	console.log("Código da div: " + divCodigo);

	div.innerHTML = divCodigo;

	removeEditor();
}

function apagaDiv(int) {
	console.log("apagando div: " + int);

	var div = document.getElementById(int);

	div.parentElement.innerHTML = '';
}

// Seta conteúdo no editor
function SetContents() {
	// Get the editor instance that we want to interact with.
	var editor = CKEDITOR.instances.editor1;
	var value = document.getElementById('htmlArea').value;

	// Set editor contents (replace current contents).
	// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-setData
	editor.setData(value);
}

var editor, html = '';

// Exibe o editor
function createEditor() {
	if (editor)
		return;

	// Create a new editor inside the <div id="editor">, setting its value to
	// html
	var config = {};
	editor = CKEDITOR.appendTo('editor', config, html);

	// Cria botão salvar abaixo do editor
	document.getElementById('buttonSave').innerHTML = '<br><a class="btn btn-primary" onclick="adicionaTextoSalvo()">Salvar!</a>';
}

// Esconde o editor
function removeEditor() {
	if (!editor)
		return;

	// Retrieve the editor contents. In an Ajax application, this data would be
	// sent to the server or used in any other way.
	document.getElementById('editorcontents').innerHTML = html = editor
			.getData();
	document.getElementById('contents').style.display = '';

	// Destroy the editor.
	editor.destroy();
	editor = null;
}

// Alerta
function scriptSalva() {
	alert('Alertou');
}