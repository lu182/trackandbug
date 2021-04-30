package edu.curso.java.trackandbug.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import edu.curso.java.trackandbug.bo.EstadoTarea;

import edu.curso.java.trackandbug.repository.EstadoTareaRepository;
import edu.curso.java.trackandbug.rest.EstadoTareaDTO;

@Service  
@Transactional
public class EstadoTareaServiceImp implements EstadoTareaService {

	@Autowired EstadoTareaRepository estadoTareaRepository;

	
	
	
	@Override
	public EstadoTarea buscarEstadoTareaPorId(Long idEstadoTarea) {
		
		return estadoTareaRepository.findById(idEstadoTarea).get();
	}

	@Override
	public List<EstadoTarea> buscarEstadosTareas() {
		
		return estadoTareaRepository.buscarEstadosTareas();
	}

	@Override
	public EstadoTarea guardarEstadoTarea(Long idEstadoTarea, String nombreEstadoTarea) {
		EstadoTarea estadoTarea = estadoTareaRepository.findById(idEstadoTarea).get();
		estadoTarea.setIdEstadoTarea(idEstadoTarea);
		estadoTarea.setNombreEstadoTarea(nombreEstadoTarea);
		
		estadoTareaRepository.save(estadoTarea);
		return estadoTarea;
	}

	
	
	
	
	
}
