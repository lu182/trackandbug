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
	
	@ManyToOne //1 tarea tiene un estado
	private EstadoTarea estadoTarea;
	
	@ManyToMany //1 tarea o muchas tareas tienen muchos usuarios
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	//1 tarea o muchas tareas tienen un proyecto
	@ManyToOne  
	private Proyecto proyectoTareas;  
	
	
	

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

	public Proyecto getProyectoTareas() {
		return proyectoTareas;
	}

	public void setProyectoTareas(Proyecto proyectoTareas) {
		this.proyectoTareas = proyectoTareas;
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
