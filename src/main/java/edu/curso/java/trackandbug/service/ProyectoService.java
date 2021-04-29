package edu.curso.java.trackandbug.service;

import java.util.*;


import edu.curso.java.trackandbug.bo.Proyecto;

         /////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////
       

public interface ProyectoService {   	
	
	//MÉTODOS
	
	public Proyecto buscarProyectoPorId(Long idProyecto);
	public List<Proyecto> buscarProyectos();
	public List<Proyecto> buscadorDeProyectos(String nombre);	
	public Long guardarProyecto(Proyecto proyecto); //proyecto sólo. -- throws ProyectoException
	public Long guardarProyecto(Proyecto proyecto, Long idTarea, Long idUsuario); //-- throws ProyectoException
	public void actualizarProyecto(Proyecto proyecto);
	public void borrarProyecto(Long idProyecto);
	
	
	
	
	
	
	
	
}
