package edu.curso.java.trackandbug.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.curso.java.trackandbug.bo.EstadoTarea;



public interface EstadoTareaRepository  extends CrudRepository<EstadoTarea, Long>{

		
	@Query(value = "from EstadoTarea et where et.nombreEstadoTarea like :nombreEstadoTarea")
	public List<EstadoTarea> buscadorDeEstadosTareaPorNombre(@Param("nombreEstadoTarea") String nombreEstadoTarea);
	
}
