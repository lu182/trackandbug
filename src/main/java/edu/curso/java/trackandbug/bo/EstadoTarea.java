package edu.curso.java.trackandbug.bo;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ESTADOS_TAREAS")
public class EstadoTarea {

	@Id  
	@GeneratedValue
	private Long idEstadoTarea;
	
	//@Column(nullable = false, length = 200)
	private String nombreEstadoTarea;

	
	//GETTERS & SETTERS
	
	public Long getIdEstadoTarea() {
		return idEstadoTarea;
	}

	public void setIdEstadoTarea(Long idEstadoTarea) {
		this.idEstadoTarea = idEstadoTarea;
	}

	public String getNombreEstadoTarea() {
		return nombreEstadoTarea;
	}

	public void setNombreEstadoTarea(String nombreEstadoTarea) {
		this.nombreEstadoTarea = nombreEstadoTarea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEstadoTarea == null) ? 0 : idEstadoTarea.hashCode());
		result = prime * result + ((nombreEstadoTarea == null) ? 0 : nombreEstadoTarea.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoTarea other = (EstadoTarea) obj;
		if (idEstadoTarea == null) {
			if (other.idEstadoTarea != null)
				return false;
		} else if (!idEstadoTarea.equals(other.idEstadoTarea))
			return false;
		if (nombreEstadoTarea == null) {
			if (other.nombreEstadoTarea != null)
				return false;
		} else if (!nombreEstadoTarea.equals(other.nombreEstadoTarea))
			return false;
		return true;
	}
	
	
	
	
	
	
}
