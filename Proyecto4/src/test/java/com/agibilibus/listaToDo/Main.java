package com.agibilibus.listaToDo;

import java.util.Iterator;
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
		
		TareaDAO dao = new TareaDAO();

		/*Tarea t1 = new Tarea("Comprar pan2", false);
		Tarea t2 = new Tarea("Clase de zumba", true);
		Tarea t3 = new Tarea("Proyecto de procesos", false);*/
		Tarea t4 = new Tarea("Prueba 6", false);
		
		//dao.insert(t1);
		//dao.insert(t2);
		//dao.insert(t3);
		dao.insert(t4);
		
		//if (dao.delete(t2))
		//	System.out.println("Tarea eliminada con exito.");
		
		List<Tarea> tareas = dao.selectAll();
		Iterator<Tarea> it =  tareas.iterator();
		
		while(it.hasNext()) {
			Tarea t = it.next();
			t.setDone(false);
			dao.update(t);
		}
			
	}	

	
	

}
