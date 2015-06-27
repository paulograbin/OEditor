var express = require('express');
var router = express.Router();

/* GET home page */
router.get('/', function(req, res, next) {
  console.log("teste");
  res.render('index', { title: 'Express' });
});

/* GET login page */
router.get('/login', function(req, res, next) {
  console.log("login...");
  res.render('login', { title: 'Login' });
});

/* GET relatorio */
router.get('/relatorio', function(req, res, next) {
  console.log("Exibindo relatório...");

  res.sendFile('/relatorio_GB.pdf', function (err) {
    if (err) {
      console.log(err);
      res.status(err.status).end();
    }
    else {
      console.log('Sent:', fileName);
    }
  });
});

/*
 * GET notelist.
 */
router.get('/listnotes', function(req, res) {
	console.log("listando notas...");

    var db = req.db;
    db.collection('notes').find().toArray(function (err, items) {
        res.json(items);
    });
});

/*
 * PUT to editnote
 */
router.put('/editnote', function(req, res) {
  console.log(req.body);

  var db = req.db;
  db.collection('notes').updateById(req.body, function(err, result) {
    res.send(
      (err === null) ? { msg: '' } : { msg: err}
    );
  });
})

/*
 * POST to addnote
 */
router.post('/addnote', function(req, res) {
  console.log("Salvando nova nota no banco...");
  console.log(req.body);

	var db = req.db;
	db.collection('notes').insert(req.body, function(err, result) {
		res.send(
			(err === null) ? { msg: '' } : { msg: err}
		);
	});
})

/*
 * DELETE to deletenote
 */
 router.delete('/deletenote/:id', function(req, res) {
 	var db = req.db;
 	var noteToDelete = req.params.id;
 	db.collection('notes').removeById(noteToDelete, function(err, result) {
 		res.send((result === 1) ? { msg: '' } : { msg: 'error: ' + err });
 	});
 });


module.exports = router;
