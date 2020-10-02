package com.agibilibus.listaToDo;

import java.util.List;

import org.bson.Document;

import com.agibilibus.listaToDo.dao.TareaDAO;
import com.agibilibus.listaToDo.model.Tarea;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Main {

	public static void main(String[] args) {
		
		Tarea t1 = new Tarea("Comprar pan", false);
		Tarea t2 = new Tarea("Clase de zumba", false);
		Tarea t3 = new Tarea("Proyecto de procesos", false);

		TareaDAO dao = new TareaDAO();
		dao.insert(t1);
		dao.insert(t2);
		dao.insert(t3);
		
		if (dao.delete(t2))
			System.out.println("Tarea eliminada con exito.");
		
	}	

	
	

}
