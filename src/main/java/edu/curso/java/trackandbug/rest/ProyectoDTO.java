package edu.curso.java.trackandbug.rest;


import java.util.ArrayList;
import java.util.List;

import javax.validation.*;
import javax.validation.constraints.NotBlank;


import edu.curso.java.trackandbug.bo.*;

public class ProyectoDTO {

	private Long idProyectoDto;
	
	@NotBlank(message = "Falta completar el nombre del proyecto")
	private String nombreProyecto;
	
	private Integer horasTotalesProyecto;
	
	private Long idUsuarioResponsable; 
	
		
	public ProyectoDTO() {
		
	};
	

	public ProyectoDTO(Proyecto p) {
		this.idProyectoDto = p.getIdProyecto();
		this.nombreProyecto = p.getNombre();
		this.horasTotalesProyecto = p.getHorasTotales();
		if(p.getUsuarioResponsable() != null) { //Si le pongo ==null, se rompe postman. 
			this.idUsuarioResponsable = p.getIdUsuarioResponsable(); //p.getUsuarioResponsable().getIdUsuario();
			
		}
		 
	}

	
	public Long getIdProyectoDto() {
		return idProyectoDto;
	}


	public void setIdProyectoDto(Long idProyectoDto) {
		this.idProyectoDto = idProyectoDto;
	}


	public String getNombreProyecto() {
		return nombreProyecto;
	}


	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}


	public Integer getHorasTotalesProyecto() {
		return horasTotalesProyecto;
	}


	public void setHorasTotalesProyecto(Integer horasTotalesProyecto) {
		this.horasTotalesProyecto = horasTotalesProyecto;
	}


	public Long getIdUsuarioResponsable() {
		return idUsuarioResponsable;
	}


	public void setIdUsuarioResponsable(Long idUsuarioResponsable) {
		this.idUsuarioResponsable = idUsuarioResponsable;
	}


	
	
	
	
}
