print("create db started");

var conn = new Mongo("192.168.99.100", 27017);
var db = conn.getDB("mondodb-labs");

// limpiamos la db
db.dropDatabase();


// creamos las colecciones
var usuarios = db.createCollection("usuarios");
var roles = db.createCollection("roles");


var user = {
    "_id" : "0",
    "name" : "Camilo",
    "lastname" : "Molina",
    "date": null
};
usuarios.save(user);

user = {
    "_id" : "1",
    "name" : "Tania",
    "lastname" : "Molina",
    "date": null
};
usuarios.save(user);

user = {
    "_id" : "2",
    "name" : "Otro",
    "lastname" : ".",
    "date": null
};
usuarios.save(user);

var rol = {
    "_id" : "0",
    "name":"Administrador"
};
roles.save(rol);

rol = {
    "_id" : "1",
    "name":"Invitado"
};
roles.save(rol);


print("fertig");