package com.agibilibus.listaToDo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import com.agibilibus.listaToDo.model.Manager;
import com.agibilibus.listaToDo.model.Tarea;

@RestController
public class Controller {

	@PostMapping("/loadTareas")
	public JSONArray getTareas() throws Exception {
		return Manager.get().loadTasks();
	}
	
	@PostMapping("/addTarea")
	public void addTarea(@RequestBody Map<String, Object> datosTarea) throws JSONException {
		JSONObject jso = new JSONObject(datosTarea);	
		String nombreTarea = jso.getString("tarea");
		Manager.get().addTarea(nombreTarea);
		
	}
}

