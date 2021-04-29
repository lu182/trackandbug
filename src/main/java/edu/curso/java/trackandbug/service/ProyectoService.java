package edu.curso.java.trackandbug.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import edu.curso.java.trackandbug.bo.Proyecto;
import edu.curso.java.trackandbug.bo.Tarea;
import edu.curso.java.trackandbug.bo.Usuario;

         /////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////
       

public interface ProyectoService {   	
	
	//MÉTODOS
	
	public Proyecto buscarProyectoPorId(Long idProyecto);
	public List<Proyecto> buscarProyectos(); //Query hecha en ProyectoRepository
	public List<Proyecto> buscadorDeProyectos(String nombre);	//Query hecha en ProyectoRepository
	public Long guardarProyecto(Proyecto proyecto); //hecho -- Proyectos solos SIN tareas --> /proyectos/{idProyecto}
	public void actualizarProyecto(Proyecto proyecto);
	public void borrarProyecto(Long idProyecto);
	public List<Tarea> tareasProyectoPorId(Long idProyecto); // hecho -- todas las tareas de un proyecto determinado(id) ---> /proyectos/{idProyecto}/tareas
	public List<Usuario> usuariosProyecto(Long idProyecto,Long idUsuario); //hecho VER -- Asignar usuario a un proyecto/los proyectos --> /proyectos/{idProyecto}/agregar-usuario/{idUsuario}
	public Integer consultarHorasTotales(Long idProyecto); //hecho VER
	
	
	
	
	
	
	
	
}
