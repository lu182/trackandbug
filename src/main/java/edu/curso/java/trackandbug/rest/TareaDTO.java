package edu.curso.java.trackandbug.rest;

import javax.validation.*;
import javax.validation.constraints.NotBlank;


import edu.curso.java.trackandbug.bo.*;

public class TareaDTO {

	private Long idTareaDto;
	
	@NotBlank(message = "Falta asignar horas a la tarea")
	private Integer horasAsignadasTarea;
	
	private Long idEstadoTarea;
	
	private Long idTipoTarea;
	
	private Long idProyectoTarea; 
	
	
	public TareaDTO() {
		
	}
	
	public TareaDTO(Tarea t) {
		this.idTareaDto = t.getIdTarea();
		this.horasAsignadasTarea = t.getHorasAsignadas();
		EstadoTarea estadoTarea = t.getEstadoTarea();
		if(estadoTarea != null) {
			this.idEstadoTarea = estadoTarea.getIdEstadoTarea();
		}		
		TipoTarea tipoTarea = t.getTipoTarea();
		if(tipoTarea != null) {
			this.idTipoTarea = tipoTarea.getIdTipoTarea();
		}
		Proyecto proyecto = t.getProyectoTareas();
		if(proyecto != null) {
			this.idProyectoTarea = proyecto.getIdProyecto();
		}
		
	}

	

	public Long getIdTareaDto() {
		return idTareaDto;
	}

	public void setIdTareaDto(Long idTareaDto) {
		this.idTareaDto = idTareaDto;
	}

	public Integer getHorasAsignadasTarea() {
		return horasAsignadasTarea;
	}

	public void setHorasAsignadasTarea(Integer horasAsignadasTarea) {
		this.horasAsignadasTarea = horasAsignadasTarea;
	}

	public Long getIdEstadoTarea() {
		return idEstadoTarea;
	}

	public void setIdEstadoTarea(Long idEstadoTarea) {
		this.idEstadoTarea = idEstadoTarea;
	}

	public Long getIdTipoTarea() {
		return idTipoTarea;
	}

	public void setIdTipoTarea(Long idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	public Long getIdProyectoTarea() {
		return idProyectoTarea;
	}

	public void setIdProyectoTarea(Long idProyectoTarea) {
		this.idProyectoTarea = idProyectoTarea;
	}
	
	
	

	
	
	
	
}
