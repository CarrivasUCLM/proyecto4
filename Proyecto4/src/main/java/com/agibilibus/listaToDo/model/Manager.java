package com.agibilibus.listaToDo.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.agibilibus.listaToDo.dao.TareaDAO;




@Component
public class Manager {
	private TareaDAO dao = new TareaDAO();
	
	@Bean
	public static Manager get() {
		return ManagerHolder.singleton;
	}
	
	private static class ManagerHolder {
		static Manager singleton = new Manager();
	}
	
	private Manager() {

		//Tarea t1 = new Tarea("Launcher", true);
		
		//dao.insert(t1);
		
	}
	
	public List<Tarea> getTareas() {
		return dao.selectAll();
	}

}
