package edu.curso.java.trackandbug.rest;


import java.util.Date;

import javax.validation.*;
import javax.validation.constraints.NotBlank;

import edu.curso.java.trackandbug.bo.*;

public class ComentarioDTO {

	private Long idComentarioDto;
	
	@NotBlank(message = "Se debe colocar una descripcion en el comentario")
	private String descripcionComentario;
	
	private Date fechaComentario = new Date();
	
	private Long idTareaComentario;
	
	private Long idUsuarioComentario;
	
	
	public ComentarioDTO() {
		
	}
	
	
	public ComentarioDTO(Comentario c) {
		this.idComentarioDto = c.getIdComentario();
		this.descripcionComentario = c.getDescripcion();
		this.fechaComentario = c.getFecha();
		//this.idTareaComentario = c.getTarea().getIdTarea(); //varios comentarios 1 tarea
		//this.idUsuarioComentario = c.getUsuario().getIdUsuario(); //varios comentarios 1 usuario		
		Tarea tarea = c.getTarea();
		if(tarea != null) {
			this.idTareaComentario = tarea.getIdTarea();
		}
		
		Usuario usuario = c.getUsuario();
		if(usuario != null) {
			this.idUsuarioComentario = usuario.getIdUsuario();
		}
		
	}


	public Long getIdComentarioDto() {
		return idComentarioDto;
	}


	public void setIdComentarioDto(Long idComentarioDto) {
		this.idComentarioDto = idComentarioDto;
	}


	public String getDescripcionComentario() {
		return descripcionComentario;
	}


	public void setDescripcionComentario(String descripcionComentario) {
		this.descripcionComentario = descripcionComentario;
	}


	public Date getFechaComentario() {
		return fechaComentario;
	}


	public void setFechaComentario(Date fechaComentario) {
		this.fechaComentario = fechaComentario;
	}


	public Long getIdTareaComentario() {
		return idTareaComentario;
	}


	public void setIdTareaComentario(Long idTareaComentario) {
		this.idTareaComentario = idTareaComentario;
	}


	public Long getIdUsuarioComentario() {
		return idUsuarioComentario;
	}


	public void setIdUsuarioComentario(Long idUsuarioComentario) {
		this.idUsuarioComentario = idUsuarioComentario;
	}
	
	
	
}
