package edu.curso.java.trackandbug.bo;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "COMENTARIOS")
public class Comentario {
	
	@Id  
	@GeneratedValue
	private Long idComentario;
	
	@Column(nullable = false, length = 500)
	private String descripcion;
	
	private Date fecha = new Date();
	
	@ManyToOne
	private Usuario usuario; //fk
	
	@ManyToOne
	private Tarea tarea; //fk

	
	//GETTERS & SETTERS:
	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idComentario == null) ? 0 : idComentario.hashCode());
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
		Comentario other = (Comentario) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idComentario == null) {
			if (other.idComentario != null)
				return false;
		} else if (!idComentario.equals(other.idComentario))
			return false;
		return true;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
