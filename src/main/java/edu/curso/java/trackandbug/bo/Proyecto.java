package edu.curso.java.trackandbug.bo;

import javax.persistence.*;


import java.util.*;

@Entity
@Table(name = "PROYECTOS")
public class Proyecto {
	
	@Id  
	@GeneratedValue
	private Long idProyecto;
	
	@Column(nullable = false, length = 200) //No soporta nulos
	private String nombre;
	
	private Integer horasTotales; //horas asignadas
	
	
	@ManyToOne //varios proyectos un responsable, es el mismo usuario que va estar en varios proyectos --ok
	private Usuario usuarioResponsable; //fk dentro de la misma tabla -- 1 proyecto tiene 1 usuario responsable
	
	@OneToMany //1 proyecto tiene muchas tareas (fk_proyecto_id) - Una misma tarea va a tener muchos proyectos
	@JoinColumn(name = "PROYECTO_ID") //nombre de la FK que quiero que me genere en la tabla Tareas para hacer la unión y no se genere tabla intermedia
	private List<Tarea> tareasProyecto = new ArrayList<Tarea>(); 
	
	@ManyToMany //varios proyectos, varios usuarios
	private List<Usuario> usuarios = new ArrayList<Usuario>(); //fk -- 1 proyecto tiene varios usuarios/varios usuarios 1 proyecto
	

	
	
	//GETTERS & SETTERS:
	public Long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getHorasTotales() {
		return horasTotales;
	}

	public void setHorasTotales(Integer horasTotales) {
		this.horasTotales = horasTotales;
	}

	public Usuario getUsuarioResponsable() {
		return usuarioResponsable;
	}

	public void setUsuarioResponsable(Usuario usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}

	public List<Tarea> getTareasProyecto() {
		return tareasProyecto;
	}

	public void setTareasProyecto(List<Tarea> tareasProyecto) {
		this.tareasProyecto = tareasProyecto;
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
		result = prime * result + ((idProyecto == null) ? 0 : idProyecto.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Proyecto other = (Proyecto) obj;
		if (idProyecto == null) {
			if (other.idProyecto != null)
				return false;
		} else if (!idProyecto.equals(other.idProyecto))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	

	
	
	
	
}
