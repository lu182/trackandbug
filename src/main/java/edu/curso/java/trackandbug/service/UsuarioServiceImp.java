package edu.curso.java.trackandbug.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.trackandbug.bo.*;
import edu.curso.java.trackandbug.repository.*;

			/////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////

@Service  
@Transactional
public class UsuarioServiceImp implements UsuarioService {

	@Autowired   //inyecto
	private UsuarioRepository usuarioRepository; //Llamo al UsuarioRepository para que me brinde métodos propios que hereda del CrudRepository + lo que haya hecho en el repository

	
	
	
	@Override
	public Usuario buscarUsuarioPorId(Long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscadorDeUsuarios(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscadorDeUsuarios(String nombre, Long idProyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long guardarUsuario(Usuario usuario, Long idTarea, Long idProyecto, Long idComentario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
