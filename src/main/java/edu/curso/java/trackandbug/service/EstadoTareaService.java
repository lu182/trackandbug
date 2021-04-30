package edu.curso.java.trackandbug.service;

import java.util.*;

import edu.curso.java.trackandbug.bo.EstadoTarea;



public interface EstadoTareaService {

	
	public EstadoTarea buscarEstadoTareaPorId(Long idEstadoTarea);
	public List<EstadoTarea> buscarEstadosTareas(); 
	
	
	public EstadoTarea guardarEstadoTarea(Long idEstadoTarea, String nombreEstadoTarea);
	
	
}
