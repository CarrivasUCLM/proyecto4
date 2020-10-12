package com.agibilibus.listaToDo.model;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.agibilibus.listaToDo.dao.TareaDAO;

@Entity
public class Tarea {

	@Id
	private String id;
	private String nombre;
	private boolean done;

	public Tarea() {
	}

	public Tarea(String nombre, boolean done) {
		this.nombre = nombre;
		this.done = done;
	}
	
	public JSONObject toJSON() throws JSONException {
		JSONObject jso = new JSONObject();
		jso.put("id", this.id);
		jso.put("nombre", this.nombre);
		jso.put("done", this.done); 
		return jso;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
