var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  console.log("teste");
  res.render('index', { title: 'Express' });
});

/* GET notes listing. */
// router.get('/', function(req, res, next) {
// 	console.log("teste");

// 	res.send('respond with a resource');
// });

/*
 * GET notelist.
 */
router.get('/listnotes', function(req, res) {
	console.log("teste");

    var db = req.db;
    db.collection('notes').find().toArray(function (err, items) {
        res.json(items);
    });
});

/*
 * POST to addnote
 */
router.post('/addnote', function(req, res) {
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
 router.delete('/deletenote', function(req, res) {
 	var db = req.db;
 	var noteToDelete = req.params.id;
 	db.collection('notes').removeById(noteToDelete, function(err, result) {
 		res.send((result === 1) ? { msg: '' } : { msg: 'error: ' + err });
 	});
 });


module.exports = router;
