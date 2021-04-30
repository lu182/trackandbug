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
public class TareaServiceImp implements TareaService {

	@Autowired   //inyecto
	private TareaRepository tareaRepository; 

	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	
	@Override
	public Tarea buscarTareaPorId(Long idTarea) { //Ok en rest
		
		return tareaRepository.findById(idTarea).get();
	}

	@Override
	public List<Tarea> buscarTareas() {  //Ok en rest
		
		return tareaRepository.buscarTareas();
	}



	@Override
	public void actualizarTarea(Tarea tarea) {
		
		tareaRepository.save(tarea);
		
	}

	@Override
	public void borrarTarea(Long idTarea) {
		
		tareaRepository.deleteById(idTarea);
		
	}

	@Override
	public Integer consultarHorasTotales(Long idTarea) {
		
		Tarea tarea = tareaRepository.findById(idTarea).get();
		Integer horas = tarea.getHorasAsignadas();
		return horas;
	}

	@Override   
	public List<Tarea> buscadorDeTareasPorTipo(Long idTarea, Long idTipoTarea) {
		
		return tareaRepository.buscadorDeTareasPorTipo(idTarea, idTipoTarea);
	}
	
	
	@Override 
	public List<Tarea> buscadorDeTareasPorEstado(Long idTarea, Long idEstadoTarea) {
		
		return tareaRepository.buscadorDeTareasPorEstado(idTarea, idEstadoTarea);
	}

	@Override
	public Long guardarTarea(Tarea tarea, Long idProyecto) throws ProyectoException {
		
		tareaRepository.save(tarea);
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		Integer horasDisponibles = proyecto.getHorasTotales() - tarea.getHorasAsignadas();
		if(horasDisponibles <= 0 ) 
			throw new ProyectoException("Atención!: Las horas de la tarea son superiores a las horas del proyecto");
			proyecto.setHorasTotales(horasDisponibles);		
		
		return tareaRepository.save(tarea).getIdTarea();
		
	}

	@Override
	public void agregarTareaProyecto(Long idProyecto, Long idTarea) { //no es Long es VOID
		
		Proyecto proyecto = proyectoRepository.findById(idTarea).get();
		Tarea tarea = tareaRepository.findById(idTarea).get();
		proyecto.getTareasProyecto().add(tarea);
		//tarea.getProyectos().add(proyecto); //AGREGAR las tareas al proyectoooooooooooo!!!
		//proyectoRepository.save(proyecto);
		//tareaRepository.save(tarea);
		
	}
	
	@Override
	public void agregarTareaAlEstadoTarea(Long idEstadoTarea, Long idTarea) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarTareaAlTipoTarea(Long idTipoTarea, Long idTarea) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
}
