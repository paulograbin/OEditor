console.log("Inicializou o global.js");

var textoPadraoEditor = null;
var id = null;

$(document).ready(function() {
    textoPadraoEditor = CKEDITOR.instances.editor1.getData();
    populaTabela();

    // Salva nota no evento click
    $('#btnSave').on('click', adicionarOuEditarNota);

    // Deleta nota no evento click
    $('table tbody').on('click', 'td a.linkdeleteuser', apagaNota);

    // Abre nota no evento click
    $('table tbody').on('click', 'td a.linkshowuser', abreNota);
});

function populaTabela() {
    console.log("Populando tabela...");

    // String de conteudo vazia
    var tableContent = '';
    var cont = 1;

    // Requisição GET via AJAX pra pegar todas as notas do banco
    $.getJSON( '/notes', function(data) {

      // Para cada item no JSON uma nova linha na tabela é adiciona com o conteudo
      $.each(data, function() {
        tableContent += '<tr>';
        tableContent += '<td>' + cont + '</td>';
        tableContent += '<td id="note'+ cont +'">' + this.text + '</td>';
        tableContent += '<td>' + this.datetime + '</td>';
        tableContent += '<td><a href="#" class="linkshowuser btn btn-success btn-large" num="' + cont + '" rel="' + this._id + '">Editar</a><a href="#" class="linkdeleteuser btn btn-danger btn-large" rel="' + this._id + '">Deletar</a></td>';
        tableContent += '</tr>';

        cont += 1;
      });

      // Injeta toda a variavel na tabela HTML existente no layout
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

    // Verifica se caixa de texto está vazia
    if(text.length == 0) {
      errorCount++;
    }

    // Se nenhum erro foi encontrado
    if(errorCount === 0) {
      var datetime = new Date();

      // Se algum conteudo foi digitado, cria uma nota...
      var note = {
          'datetime': datetime.toLocaleString(),
          'text':  CKEDITOR.instances.editor1.getData(),
          'deleted': 0,
      }

      // Requisição POST via AJAX pra postar a nota pro banco
      $.ajax({
          type: 'POST',
          data: note,
          url: '/addnote',
          dataType: 'JSON'
      }).done(function( response ) {
          if (response.msg === '') {
              alert("Registro inserido com sucesso!");
          } else {
            alert("Ops, algum problema ocorreu: " + response.msg);
          }

          // Atualiza tabela e coloca o conteudo padrão no editor de texto
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

    // Se nenhum erro foi encontrado
    if(errorCount === 0) {
      var note = {
        'text': CKEDITOR.instances.editor1.getData(),
      }

      // Requisição PUT via AJAX pra atualizar a nota no banco
      $.ajax({
         type: 'PUT',
         data: note,
         url: '/editnote/' + id,
      }).done(function(response) {

         if (response.msg === '') {
             alert("Registro alterado com sucesso!");
         } else {
             alert('Ops, algo deu errado: ' + response.msg);
             console.log(response.msg);
         }

         // Atualiza tabela e coloca o conteudo padrão no editor de texto
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

    var note = {
      'deleted': 1,
    }

        // Requisição DELETE via AJAX pra excluir logicamente a nota
        // Deleção lógica mantem a nota no banco, porem, ela não é mais acessivel
        $.ajax({
            type: 'DELETE',
            data: note,
            url: '/deletenote/' + $(this).attr('rel')
        }).done(function( response ) {

            if (response.msg === '') {
                alert("Registro excluido com sucesso!");
            } else {
                alert('Ops, talvez esse registro já tenha sido excluído: ' + response.msg);
            }

            // Atualiza tabela
            populaTabela();
        });
}
