package edu.curso.java.trackandbug.rest;

import javax.validation.*;

import edu.curso.java.trackandbug.bo.*;

public class TareaDTO {

	private Long idTareaDto;
	private String nombre;
	
	
	
	public Long getIdTareaDto() {
		return idTareaDto;
	}
	public void setIdTareaDto(Long idTareaDto) {
		this.idTareaDto = idTareaDto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	
	
}
