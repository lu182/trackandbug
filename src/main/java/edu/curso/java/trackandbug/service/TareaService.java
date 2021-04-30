package edu.curso.java.trackandbug.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import edu.curso.java.trackandbug.bo.Tarea;

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
	
	public Long guardarTarea(Tarea tarea, Long idProyecto) throws ProyectoException; //FALTA TERMINAR EN TareaRest
	
	public void agregarTareaProyecto(Long idProyecto, Long idTarea); //AGREGAR
	public void agregarTareaAlEstadoTarea(Long idEstadoTarea, Long idTarea); //AGREGAR
	public void agregarTareaAlTipoTarea(Long idTipoTarea, Long idTarea); //AGREGAR
	
	
}
