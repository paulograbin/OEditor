'use strict';

console.log("Inicializou o global.js");

var textoPadraoEditor = null;
var id = null;

$(document).ready(function() {
    textoPadraoEditor = CKEDITOR.instances.editor1.getData();
    populaTabela();

    // Salva nota no evento click
    $('#btnSave').on('click', salvarNota);

    // Deleta nota no evento click
    $('table tbody').on('click', 'td a.linkDeleteNote', apagaNota);

    // Abre nota no evento click
    $('table tbody').on('click', 'td a.linkOpenNote', abreNota);
});

function populaTabela() {
    // Requisição GET via AJAX pra pegar todas as notas do banco
    console.log("Requisitando notas...");
    $.getJSON('http://localhost:3000/notes', function(data) {
    console.log(data.length + " notas encontadas...");

      var tableContent = '';
      var cont = 1;

      // Para cada item no JSON uma nova linha na tabela é adiciona com o conteudo
      $.each(data, function() {
        console.log(this);

        if(this.deleted == true) 
          return;

        tableContent += '<tr>';
        tableContent += '<td>' + cont + '</td>';
        tableContent += '<td id="note'+ cont +'">' + this.text + '</td>';
        tableContent += '<td>' + getDateFromDateObject(this.creationDate.date) + " " + getTimeFromDateObject(this.creationDate.time) + '</td>';
        tableContent += '<td>' + "<a ref='#' class='linkOpenNote btn btn-success btn-large' rel='" + this.id + "'" + "num='" + cont + "' + >Editar" + "</a>";
        tableContent +=          "<a ref='#' class='linkDeleteNote btn btn-danger btn-large' rel='" + this.id + "'>Apagar" + "</a>" + '</td>';
        tableContent += "<div class='grabin'>" + this + "</div>";
        tableContent += '</tr>';

        cont += 1;
      });

      // Injeta toda a variavel na tabela HTML existente no layout
      $('table tbody').html(tableContent);
    });
}

function getDateFromDateObject(dateObject) {
  return dateObject.day + '/'+ dateObject.month + '/'+ dateObject.year
}

function getTimeFromDateObject(dateObject) {
  return dateObject.hour + ':' + dateObject.minute + ':'+ dateObject.second;
}

function limparConteudo() {
    CKEDITOR.instances.editor1.setData(textoPadraoEditor);
    id = null;
    $("#btnSave").val('Salvar nova nota');
}

function salvarNotaNova() {
    console.log("Adicionando nova nota...");

    var errorCount = 0;
    var text = CKEDITOR.instances.editor1.getData();

    // Verifica se caixa de texto está vazia
    if(text.length == 0) {
      errorCount++;
    }

    // Se nenhum erro foi encontrado
    if(errorCount === 0) {
      // Se algum conteudo foi digitado, cria uma nota...
      var note = {
          'text':  CKEDITOR.instances.editor1.getData()
      }

      // Requisição POST via AJAX pra postar a nota pro banco
      $.ajax({
          type: 'POST',
          data: note,
          url: 'http://localhost:3000/notes',
          dataType: 'JSON'
      }).done(function( response ) {
          if (response.success == true) {
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

function salvarNotaEditada(id) {
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
        'id': id,
        'text': CKEDITOR.instances.editor1.getData(),
      }

      // Requisição PUT via AJAX pra atualizar a nota no banco
      $.ajax({
         type: 'PUT',
         data: note,
         url: 'http://localhost:3000/notes/' + id,
         dataType: 'JSON',
      }).done(function(response) {

         if (response.success === true) {
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

function salvarNota () {
    if(id)
      salvarNotaEditada(id);
    else
      salvarNotaNova();
}

function abreNota() {
    console.log("Editando note " + $(this).attr('rel'));
    id = $(this).attr('rel');
    console.log("id agora é " + id);

    var textoNotaEdicao = $("#note"+ $(this).attr('num')).html();
    CKEDITOR.instances.editor1.setData(textoNotaEdicao);

    $("#btnSave").val('Salvar nota ' + $(this).attr('num'));
}

function apagaNota() {
    console.log("Deletando note " + $(this).attr('rel'));

    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:3000/notes/' + $(this).attr('rel'),
        dataType: 'JSON'
    }).done(function( response ) {
        if (response.success == true) {
            alert("Nota deletada com sucesso!");
        } else {
            alert("Ops, algum problema ocorreu: " + response.msg);
        }

        // Atualiza tabela e coloca o conteudo padrão no editor de texto
        limparConteudo();
        populaTabela();
    });
}
