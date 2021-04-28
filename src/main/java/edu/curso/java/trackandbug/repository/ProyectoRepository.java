package edu.curso.java.trackandbug.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; //ABMC
import org.springframework.data.repository.query.Param;

import edu.curso.java.trackandbug.bo.Proyecto;

public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {

	//QUERYS
	//@Query de import org.springframework.data.jpa.repository.JpaRepository;	
	public Proyecto buscarProyectoPorId(Long id);	
	public List<Proyecto> buscadorDeProyectos(@Param("nombre") String nombre);		
	public Long guardarProyecto(Proyecto proyecto); //--proyecto solo, para q me devuelva el id que me generó
	public Long guardarProyecto(Proyecto proyecto, Long idUsuario, Long idTarea); //--proyecto con usuario y tarea
	public void actualizarProyecto(Proyecto proyecto);
	public void borrarProyecto(Long id);
	
	
	
		
	
	
	
	
}
