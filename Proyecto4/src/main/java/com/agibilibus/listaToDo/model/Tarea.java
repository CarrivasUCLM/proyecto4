package com.agibilibus.listaToDo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tarea {
	@Id
	private String nombre;
	private boolean done;
	
	public Tarea (String nombre, boolean done) {
		this.nombre = nombre;
		this.done = done;
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
