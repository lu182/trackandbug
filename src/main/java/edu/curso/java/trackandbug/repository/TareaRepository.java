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
	
	//VER SI FUNCIONA
	//@Query(value = "from TipoTarea tt, Tarea t where tt.idTipoTarea like :idTipoTarea and t.idTarea like :idTarea")
//public List<Tarea> buscadorDeTareasPorTipo(@Param(value = "idTarea")Long idTarea, @Param(value = "idTipoTarea")Long idTipoTarea);
	//select nombre_tipo_tarea from tipos_tareas tt, tareas t where tt.id_tipo_tarea = t.id_tarea;
	
	//VER SI FUNCIONA
	//@Query(value = "from EstadoTarea et, Tarea t where et.idEstadoTarea like :idEstadoTarea and t.idTarea like :idTarea")
	//public List<Tarea> buscadorDeTareasPorEstado(@Param(value = "idTarea")Long idTarea, @Param(value = "idEstadoTarea")Long idEstadoTarea);
	
	@Query(value = "from Tarea t")
	public List<Tarea> buscarTareas();	
	
	
	@Query(value = "select sum(t.horasAsignadas) from Tarea t where t.idTarea = :idTarea") 
	public Integer consultarHorasTotales(@Param(value = "idTarea") Long idTarea); 
	
	
	
	
	
	
	
	
	
	//En esta clase van algunas querys. Sólo heredamos la clase CrudRepository de Spring que ya tiene todo 
	//y despues inyecto esta clase en la clase TareaServiceImp
		
	
}
