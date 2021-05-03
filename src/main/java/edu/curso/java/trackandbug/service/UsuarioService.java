package edu.curso.java.trackandbug.service;

import java.util.*;

import edu.curso.java.trackandbug.bo.Tarea;
import edu.curso.java.trackandbug.bo.Usuario;

/////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////


public interface UsuarioService {  

	//MÉTODOS
	
	public Usuario buscarUsuarioPorId(Long idUsuario);
	public Iterable<Usuario> buscarUsuarios(); 
	public List<Usuario> buscadorDeUsuarios(String nombre);	
	public Long guardarUsuario(Usuario usuario); 
	
	
	
	
	

}
