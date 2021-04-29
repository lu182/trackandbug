package edu.curso.java.trackandbug.service;

import java.util.*;

import edu.curso.java.trackandbug.bo.Tarea;
import edu.curso.java.trackandbug.bo.Usuario;

/////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////


public interface UsuarioService {  

	//MÉTODOS
	
	public Usuario buscarUsuarioPorId(Long idUsuario);
	public List<Usuario> buscarUsuarios(); //Query hecha en UsuarioRepository
	public List<Usuario> buscadorDeUsuarios(String nombre);	//Query hecha en UsuarioRepository
	public Long guardarUsuario(Usuario usuario); //usuario sólo. 
	public void actualizarUsuario(Usuario usuario);
	public void borrarUsuario(Long idUsuario);
	
	
	

}
