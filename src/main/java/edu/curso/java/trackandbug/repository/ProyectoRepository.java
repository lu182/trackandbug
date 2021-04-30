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
	
	@Query(value = "from Proyecto p")
	public List<Proyecto> buscarProyectos();	
	
	@Query(value = "select sum(p.horasTotales) from Proyecto p where p.idProyecto = :idProyecto") //tienen que coincidir con los atributos de la clase Bo
	public Long consultarHorasTotales(@Param(value = "idProyecto") Long idProyecto);
	
	
	
	
	
	
	//En esta clase van algunas querys. Sólo heredamos la clase CrudRepository de Spring que ya tiene todo 
	//y despues inyecto esta clase en la clase ProyectoServiceImp
	
	
		
	
	
	
	
}
