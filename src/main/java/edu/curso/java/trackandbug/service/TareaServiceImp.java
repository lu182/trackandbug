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
	public Tarea buscarTareaPorId(Long idTarea) { 
		
		return tareaRepository.findById(idTarea).get();
	}

	@Override
	public Iterable<Tarea> buscarTareas() {  
		
		return tareaRepository.findAll();
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
	public Long consultarHorasTotales(Long idTarea) {
		
		Long horas = tareaRepository.consultarHorasTotales(idTarea); 		
		
		return horas;
	}
	
	@Override   
	public List<Tarea> buscadorDeTareasPorTipo(Long idTarea, Long idTipoTarea) {
		
		return tareaRepository.buscadorDeTareasPorTipo(idTarea, idTipoTarea);
	}
	
	@Override
	public void agregarUsuarioTarea(Long idTarea, Long idUsuario) { 
		Tarea tarea = tareaRepository.findById(idTarea).get();
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
				
		for(Usuario u : tarea.getUsuarios()){
			if(u.getIdUsuario() == idUsuario){
				return;
			}
		}
		
		tarea.getUsuarios().add(usuario);
	    tareaRepository.save(tarea).getIdTarea();
	    
	}
	
	
	@Override
	public List<Tarea> buscadorDeTareasPorEstado(Long idTarea, Long idEstadoTarea) {
		
		return tareaRepository.buscadorDeTareasPorEstado(idTarea, idEstadoTarea);
		
		
	}
	
	
}
