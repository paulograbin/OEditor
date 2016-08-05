var express = require('express');
var router = express.Router();

/* GET home page */
router.get('/', function(req, res, next) {
  console.log("Acessando o index...");
  res.render('index');
});

/*
 * GET notelist.
 */
router.get('/notes', function(req, res) {
  console.log("Listando as notas do banco...");
});

/*
 * PUT editnote
 */
router.put('/notes/:id', function(req, res) {
  console.log("Enviando nota editada pro banco...");

  var noteToUpdate =  req.params.id;
  var note = { $set: req.body };
})

/*
 * POST addnote
 */
router.post('/notes', function(req, res) {
  console.log("Salvando nova nota no banco...");

  var content = req.body;
  console.log(content);
    
   res.status(200);
   res.send();
})


/*
 * DELETE deletenote
 */
 router.delete('/notes/:id', function(req, res) {
   console.log("Deletando nota do banco...");

   var noteToDelete =  req.params.id;
   var note = { $set: req.body };
 });

module.exports = router;
