package edu.curso.java.trackandbug.bo;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "TIPOS_TAREAS")
public class TipoTarea {
	
	@Id  
	@GeneratedValue
	private Long idTipoTarea;
	
	//@Column(nullable = false, length = 200)
	private String nombreTipoTarea;

	
	//GETTERS & SETTERS
	public Long getIdTipoTarea() {
		return idTipoTarea;
	}

	public void setIdTipoTarea(Long idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	public String getNombreTipoTarea() {
		return nombreTipoTarea;
	}

	public void setNombreTipoTarea(String nombreTipoTarea) {
		this.nombreTipoTarea = nombreTipoTarea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoTarea == null) ? 0 : idTipoTarea.hashCode());
		result = prime * result + ((nombreTipoTarea == null) ? 0 : nombreTipoTarea.hashCode());
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
		TipoTarea other = (TipoTarea) obj;
		if (idTipoTarea == null) {
			if (other.idTipoTarea != null)
				return false;
		} else if (!idTipoTarea.equals(other.idTipoTarea))
			return false;
		if (nombreTipoTarea == null) {
			if (other.nombreTipoTarea != null)
				return false;
		} else if (!nombreTipoTarea.equals(other.nombreTipoTarea))
			return false;
		return true;
	}

	
	
	
	
	
}
