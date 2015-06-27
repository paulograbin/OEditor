console.log("Inicializou o global.js");

var textoPadraoEditor = null;
var id = null;

$(document).ready(function() {
    textoPadraoEditor = CKEDITOR.instances.editor1.getData();
    populaTabela();

    // Salva nota click
    $('#btnSave').on('click', adicionarOuEditarNota);

    // Deleta nota click
    $('table tbody').on('click', 'td a.linkdeleteuser', apagaNota);

    // Abre nota lick
    $('table tbody').on('click', 'td a.linkshowuser', abreNota);
});

function populaTabela() {
    console.log("Populando tabela...");

    // Empty content string
    var tableContent = '';
    var cont = 1;

    // jQuery AJAX call for JSON
    $.getJSON( '/listnotes', function(data) {

      // For each item in our JSON, add a table row and cells to the content string
      $.each(data, function() {
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
}

function limparConteudo() {
    CKEDITOR.instances.editor1.setData(textoPadraoEditor);
    id = null;
    $("#btnSave").val('Salvar nova nota');
}

function adicionaNota() {
    console.log("Adicionando nova nota...");

    var errorCount = 0;
    var text = CKEDITOR.instances.editor1.getData();

    if(text.length == 0) {
      errorCount++;
    }

    if(errorCount === 0) {
      var datetime = new Date();

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
              // alert("Registro inserido com sucesso!");
          }
          limparConteudo();
          populaTabela();
     });
  } else {
    alert("Ops, faltou preencher o campo de texto!");
  }
}
function editarNota(id) {
    console.log("Editando nota id " + id);

    var errorCount = 0;
    var text = CKEDITOR.instances.editor1.getData();

    // Verifica se a caixa de texto está vazia
    if(text.length == 0) {
      errorCount++;
    }

    if(errorCount === 0) {
     // If it is, compile all user info into one object
     var note = {
        //  'datetime': datetime.toLocaleString(),
         'text': CKEDITOR.instances.editor1.getData(),
     }

     console.log("id: " + id);
     console.log("text: " + note.text);

     // Use AJAX to post the object to our adduser service
     $.ajax({
         type: 'PUT',
         data: note,
         url: '/editnote/' + id,
     }).done(function(response) {

         // Check for a sucessful (blank) response
         if (response.msg === '') {
             // alert("Registro excluido");
         } else {
            //  alert('Error: ' + response.msg);
             console.log(response.msg);
         }

         // Update table
         limparConteudo();
         populaTabela();
     });
   } else {
     alert("Ops, faltou preencher o campo de texto!");
   }
}

function adicionarOuEditarNota () {
    if(id) {
      editarNota(id);
    } else{
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
