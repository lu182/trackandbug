package edu.curso.java.trackandbug.rest;

import javax.validation.*;
import javax.validation.constraints.NotBlank;

import edu.curso.java.trackandbug.bo.*;

public class TipoTareaDTO {

	private Long idTipoTareaDto;
	
	@NotBlank(message = "Falta asignarle un nombre al tipo de tarea")
	private String nombreTipoTarea;
	
	
	public TipoTareaDTO(){
		
	}
	
	
	public TipoTareaDTO(TipoTarea tt){
		
		this.idTipoTareaDto = tt.getIdTipoTarea();
		this.nombreTipoTarea = tt.getNombreTipoTarea();
	}


	public Long getIdTipoTarea() {
		return idTipoTareaDto;
	}


	public void setIdTipoTarea(Long idTipoTarea) {
		this.idTipoTareaDto = idTipoTarea;
	}


	public String getNombreTipoTarea() {
		return nombreTipoTarea;
	}


	public void setNombreTipoTarea(String nombreTipoTarea) {
		this.nombreTipoTarea = nombreTipoTarea;
	}
	
	
	
}
