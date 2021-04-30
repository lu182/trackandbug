package edu.curso.java.trackandbug.rest;

import javax.validation.*;
import javax.validation.constraints.NotBlank;

import edu.curso.java.trackandbug.bo.*;

public class EstadoTareaDTO {

	private Long idEstadoTareaDto;
	
	@NotBlank(message = "Falta asignarle un nombre al estado de la tarea")
	private String nombreEstadoTarea;
	
	
	
	
	public EstadoTareaDTO() {
		
	}
	
	
	public EstadoTareaDTO(EstadoTarea et) {
		
		this.idEstadoTareaDto = et.getIdEstadoTarea();
		this.nombreEstadoTarea = et.getNombreEstadoTarea();
	}


	
	
	public Long getIdEstadoTarea() {
		return idEstadoTareaDto;
	}


	public void setIdEstadoTarea(Long idEstadoTarea) {
		this.idEstadoTareaDto = idEstadoTarea;
	}


	public String getNombreEstadoTarea() {
		return nombreEstadoTarea;
	}


	public void setNombreEstadoTarea(String nombreEstadoTarea) {
		this.nombreEstadoTarea = nombreEstadoTarea;
	}
	
	
	
	
}
