package edu.curso.java.trackandbug.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import edu.curso.java.trackandbug.bo.TipoTarea;

public interface TipoTareaRepository extends CrudRepository<TipoTarea, Long> {

	@Query(value = "from TipoTarea tt")
	public List<TipoTarea> buscarTiposTareas();
}
