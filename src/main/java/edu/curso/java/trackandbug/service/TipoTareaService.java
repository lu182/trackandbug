package edu.curso.java.trackandbug.service;


import java.util.List;


import edu.curso.java.trackandbug.bo.TipoTarea;


public interface TipoTareaService {

	
	public TipoTarea buscarTipoTareaPorId(Long idTipoTarea);
	public List<TipoTarea> buscarTiposTareas(); 
		
	public TipoTarea guardarTipoTarea(Long idTipoTarea, String nombreTipoTarea);

}
