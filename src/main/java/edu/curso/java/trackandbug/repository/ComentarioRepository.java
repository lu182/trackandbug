package edu.curso.java.trackandbug.repository;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.curso.java.trackandbug.bo.Comentario;


public interface ComentarioRepository extends CrudRepository<Comentario, Long> {

	
	
	
	
}
