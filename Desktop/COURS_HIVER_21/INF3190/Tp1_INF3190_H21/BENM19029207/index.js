var express = require('express');
var path = require('path');//https://nodejs.org/api/path.html
var bodyParser = require('body-parser');
var app=express();

app.use(express.static(path.join(__dirname,'public')));
app.use('/bs/', express.static(path.join(__dirname, 'node_modules/bootstrap/dist')));
app.use('/bs/', express.static(path.join(__dirname, 'node_modules/jquery/dist')));
app.use('/bs/', express.static(path.join(__dirname, 'node_modules/popper/dist')));


// create application/x-www-form-urlencoded parser
//http://expressjs.com/en/resources/middleware/body-parser.html
var urlencodedParser = bodyParser.urlencoded({ extended: false });
app.post('/vaccine',urlencodedParser,function(req,res){
 res.send(req.body);
 //res.json(req.body);
});
/* GET home page. */
app.get('/vaccine', function(req, res, next) {
  //res.render('index', { title: 'Express' });
	res.redirect('/index.html');
});

var portNumber=50007;// au besoin changer le numero de port
app.listen(portNumber,function(){console.log(' le serveur fonctionne sur le port: '+portNumber)});
console.log('serveur demarré avec success');
