package com.agibilibus.listaToDo.dao;


import org.bson.Document;
import org.bson.types.ObjectId;

import com.agibilibus.listaToDo.model.MongoBroker;
import com.agibilibus.listaToDo.model.Tarea;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;


public class TareaDAO {

	public boolean select(Tarea tarea){
		boolean result = false;
		
		MongoCollection<Document> collection = MongoBroker.get().getCollection("tareas");
		
		Document criterio=new Document();
		criterio.append("nombre", tarea.getNombre());
		
		FindIterable<Document> resultado = collection.find(criterio);
		Document tarea_db = resultado.first();
		
		try {
			if (tarea_db!= null) {
				tarea.setId(((ObjectId)tarea_db.get( "_id" )).toString());
				tarea.setNombre(tarea_db.getString("nombre"));
				tarea.setDone(tarea_db.getBoolean( true ));
				
			    result = true;
				
		}
		}catch(Exception e) {}
		
		return result;
	}
	
	
	public ObjectId insert(Tarea tarea) {
		Document doc=new Document();

		doc.append("nombre", tarea.getNombre());
		doc.append("done", tarea.isDone());
		
		MongoCollection<Document>collection = MongoBroker.get().getCollection("tareas");
		
		collection.insertOne(doc);
	
		ObjectId id = (ObjectId)doc.get( "_id" );
		tarea.setId(id.toString());
		
		return id;
	}
	
	public boolean delete(Tarea tarea) {
		
		MongoCollection<Document> collection = MongoBroker.get().getCollection("tareas");
		return collection.deleteOne(new Document("_id", new ObjectId(tarea.getId()))).wasAcknowledged();
	
	}
}
