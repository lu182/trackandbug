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
	private String nombreUsuarioResponsable;
	
	//private Long idTarea;
	//private String nombreTarea; //las tareas no las llamo acá	
	//private UsuarioDTO usuarioDtoResponsable;	
	//private TareaDTO tareaDto; //pero si no llamamos las tareasDTO, como macheo "todas las tareas de ese proyecto por id" para el endpoint del RestController
	
	
	public ProyectoDTO() {
		
	};
	
	public ProyectoDTO(Proyecto p) {
		this.idProyectoDto = p.getIdProyecto();
		this.nombre = p.getNombre();
		this.horasProyecto = p.getHorasTotales();		
		Usuario usuario = p.getUsuarioResponsable(); 
			if(usuario != null) { //para que no se rompa la Api
				this.idUsuarioResponsable = usuario.getIdUsuario();
				this.nombreUsuarioResponsable = usuario.getNombreUsuario();
			}			
	}
	
	//GETTERS Y SETTERS:
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
