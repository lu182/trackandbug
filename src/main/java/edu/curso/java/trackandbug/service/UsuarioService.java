package edu.curso.java.trackandbug.service;

import java.util.*;


import edu.curso.java.trackandbug.bo.Usuario;

/////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////


public interface UsuarioService {  

	//MÉTODOS
	
	public Usuario buscarUsuarioPorId(Long idUsuario);
	public List<Usuario> buscarUsuarios();
	public List<Usuario> buscadorDeUsuarios(String nombre);	
	public List<Usuario> buscadorDeUsuarios(String nombre, Long idProyecto);	
	public Long guardarUsuario(Usuario usuario); //usuario sólo. -- throws TareaException
	public Long guardarUsuario(Usuario usuario, Long idTarea, Long idProyecto, Long idComentario); //-- throws TareaException
	public void actualizarUsuario(Usuario usuario);
	public void borrarUsuario(Long idUsuario);
}
