/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Conexion {

    DB baseDatos1;
    DBCollection coleccion1;

    public Conexion() {
        MongoClient mongo = new MongoClient("localhost", 27017);
        baseDatos1 = mongo.getDB("Farmacia");
        coleccion1 = baseDatos1.getCollection("Productos");
    }
}
