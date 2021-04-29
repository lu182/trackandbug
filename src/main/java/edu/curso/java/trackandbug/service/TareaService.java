package edu.curso.java.trackandbug.service;

import java.util.*;

import edu.curso.java.trackandbug.bo.Tarea;

/////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////


public interface TareaService { 

	//MÉTODOS
	
	public Tarea buscarTareaPorId(Long idTarea);
	public List<Tarea> buscarTareas();
	public List<Tarea> buscadorDeTareas(String nombre);	
	public List<Tarea> buscadorDeTareas(String nombre, Long idTipoTarea, Long idEstadoTarea);	
	public Long guardarTarea(Tarea tarea); //tarea sóla. -- throws TareaException
	public Long guardarTarea(Tarea tarea, Long idTipoTarea, Long idEstadoTarea, Long idComentario, Long idUsuario); //-- throws TareaException
	public void actualizarTarea(Tarea tarea);
	public void borrarTarea(Long idTarea);
	
}
