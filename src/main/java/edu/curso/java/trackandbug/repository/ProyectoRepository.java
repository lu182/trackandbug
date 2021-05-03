package edu.curso.java.trackandbug.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; //ABMC
import org.springframework.data.repository.query.Param;


import edu.curso.java.trackandbug.bo.Proyecto;
import edu.curso.java.trackandbug.bo.TipoTarea;

public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {

	
	//@Query de import org.springframework.data.jpa.repository.JpaRepository;	
	
	@Query(value = "from Proyecto p where p.nombre like :nombre")
	public List<Proyecto> buscadorDeProyectos(@Param("nombre") String nombre);		
	
	@Query(value = "from Proyecto p")
	public List<Proyecto> buscarProyectos(); 
}
