package edu.curso.java.trackandbug.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.curso.java.trackandbug.bo.EstadoTarea;

import edu.curso.java.trackandbug.repository.EstadoTareaRepository;


@Service  
@Transactional
public class EstadoTareaServiceImp implements EstadoTareaService {

	@Autowired 
	private EstadoTareaRepository estadoTareaRepository;

	
	
	
	@Override
	public EstadoTarea buscarEstadoTareaPorId(Long idEstadoTarea) { 
		
		return estadoTareaRepository.findById(idEstadoTarea).get();
	}

	@Override
	public Iterable<EstadoTarea> buscarEstadosTareas() { 
		
		
		return estadoTareaRepository.findAll();
	}
	

	@Override
	public List<EstadoTarea> buscadorDeEstadosTareaPorNombre(String nombreEstadoTarea) { 
		
		return estadoTareaRepository.buscadorDeEstadosTareaPorNombre(nombreEstadoTarea);
	}

	

	
	
	
}
