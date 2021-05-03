package edu.curso.java.trackandbug.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;


import edu.curso.java.trackandbug.bo.*;
import edu.curso.java.trackandbug.repository.*;

           /////////////////// CAPA DE NEGOCIO O SERVICIO (BUSINESS LOGIC LAYER)  //////////////////////////

@Service  
@Transactional(rollbackFor = Exception.class)
public class ProyectoServiceImp implements ProyectoService {

		
	@Autowired   //inyecto
	private ProyectoRepository proyectoRepository; //Llamo al ProyectoRepository para que me brinde métodos propios que hereda del CrudRepository + lo que haya hecho en el repository
	
	@Autowired
	private TareaRepository tareaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
		
	
	@Override
	public Proyecto buscarProyectoPorId(Long idProyecto) {		
		
		return proyectoRepository.findById(idProyecto).get();
	}

	@Override
	public List<Proyecto> buscarProyectos() { 
		
		return proyectoRepository.buscarProyectos();
		
		
		
	}
	
	@Override
	public List<Proyecto> buscadorDeProyectos(String nombre) { 
		
		return proyectoRepository.buscadorDeProyectos(nombre);
	}

		
	@Override
	public Long guardarProyecto(Proyecto proyecto) throws ProyectoException { 
		
		
		proyectoRepository.save(proyecto);		
		
			return proyecto.getIdProyecto();
		
	}

		
	@Override
	public void actualizarProyecto(Proyecto proyecto) { 
		
		proyectoRepository.save(proyecto);
		
		
	}

	@Override
	public void borrarProyecto(Long idProyecto) {  
		
		proyectoRepository.deleteById(idProyecto);
		
		
	}

	@Override  //todas las tareas de ese proyecto por id (muchas tareas 1 proyecto)  
	public List<Tarea> tareasProyectoPorId(Long idProyecto) {		
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get(); 
		List<Tarea> tareas = new ArrayList<Tarea>();
		for (Tarea t : proyecto.getTareasProyecto()) {
			tareas.add(t);
		}
		return tareas;	//devuelve lista de tareas de ese proyecto determinado
		
	}
	
	
		 //Asignar usuarios a un proyecto/los proyectos 
	@Override
	public void agregarUsuarioProyecto(Long idProyecto, Long idUsuario) {  
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		proyecto.getUsuarios().add(usuario);
		usuario.getProyectos().add(proyecto);
		proyectoRepository.save(proyecto);
		usuarioRepository.save(usuario);
	
	}
	
	@Override
	public Integer consultarHorasTotalesProyecto(Long idProyecto) {  
		
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		Integer horas = proyecto.getHorasTotales();
				
		return horas;
	}

	@Override
	public void asignarTareaAlProyecto(Long idProyecto, Long idTarea) {
		
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		Tarea tarea = tareaRepository.findById(idTarea).get();
		proyecto.getTareasProyecto();
		tarea.getProyectoTareas();
		proyectoRepository.save(proyecto);
		tareaRepository.save(tarea);
		
	}



	
	

		
	
	
	
	
}
