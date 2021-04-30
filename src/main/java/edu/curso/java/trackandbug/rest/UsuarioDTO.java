package edu.curso.java.trackandbug.rest;

import javax.validation.*;
import javax.validation.constraints.NotBlank;

import edu.curso.java.trackandbug.bo.*;

public class UsuarioDTO {

	private Long idUsuarioDto;
	
	@NotBlank(message = "Falta completar el nombre del usuario")
	private String nombreUsuarioDTO;

	
	
	public Long getIdUsuarioDto() {
		return idUsuarioDto;
	}

	public void setIdUsuarioDto(Long idUsuarioDto) {
		this.idUsuarioDto = idUsuarioDto;
	}

	public String getNombreUsuarioDTO() {
		return nombreUsuarioDTO;
	}

	public void setNombreUsuarioDTO(String nombreUsuarioDTO) {
		this.nombreUsuarioDTO = nombreUsuarioDTO;
	}
	
	
	
	
	
	

}
