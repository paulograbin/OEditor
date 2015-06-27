console.log("Inicializou o global.js");

var textoPadraoEditor = null;
var id = null;

$(document ).ready(function() {
    textoPadraoEditor =  CKEDITOR.instances.editor1.getData();
    populaTabela();

    $('#btnSave').on('click', adicionarOuEditarNota);

    // Delete Note link click
    $('table tbody').on('click', 'td a.linkdeleteuser', apagaNota);
    $('table tbody').on('click', 'td a.linkshowuser', abreNota);

});

function populaTabela() {
    console.log("Populando tabela...");

    // Empty content string
    var tableContent = '';
    var cont = 1;

    // jQuery AJAX call for JSON
    $.getJSON( '/listnotes', function( data ) {

      // For each item in our JSON, add a table row and cells to the content string
      $.each(data, function(){
        tableContent += '<tr>';
        tableContent += '<td>' + cont + '</td>';
        tableContent += '<td id="note'+ cont +'">' + this.text + '</td>';
        tableContent += '<td>' + this.datetime + '</td>';
        tableContent += '<td><a href="#" class="linkshowuser btn btn-success btn-large" num="' + cont + '" rel="' + this._id + '">Editar</a><a href="#" class="linkdeleteuser btn btn-danger btn-large" rel="' + this._id + '">Deletar</a></td>';
        tableContent += '</tr>';

        cont += 1;
      });

      // Inject the whole content string into our existing HTML table
      $('table tbody').html(tableContent);
    });

  console.log("Populada!");
}

function limparConteudo(){
    CKEDITOR.instances.editor1.setData(textoPadraoEditor);
    id = null;
    $("#btnSave").val('Salvar nova nota');
}

function adicionaNota() {
    console.log("Adicionando nova nota...");

    var datetime = new Date();
    console.log(datetime);

    // If it is, compile all user info into one object
    var note = {
        'datetime': datetime.toLocaleString(),
        'text':  CKEDITOR.instances.editor1.getData()
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
        limparConteudo();
        populaTabela();
    });
}
function editarNota(id) {
    //Chama requsicao para alteracao da nota
    //NO DONE chamar a seguinte funcao
   limparConteudo();
}

function adicionarOuEditarNota () {
    console.log("Decidindo se abrimos ou editamos a nota...");

    if(id) {
      console.log("Editando...");
      editarNota(id);
    } else{
        console.log("Adicionando...");
        adicionaNota();
    }
}

function abreNota() {
    console.log("Editando note " + $(this).attr('rel'));
    id = $(this).attr('rel');

    var textoNotaEdicao = $("#note"+ $(this).attr('num')).html();
    CKEDITOR.instances.editor1.setData(textoNotaEdicao);

    $("#btnSave").val('Salvar nota ' + $(this).attr('num'));
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
                // alert("Registro excluido");
            } else {
                alert('Error: ' + response.msg);
            }

            // Update table
            populaTabela();
        });
}
