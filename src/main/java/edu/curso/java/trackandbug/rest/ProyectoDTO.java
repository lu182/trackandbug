package edu.curso.java.trackandbug.rest;


import java.util.ArrayList;
import java.util.List;

import javax.validation.*;
import javax.validation.constraints.NotBlank;


import edu.curso.java.trackandbug.bo.*;

public class ProyectoDTO {

	private Long idProyectoDto;
	
	@NotBlank(message = "Falta completar el nombre del proyecto")
	private String nombre;
	
	private Integer horasProyecto;
	
	private Long idUsuarioResponsable; 
	
	@NotBlank(message = "Falta completar el nombre del usuario responsable del proyecto")
	private String nombreUsuarioResponsable; 
	
	
	
	
	public ProyectoDTO() {
		
	};
	

	public ProyectoDTO(Proyecto p) {
		this.idProyectoDto = p.getIdProyecto();
		this.nombre = p.getNombre();		
		if(p.getUsuarioResponsable() != null) {
			this.idUsuarioResponsable =  p.getUsuarioResponsable().getIdUsuario();
			this.nombreUsuarioResponsable = p.getUsuarioResponsable().getNombreUsuario();
		}
		this.horasProyecto = p.getHorasTotales();
	}


	public Long getIdProyectoDto() {
		return idProyectoDto;
	}


	public void setIdProyectoDto(Long idProyectoDto) {
		this.idProyectoDto = idProyectoDto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getHorasProyecto() {
		return horasProyecto;
	}


	public void setHorasProyecto(Integer horasProyecto) {
		this.horasProyecto = horasProyecto;
	}


	public Long getIdUsuarioResponsable() {
		return idUsuarioResponsable;
	}


	public void setIdUsuarioResponsable(Long idUsuarioResponsable) {
		this.idUsuarioResponsable = idUsuarioResponsable;
	}


	public String getNombreUsuarioResponsable() {
		return nombreUsuarioResponsable;
	}


	public void setNombreUsuarioResponsable(String nombreUsuarioResponsable) {
		this.nombreUsuarioResponsable = nombreUsuarioResponsable;
	}
	


	
	
	
	
}
