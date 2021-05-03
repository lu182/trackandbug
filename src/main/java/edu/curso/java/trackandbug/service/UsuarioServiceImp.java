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

	@Autowired   
	private TareaRepository tareaRepository; 
	
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	
	
	@Override
	public Usuario buscarUsuarioPorId(Long idUsuario) {  
		
		return usuarioRepository.findById(idUsuario).get();
	}

	@Override
	public Iterable<Usuario> buscarUsuarios() { 
		
		return usuarioRepository.findAll();
	}

	@Override
	public List<Usuario> buscadorDeUsuarios(String nombre) { 
		
		return usuarioRepository.buscadorDeUsuarios(nombre);
	}

	@Override
	public Long guardarUsuario(Usuario usuario) { 
		
		usuarioRepository.save(usuario);
		return usuario.getIdUsuario();
	}





	
	
	
}
