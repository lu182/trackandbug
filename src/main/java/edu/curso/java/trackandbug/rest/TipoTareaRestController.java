package edu.curso.java.trackandbug.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import edu.curso.java.trackandbug.bo.EstadoTarea;
import edu.curso.java.trackandbug.bo.TipoTarea;

import edu.curso.java.trackandbug.service.*;

         ////////////////////////////////////API REST ///////////////////////////////////////////////////

@RestController 
@RequestMapping("/tipos-tareas") //defino la URL base
public class TipoTareaRestController {

	//GET-POST-PUT-DELETE + Inyeccion de dependencias de las interfaces de servicios
	
	@Autowired
	TipoTareaService tipoTareaService;
	
	@Autowired 
	TareaService tareaService;
	
	@Autowired
	EstadoTareaService estadoTareaService;
	
	
	@GetMapping(path = "/")   //http://localhost:8085/tipos-tareas/  devuelve todos
	public ResponseEntity<List<TipoTareaDTO>> buscarTipoTarea(){
		
		List<TipoTarea> tiposTarea = tipoTareaService.buscarTiposTareas();
		List<TipoTareaDTO> tiposTareaDTO = new ArrayList<TipoTareaDTO>(); 
		for (TipoTarea tt : tiposTarea) { 
			tiposTareaDTO.add(new TipoTareaDTO(tt));
		}
		
		return ResponseEntity.ok(tiposTareaDTO);
	}
	
	
	
	//GET  http://localhost:8085/tipos-tareas/1
	@GetMapping(path = "/{idTipoTarea}")
	public ResponseEntity<TipoTareaDTO> buscarTipoTareaPorId(@PathVariable Long idTipoTarea){
		
		TipoTarea tipoTarea = tipoTareaService.buscarTipoTareaPorId(idTipoTarea);
		TipoTareaDTO tipoTareaDTO = new TipoTareaDTO(tipoTarea);
		return ResponseEntity.ok(tipoTareaDTO);
	}
	
	//POST
	
	
	/*//POST  http://localhost:8085/estados-tareas + Headers (Accept-applicationJson | Content-Type-applicationJson) + Body raw
		@PostMapping	
		public ResponseEntity<EstadoTareaDTO> guardarEstadoTarea(@Valid @RequestBody EstadoTareaDTO estadoTareaDTO){
			
			EstadoTarea estadoTarea = new EstadoTarea();
			estadoTarea.setIdEstadoTarea(estadoTareaDTO.getIdEstadoTarea());
			estadoTarea.setNombreEstadoTarea(estadoTareaDTO.getNombreEstadoTarea());
					
			return ResponseEntity.status(HttpStatus.CREATED).body(estadoTareaDTO); //tiene que devolver un objeto
			
		}		
		*/
	
	
	
}
