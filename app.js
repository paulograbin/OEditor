var express = require('express');
var path = require('path');
var compression = require('compression');

var homeController = require("./controllers/home.js");
var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

// Home controller
app.get('/', homeController.index);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

console.log("OEditor está rodando na porta 4300");
app.listen(4300);