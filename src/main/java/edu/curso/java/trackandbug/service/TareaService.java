package edu.curso.java.trackandbug.service;

import java.util.*;



import edu.curso.java.trackandbug.bo.Tarea;
import edu.curso.java.trackandbug.rest.TareaDTO;

/////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////


public interface TareaService { 

	//MÉTODOS
	
	public Tarea buscarTareaPorId(Long idTarea); 
	public Iterable<Tarea> buscarTareas(); 
	public List<Tarea> buscadorDeTareasPorTipo(Long idTarea, Long idTipoTarea); 
	public List<Tarea> buscadorDeTareasPorEstado(Long idTarea, Long idEstadoTarea); 
	public void actualizarTarea(Tarea tarea);
	public void borrarTarea(Long idTarea);
	public Long consultarHorasTotales(Long idTarea); 
	
	public void agregarUsuarioTarea(Long idTarea, Long idUsuario);
	
	
	
	
	
	
	
	
}
