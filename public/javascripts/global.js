console.log("Inicializou o global.js");
$(document ).ready(function() {

	$('#btnSave').on('click', function(){
 
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

	});
});

function capturaEventos(obj, evt, fn){
	if(obj.addEventListener){
		obj.addEventListener(evt, fn, true);
	}
	else{
		var evento = 'on' + evt;
		obj.attachEvent(evento, fn);
	}
}

function cancelaEvento(evt){
	if(evt.stopPropagation) {
		evt.stopPropagation();
		evt.preventDefault();
	} else {
		evt.cancelBubble = true;
		evt.returnValue = false;
	}
}

function verificaXmlHttp() {
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject('Microsoft.XMLHTTP');
	}
	return xmlhttp;
}

capturaEventos(window, 'load', function(evt){
	var a = document.getElementById('a');
	
	capturaEventos(a, 'click', function(evt){
		var xmlhttp = verificaXmlHttp();

		xmlhttp.onreadystatechange = function(){
			if(xmlhttp.readyState === 4 && xmlhttp.status === 200) {
				var dadosJSON;
				try {
					dadosJSON = JSON.parse(xmlhttp.responseText);
				} catch(e) {
					eval("dadosJSON = (" + xmlhttp.responseText + ");");
				}

				var div = document.getElementById('texto');

				for( var propriedade in dadosJSON ){
					div.innerHTML += propriedade + ' = ';
					
					if (typeof dadosJSON[propriedade] !== 'object') {
						div.innerHTML += dadosJSON[propriedade] + '<br>';
					} else { 
						div.innerHTML += '<br>';
						div.innerHTML += 'Desenvolver: ' + dadosJSON[propriedade][0].;
						div.innerHTML += '<br>';
						div.innerHTML += 'Ler: ' + dadosJSON[propriedade][1].Ler;
						div.innerHTML += '<br>';
						div.innerHTML += 'Beber: ' + dadosJSON[propriedade][2].Beber;
					}
				}				
			}
		}
		
		xmlhttp.open('GET', 'dados.json', true);
		xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xmlhttp.send(null);
		
		var evento = evt ? evt : window.event;
		cancelaEvento(evento);
	});
});