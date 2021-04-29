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

	
	
	@Override
	public Tarea buscarTareaPorId(Long idTarea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tarea> buscarTareas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tarea> buscadorDeTareas(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tarea> buscadorDeTareas(String nombre, Long idTipoTarea, Long idEstadoTarea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long guardarTarea(Tarea tarea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long guardarTarea(Tarea tarea, Long idTipoTarea, Long idEstadoTarea, Long idComentario, Long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarTarea(Tarea tarea) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarTarea(Long idTarea) {
		// TODO Auto-generated method stub
		
	}
	
	
}
