package edu.curso.java.trackandbug.service;

import java.util.*;



import edu.curso.java.trackandbug.bo.Tarea;
import edu.curso.java.trackandbug.rest.TareaDTO;

/////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////


public interface TareaService { 

	//MÉTODOS
	
	public Tarea buscarTareaPorId(Long idTarea); 
	public List<Tarea> buscarTareas(); //Query hecha en TareaRepository
	public List<Tarea> buscadorDeTareasPorTipo(Long idTarea, Long idTipoTarea); //Query hecha en TareaRepository
	public List<Tarea> buscadorDeTareasPorEstado(Long idTarea, Long idEstadoTarea); //Query hecha en TareaRepository
	public void actualizarTarea(Tarea tarea);
	public void borrarTarea(Long idTarea);
	public Integer consultarHorasTotales(Long idTarea); //Query hecha en TareaRepository
	
	public Long guardarTareaConProyecto(Tarea tarea, Long idProyecto) throws ProyectoException; //FALTA TERMINAR EN TareaRest
	public Long guardarTareaConTipoYEstado(Tarea tarea, Long idTipoTarea, Long idEstadoTarea);
	
	
	public TareaDTO altaTarea(Long idProyecto, Integer horasAsignadasTarea, Long idTipoTarea, Long idEstadoTarea);
	
	
	
	
}
