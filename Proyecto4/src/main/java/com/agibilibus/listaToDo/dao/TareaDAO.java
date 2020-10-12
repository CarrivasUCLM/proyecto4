package com.agibilibus.listaToDo.dao;


import java.util.LinkedList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agibilibus.listaToDo.model.Tarea;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;


public class TareaDAO{
	String tabla = "tareas";

	public List<Tarea> selectAll(){
		List<Tarea> result = new LinkedList<>();
		
		MongoCollection<Document> collection = MongoBroker.get().getCollection(tabla);
		MongoCursor<Document> it = collection.find().iterator();
		
		while(it.hasNext()) {
			Document document = it.next();
			Tarea tarea = new Tarea(document.getString("nombre"),document.getBoolean("done"));
			tarea.setId(document.get("_id").toString());
			
			result.add(tarea);
		}
		
		return result;
	}
	
	public boolean select(Tarea tarea){
		
		MongoCollection<Document> collection = MongoBroker.get().getCollection(tabla);
		
		Document criterio=new Document();
		criterio.append("nombre", tarea.getNombre());
		
		FindIterable<Document> resultado = collection.find(criterio);
		Document tarea_db = resultado.first();
		

			if (tarea_db!= null) {
				tarea.setId(((ObjectId)tarea_db.get( "_id" )).toString());
				tarea.setNombre(tarea_db.getString("nombre"));
				tarea.setDone(tarea_db.getBoolean( true ));
				
			    return true;
				
		}
		
		return false;
	}
	
	public boolean update(Tarea tarea){
		
		Document criterio=new Document();
		criterio.append("_id", new ObjectId(tarea.getId()));
		
		Document newValue = new Document();
		newValue.append("done", tarea.isDone());
		
		MongoCollection<Document> collection = MongoBroker.get().getCollection(tabla);
		
		return collection.updateOne(criterio, new Document("$set",newValue)).wasAcknowledged();
	}
	
	
	public ObjectId insert(Tarea tarea) {
		Document doc=new Document();

		doc.append("nombre", tarea.getNombre()).append("done", tarea.isDone());
		
		MongoCollection<Document>collection = MongoBroker.get().getCollection(tabla);
		
		collection.insertOne(doc);
	
		ObjectId id = (ObjectId)doc.get( "_id" );
		tarea.setId(id.toString());
		
		return id;
	}
	
	public boolean delete(Tarea tarea) {
		
		MongoCollection<Document> collection = MongoBroker.get().getCollection(tabla);
		return collection.deleteOne(new Document("_id", new ObjectId(tarea.getId()))).wasAcknowledged();
	
	}
}
