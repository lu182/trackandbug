package edu.curso.java.trackandbug.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; //ABMC
import org.springframework.data.repository.query.Param;

import edu.curso.java.trackandbug.bo.Proyecto;
import edu.curso.java.trackandbug.bo.Tarea;

public interface TareaRepository extends CrudRepository<Tarea, Long> {

	//QUERYS
	
	@Query(value = "from Tarea t where t.nombreTarea like :nombreTarea")
	public List<Tarea> buscadorDeTareas(@Param("nombreTarea") String nombre);
	
	@Query(value = "from Tarea t")
	public List<Tarea> buscarTareas();	
	
	
	@Query(value = "select sum(t.horasAsignadas) from Tarea t where t.idTarea = :idTarea") 
	public Integer consultarHorasTotales(@Param(value = "idTarea") Long idTarea); 
	
	
	
	
	
	
	
	
	
	//En esta clase van algunas querys. Sólo heredamos la clase CrudRepository de Spring que ya tiene todo 
	//y despues inyecto esta clase en la clase TareaServiceImp
		
	
}
