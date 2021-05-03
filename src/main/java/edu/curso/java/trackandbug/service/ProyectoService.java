package edu.curso.java.trackandbug.service;

import java.util.*;


import edu.curso.java.trackandbug.bo.Proyecto;
import edu.curso.java.trackandbug.bo.Tarea;


         /////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////
       

public interface ProyectoService {   	
	
	//MÉTODOS
	
	public Proyecto buscarProyectoPorId(Long idProyecto);
	public List<Proyecto> buscarProyectos(); 	
	public List<Proyecto> buscadorDeProyectos(String nombre);	
	public Long guardarProyecto(Proyecto proyecto) throws ProyectoException; 
	public void actualizarProyecto(Proyecto proyecto);
	public void borrarProyecto(Long idProyecto);
	
	public List<Tarea> tareasProyectoPorId(Long idProyecto); 
	
	public void agregarUsuarioProyecto(Long idProyecto, Long idUsuario); 
	
	public Integer consultarHorasTotalesProyecto(Long idProyecto); 
	
	public void asignarTareaAlProyecto(Long idProyecto, Long idTarea);
	
	
	
	
	
}
