package edu.curso.java.trackandbug.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; //ABMC
import org.springframework.data.repository.query.Param;

import edu.curso.java.trackandbug.bo.Proyecto;

public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {

	//QUERYS

	
}
