package edu.curso.java.trackandbug.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.trackandbug.bo.Comentario;
import edu.curso.java.trackandbug.repository.ComentarioRepository;

@Service  
@Transactional
public class ComentarioServiceImp implements ComentarioService{

	@Autowired 
	private ComentarioRepository comentarioRepository;

	@Override
	public Comentario guardarComentario(Comentario comentario) {
		
		return comentarioRepository.save(comentario);
	}

	@Override
	public void borrarComentario(Long idComentario) {
		
		comentarioRepository.deleteById(idComentario);
		
	}
	
	
	
	
	
	
	
	
}
