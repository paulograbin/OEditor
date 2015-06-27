console.log("Inicializou o global.js");

$(document ).ready(function() {

    populaTabela();
    
    $('#btnSave').on('click', adicionaNota);
});

function populaTabela() {
    console.log("Populando tabela...");

    // Empty content string
        var tableContent = '';
        var cont = 1;
        
        // jQuery AJAX call for JSON
        $.getJSON( '/listnotes', function( data ) {

//           For each item in our JSON, add a table row and cells to the content string
            $.each(data, function(){
                tableContent += '<tr>';
                tableContent += '<td class="col-md1">' + cont + '</td>';
                tableContent += '<td class="col-md9">' + this.text + '</td>';
                tableContent += '<td class="col-md2">' + "TESTE" + '</td>';
                tableContent += '</tr>';
                cont += 1;
            });

            // Inject the whole content string into our existing HTML table
            $('table tbody').html(tableContent);
        });
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

        populaTabela();
    });
}

function editaNota() {
    console.log("Editando nota...");
}

function apagaNota() {
    console.log("Apagando nota...");
}