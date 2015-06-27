console.log("Inicializou o global.js");

$(document ).ready(function() {

    populaTabela();
    
    $('#btnSave').on('click', adicionaNota);

    // Delete Note link click
    $('table tbody').on('click', 'td a.linkdeleteuser', apagaNota);
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
            tableContent += '<td>' + cont + '</td>';
            tableContent += '<td>' + this.text + '</td>';
            tableContent += '<td>' + this.datetime + '</td>';
            tableContent += '<td><a href="#" class="linkshowuser btn btn-success btn-large" rel="' + this._id + '">Editar</a><a href="#" class="linkdeleteuser btn btn-danger btn-large" rel="' + this._id + '">Deletar</a></td>';
            tableContent += '</tr>';

                cont += 1;
            });

            // Inject the whole content string into our existing HTML table
            $('table tbody').html(tableContent);
        });
}

function adicionaNota() {
    console.log("Adicionando nova nota...");

    var datetime = new Date();

    // If it is, compile all user info into one object
    var note = {
        'datetime': datetime.toLocaleString(),
        'text': $("#editor1").val(),
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
    console.log("Deletando note " + $(this).attr('rel'));

    event.preventDefault();

        // If they did, do our delete
        $.ajax({
            type: 'DELETE',
            url: '/deletenote/' + $(this).attr('rel')
        }).done(function( response ) {

            // Check for a sucessful (blank) response
            if (response.msg === '') {
                alert("Registro excluido");
            } else {
                alert('Error: ' + response.msg);
            }

            // Update table
            populaTabela();
        });
}