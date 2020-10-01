package com.agibilibus.listaToDo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agibilibus.listaToDo.model.Tarea;

@Repository
public interface TareaDAO extends CrudRepository<Tarea, String>{

}
