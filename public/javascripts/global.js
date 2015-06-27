console.log("Inicializou o global.js");

$(document ).ready(function() {

	$('#btnSave').on('click', adicionaNota);
});

function populaTabela() {
    console.log("Populando tabela...");

}

function adicionaNota() {
    console.log("Adicionando nova nota...");

    // If it is, compile all user info into one object
    var note = {
        'text': $("#editor1").val()
    }

    // Use AJAX to post the object to our adduser service
    $.ajax({
        type: 'POST',
        data: note,
        url: '/addnote',
        dataType: 'JSON'
    }).done(function( response ) {
        if (response.msg === '') {
            alert("Registro inserido com sucesso!");    
        }
    });
}

function editaNota() {
    console.log("Editando nota...");

}

function apagaNota() {
    console.log("Apagando nota...");

}