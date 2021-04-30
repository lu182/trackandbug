package edu.curso.java.trackandbug.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.trackandbug.bo.EstadoTarea;
import edu.curso.java.trackandbug.bo.TipoTarea;

import edu.curso.java.trackandbug.repository.TipoTareaRepository;

@Service  
@Transactional
public class TipoTareaServiceImp implements TipoTareaService {

	@Autowired TipoTareaRepository tipoTareaRepository;
	
	
	@Override
	public TipoTarea buscarTipoTareaPorId(Long idTipoTarea) {
		
		return tipoTareaRepository.findById(idTipoTarea).get();
	}

	@Override
	public List<TipoTarea> buscarTiposTareas() {
		
		return tipoTareaRepository.buscarTiposTareas();
	}

	@Override
	public TipoTarea guardarTipoTarea(Long idTipoTarea, String nombreTipoTarea) {
		
		TipoTarea tipoTarea = tipoTareaRepository.findById(idTipoTarea).get();
		tipoTarea.setIdTipoTarea(idTipoTarea);
		tipoTarea.setNombreTipoTarea(nombreTipoTarea);
		
		tipoTareaRepository.save(tipoTarea);
		return tipoTarea;
	}

	
}
