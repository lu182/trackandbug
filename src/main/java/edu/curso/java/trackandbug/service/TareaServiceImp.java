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
	private TareaRepository tareaRepository; //Llamo al TareaRepository para que me brinde métodos propios que hereda del CrudRepository + lo que haya hecho en el repository

	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	
	@Override
	public Tarea buscarTareaPorId(Long idTarea) {
		
		return tareaRepository.findById(idTarea).get();
	}

	@Override
	public List<Tarea> buscarTareas() {
		
		return tareaRepository.buscarTareas();
	}

		@Override
	public Long guardarTarea(Tarea tarea) {
		
		tareaRepository.save(tarea);
		return tarea.getIdTarea();
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

	@Override    //FALTA COMPLETAR (La query ya esta hecha en el TareaRepository)
	public List<Tarea> buscadorDeTareasPorTipo(Long idTarea, Long idTipoTarea) {
		
		return null; //return tareaRepository.buscadorDeTareasPorTipo(idTarea, idTipoTarea);
	}
	
	
	@Override //FALTA COMPLETAR(La query ya esta hecha en el TareaRepository)
	public List<Tarea> buscadorDeTareasPorEstado(Long idTarea, Long idEstadoTarea) {
		
		return null; ////return tareaRepository.buscadorDeTareasPorEstado(idTarea, idEstadoTarea);
	}
	
	
	
	
	
	
	
}
