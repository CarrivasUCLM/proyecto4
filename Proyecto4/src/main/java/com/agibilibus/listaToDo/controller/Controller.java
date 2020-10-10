package com.agibilibus.listaToDo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.agibilibus.listaToDo.model.Manager;
import com.agibilibus.listaToDo.model.Tarea;

@RestController
public class Controller {

	@GetMapping("/getTareas")
	public List<Tarea> getTareas() throws Exception {
		return Manager.get().getTareas();
	}
}

