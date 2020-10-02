package com.agibilibus.listaToDo.model;

import com.agibilibus.listaToDo.dao.TareaDAO;

public class Tarea {
	
	private String id;
	private String nombre;
	private boolean done;
	
	public Tarea() {}
	public Tarea (String nombre, boolean done) {
		this.nombre = nombre;
		this.done = done;
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
	
	public boolean select() {
		return new TareaDAO().select(this);
	}
	

}
