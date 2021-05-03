package edu.curso.java.trackandbug.service;

import java.util.*;

import edu.curso.java.trackandbug.bo.EstadoTarea;


public interface EstadoTareaService {

	
	public EstadoTarea buscarEstadoTareaPorId(Long idEstadoTarea);
	public Iterable<EstadoTarea> buscarEstadosTareas();
	public List<EstadoTarea> buscadorDeEstadosTareaPorNombre(String nombreEstadoTarea);
	
		
	
	
}
