package edu.curso.java.trackandbug.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; 
import org.springframework.data.repository.query.Param;

import edu.curso.java.trackandbug.bo.Tarea;
import edu.curso.java.trackandbug.bo.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	//QUERYS
	
	
	@Query(value = "from Usuario u where u.nombreUsuario like :nombreUsuario")
	public List<Usuario> buscadorDeUsuarios(@Param("nombreUsuario") String nombre);
	
	
	
	
	
	
	
}
