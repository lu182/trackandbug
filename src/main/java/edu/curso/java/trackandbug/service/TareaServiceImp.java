package edu.curso.java.trackandbug.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.curso.java.trackandbug.bo.*;
import edu.curso.java.trackandbug.repository.*;
import edu.curso.java.trackandbug.rest.TareaDTO;

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
	
	@Autowired EstadoTareaRepository estadoTareaRepository;
	
	@Autowired TipoTareaRepository tipoTareaRepository;
	
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
	public Long guardarTareaConProyecto(Tarea tarea, Long idProyecto) throws ProyectoException {
		
		tareaRepository.save(tarea);
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		Integer horasDisponibles = proyecto.getHorasTotales() - tarea.getHorasAsignadas();
		if(horasDisponibles <= 0 ) 
			throw new ProyectoException("Atención!: Las horas de la tarea son superiores a las horas del proyecto");
			proyecto.setHorasTotales(horasDisponibles);		
		
		return tareaRepository.save(tarea).getIdTarea();
	}

	@Override
	public Long guardarTareaConTipoYEstado(Tarea tarea, Long idTipoTarea, Long idEstadoTarea) {
		
		TipoTarea tipoTarea = tipoTareaRepository.findById(idTipoTarea).get();
		EstadoTarea estadoTarea = estadoTareaRepository.findById(idEstadoTarea).get();
		tarea.setTipoTarea(tipoTarea);
		tarea.setEstadoTarea(estadoTarea);
		
		tareaRepository.save(tarea);
		
		return tarea.getIdTarea();
	}

	@Override
	public TareaDTO altaTarea(Long idProyecto, Integer horasAsignadasTarea, Long idTipoTarea, Long idEstadoTarea) {
		
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		TareaDTO tareaR;
		if((proyecto.getHorasTotales() - horasAsignadasTarea) >= 0) {
			TipoTarea tipoTarea = tipoTareaRepository.findById(idTipoTarea).get();
			EstadoTarea estadoTarea = estadoTareaRepository.findById(idEstadoTarea).get();
			Tarea tarea = new Tarea();
			tareaR = new TareaDTO(tarea);
			tarea.setHorasAsignadas(horasAsignadasTarea);
			tarea.setEstadoTarea(estadoTarea);
			tarea.setTipoTarea(tipoTarea);
			tarea.setProyectoTareas(proyecto);
			proyecto.setHorasTotales(proyecto.getHorasTotales() - tarea.getHorasAsignadas());
			proyectoRepository.save(proyecto);	
			tarea.setProyectoTareas(proyecto);
			tareaRepository.save(tarea);
		}else {
			
			tareaR = null;
		}
		
		return tareaR;
	}
	
	
	
	
	
	
	
	
	
	
}
