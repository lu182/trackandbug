package edu.curso.java.trackandbug.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.curso.java.trackandbug.bo.EstadoTarea;
import edu.curso.java.trackandbug.bo.Proyecto;
import edu.curso.java.trackandbug.bo.Tarea;


public interface EstadoTareaRepository  extends CrudRepository<EstadoTarea, Long>{

	@Query(value = "from EstadoTarea et")
	public List<EstadoTarea> buscarEstadosTareas();
	
		
	
}
