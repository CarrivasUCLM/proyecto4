package com.agibilibus.listaToDo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.agibilibus.listaToDo.dao.TareaDAO;

import org.json.JSONArray;
import org.json.JSONException;

@Component
public class Manager {
	private TareaDAO tareaDAO = new TareaDAO();

	private JSONArray listTareas;

	@Bean
	public static Manager get() {
		return ManagerHolder.singleton;
	}

	private static class ManagerHolder {
		static Manager singleton = new Manager();
	}

	private Manager() {

	}

	public void addTarea(String nombreTarea) {
		Tarea t = new Tarea(nombreTarea, false);
		tareaDAO.insert(t);
	}

	public JSONArray loadTasks() throws JSONException {
		JSONArray result = new JSONArray();
		List<Tarea> tareas = tareaDAO.selectAll();
		for (Tarea t : tareas)
			result.put(t.toJSON());
		return result;
	}

}
