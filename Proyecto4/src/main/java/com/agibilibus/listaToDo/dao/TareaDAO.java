package com.agibilibus.listaToDo.dao;

import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import model.Tarea;


public class TareaDAO {

	public static boolean select(Tarea tarea){
		boolean result = false;
		
		MongoCollection<Document> collection = MongoBroker.get().getCollection("Tareas");
		
		Document criterio=new Document();
		criterio.append("nombre", tarea.getNombre());
		
		FindIterable<Document> resultado = collection.find(criterio);
		Document tarea_db = resultado.first();
		
		try {
			if (tarea_db!= null) {
				tarea.setAll(((ObjectId)tarea_db.get( "_id" )).toString(), tarea_db.getString( "nombre" ), tarea_db.getString( "done" ));
			    result = true;
				
		}
		}catch(Exception e) {}
		
		return result;
	}
	
	
	public static ObjectId insert(Tarea tarea) {
		Document doc=new Document();
	
		if(tarea.getGroup() == null)
			tarea.setGroup("tareas");
		
		doc.append("nombre", tarea.getNombre());
		doc.append("done", tarea.getDone());

	
		MongoCollection<Document>collection = MongoBroker.get().getCollection("Tareas");
		collection.insertOne(doc);
	
		ObjectId id = (ObjectId)doc.get( "_id" );
		tarea.setId(id.toString());
		
		return id;
	}
	
	public static boolean delete(Tarea tarea) {
		
		MongoCollection<Document> collection = MongoBroker.get().getCollection("Tareas");
		return tarea.getId() &&
				collection.deleteOne(new Document("_id", new ObjectId(tarea.getId()))).wasAcknowledged()
				&& DAOGroup.deleteTareaGroupByTarea(tarea.getId());
	
	}
}
