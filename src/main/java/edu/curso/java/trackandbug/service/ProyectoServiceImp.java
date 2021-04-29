package edu.curso.java.trackandbug.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.curso.java.trackandbug.bo.*;
import edu.curso.java.trackandbug.repository.*;

           /////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////

@Service  
@Transactional
public class ProyectoServiceImp implements ProyectoService {

		
	@Autowired   //inyecto
	private ProyectoRepository proyectoRepository; //Llamo al ProyectoRepository para que me brinde métodos propios que hereda del CrudRepository + lo que haya hecho en el repository
	
	
	
	@Override
	public Proyecto buscarProyectoPorId(Long idProyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> buscarProyectos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> buscadorDeProyectos(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long guardarProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long guardarProyecto(Proyecto proyecto, Long idTarea, Long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarProyecto(Long idProyecto) {
		// TODO Auto-generated method stub
		
	}

}
