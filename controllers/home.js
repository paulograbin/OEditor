index = function(req, res) {
	console.log("Requesting index...");

 	res.render('index')
}

exports.index = index;