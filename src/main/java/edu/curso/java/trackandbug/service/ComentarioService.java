package edu.curso.java.trackandbug.service;

import java.util.*;

import edu.curso.java.trackandbug.bo.Comentario;

public interface ComentarioService {

	public Comentario guardarComentario(Comentario comentario);
	public void borrarComentario(Long idComentario);
	
	
	
}
