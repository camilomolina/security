var MongoClient = require('mongodb').MongoClient;
var assert = require('assert');

// conneccion
var url = 'mongodb://192.168.99.100:27017/mondodb-labs';

// Use connect method to connect to the server
MongoClient.connect(url, function(err, db) {
    assert.equal(null, err);
    console.log("Connected successfully to server");


    // limpiamos la db
    db.dropDatabase();


    // creamos las colecciones
    var usuarios = db.collection("usuarios");
    var roles = db.collection("roles");


    var user = {
        "_id" : "0",
        "name" : "Camilo",
        "lastname" : "Molina",
        "date": null
    };
    usuarios.insertOne(user);

    user = {
        "_id" : "1",
        "name" : "Tania",
        "lastname" : "Molina",
        "date": null
    };
    usuarios.insertOne(user);

    user = {
        "_id" : "2",
        "name" : "Otro",
        "lastname" : ".",
        "date": null
    };
    usuarios.insertOne(user);

    var rol = {
        "_id" : "0",
        "name":"Administrador"
    };
    roles.insertOne(rol);

    rol = {
        "_id" : "1",
        "name":"Invitado"
    };
    roles.insertOne(rol);

    db.close();
});
