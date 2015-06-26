console.log("Inicializou o global.js");

var login = function (){
	window.location='http://www.google.com';
}

var exports = {
  foo: function () {
    alert('d');
  },
  bar: function () {
    alert('da');
  }
};

var zemba = function () {
}