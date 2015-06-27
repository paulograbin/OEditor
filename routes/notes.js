var express = require('express');
var router = express.Router();

/* GET home page */
router.get('/', function(req, res, next) {
  console.log("Acessando o index...");
  res.render('index');
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
	console.log("Listando as notas do banco...");

    var db = req.db;
    db.collection('notes').find( { deleted: "0" } ).toArray(function (err, items) {
        res.json(items);
    });
});

/*
 * PUT editnote
 */
router.put('/editnote/:id', function(req, res) {
  console.log("Enviando nota editada pro banco...");

  var noteToUpdate =  req.params.id;
  var note = { $set: req.body };

  var db = req.db;
  db.collection('notes').updateById(noteToUpdate, note, function(err, result) {
  	res.send(
      (result === 1) ? { msg: '' } : { msg: 'error: ' + err }
      );
  });
})

/*
 * POST addnote
 */
router.post('/addnote', function(req, res) {
  console.log("Salvando nova nota no banco...");

	var db = req.db;
	db.collection('notes').insert(req.body, function(err, result) {
		res.send(
			(err === null) ? { msg: '' } : { msg: err}
		);
	});
})

/*
 * DELETE deletenote
 */
 router.delete('/deletenote/:id', function(req, res) {
   console.log("Deletando nota do banco...");

   var noteToDelete =  req.params.id;
   var note = { $set: req.body };

 	var db = req.db;
 	db.collection('notes').updateById(noteToDelete, note, function(err, result) {
 		res.send(
       (result === 1) ? { msg: '' } : { msg: 'error: ' + err }
       );
 	});
 });

module.exports = router;
