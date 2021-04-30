package edu.curso.java.trackandbug.bo;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "TAREAS")
public class Tarea {
	
	@Id  
	@GeneratedValue
	private Long idTarea;
	

	private Integer horasAsignadas;
	
	@OneToMany //1 tarea muchos comentarios
	@JoinColumn(name = "TAREA_ID") ////nombre de la FK que quiero que me genere en la tabla Comentarios para hacer la unión y no se genere tabla intermedia
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	@ManyToOne
	private TipoTarea tipoTarea;
	
	@ManyToOne
	private EstadoTarea estadoTarea;
	
	@ManyToMany
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	
	//@ManyToOne  ---AGREGAR !!!!
	//private Proyecto proyecto;   + getters y setters
	
	
	
	//GETTERS & SETTERS:
	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}

	public Integer getHorasAsignadas() {
		return horasAsignadas;
	}

	public void setHorasAsignadas(Integer horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public TipoTarea getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(TipoTarea tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	public EstadoTarea getEstadoTarea() {
		return estadoTarea;
	}

	public void setEstadoTarea(EstadoTarea estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTarea == null) ? 0 : idTarea.hashCode());
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
		Tarea other = (Tarea) obj;
		if (idTarea == null) {
			if (other.idTarea != null)
				return false;
		} else if (!idTarea.equals(other.idTarea))
			return false;
		return true;
	}

	
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
