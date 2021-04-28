package edu.curso.java.trackandbug.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; //ABMC
import org.springframework.data.repository.query.Param;

import edu.curso.java.trackandbug.bo.Proyecto;

public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {

	
	//@Query de import org.springframework.data.jpa.repository.JpaRepository;	
	
	@Query(value = "from Proyecto p where p.nombre like :nombre")
	public List<Proyecto> buscadorDeProyectos(@Param("nombre") String nombre);		
	
	
	//En esta clase van algunas querys. Sólo heredamos la clase CrudRepository de Spring que ya tiene todo 
	//y despues inyecto esta clase en la clase ProyectoServiceImp
		
	
	
	
		
	
	
	
	
}
