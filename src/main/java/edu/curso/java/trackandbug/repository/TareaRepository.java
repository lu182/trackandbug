package edu.curso.java.trackandbug.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; //ABMC
import org.springframework.data.repository.query.Param;

import edu.curso.java.trackandbug.bo.Tarea;

public interface TareaRepository extends CrudRepository<Tarea, Long> {

	//QUERYS
	
	
	
}
