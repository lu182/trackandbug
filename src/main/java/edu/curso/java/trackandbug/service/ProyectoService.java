package edu.curso.java.trackandbug.service;

import java.util.*;



import edu.curso.java.trackandbug.bo.Proyecto;
import edu.curso.java.trackandbug.bo.Tarea;


         /////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////
       

public interface ProyectoService {   	
	
	//MÉTODOS
	
	public Proyecto buscarProyectoPorId(Long idProyecto);
	public List<Proyecto> buscarProyectos(); //Query hecha en ProyectoRepository
	public List<Proyecto> buscadorDeProyectos(String nombre);	//Query hecha en ProyectoRepository
	public Long guardarProyecto(Proyecto proyecto); // Proyectos solos SIN tareas --> /proyectos/{idProyecto}	
	public void actualizarProyecto(Proyecto proyecto);
	public void borrarProyecto(Long idProyecto);
	public List<Tarea> tareasProyectoPorId(Long idProyecto); // todas las tareas de un proyecto determinado(id) ---> /proyectos/{idProyecto}/tareas
	public void agregarUsuarioProyecto(Long idProyecto, Long idUsuario); //Asignar usuario a un proyecto/los proyectos --> /proyectos/{idProyecto}/agregar-usuario/{idUsuario}
	public Integer consultarHorasTotales(Long idProyecto); 
	
	
	
	
	
	
	
	
}
