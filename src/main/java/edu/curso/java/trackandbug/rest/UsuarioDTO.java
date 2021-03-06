package edu.curso.java.trackandbug.rest;

import javax.validation.*;
import javax.validation.constraints.NotBlank;

import edu.curso.java.trackandbug.bo.*;

public class UsuarioDTO {

	private Long idUsuarioDto;
	
	//@NotBlank(message = "Falta completar el nombre del usuario")
	private String nombreUsuarioDTO;

	private Long idUsuarioResponsableDto; 
	
	
	public UsuarioDTO(Usuario u) {
		this.idUsuarioDto = u.getIdUsuario();
		this.nombreUsuarioDTO = u.getNombreUsuario();
		Usuario usuario = u.getUsuarioResponsable();
		if(usuario != null) {
			this.idUsuarioResponsableDto = usuario.getUsuarioResponsable().getIdUsuario();
		}
		
	}
	
	public UsuarioDTO() {
		
	}

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

	public Long getIdUsuarioResponsableDto() {
		return idUsuarioResponsableDto;
	}

	public void setIdUsuarioResponsableDto(Long idUsuarioResponsableDto) {
		this.idUsuarioResponsableDto = idUsuarioResponsableDto;
	}	

	
	
	
	
	

}
