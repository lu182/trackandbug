package edu.curso.java.trackandbug.rest;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



import edu.curso.java.trackandbug.bo.EstadoTarea;
import edu.curso.java.trackandbug.bo.Proyecto;
import edu.curso.java.trackandbug.service.*;

         ////////////////////////////////////API REST ///////////////////////////////////////////////////

@RestController 
@RequestMapping("/estados-tareas") //defino la URL base
public class EstadoTareaRestController {

	//GET-POST-PUT-DELETE + Inyeccion de dependencias de las interfaces de servicios
	
	@Autowired
	EstadoTareaService estadoTareaService;
	
	@Autowired 
	TareaService tareaService;
	
	
	@GetMapping(path = "/")   //http://localhost:8085/estados-tareas/  devuelve todos
	public ResponseEntity<List<EstadoTareaDTO>> buscarEstadosTarea(){
		
		List<EstadoTarea> estadosTarea = estadoTareaService.buscarEstadosTareas();	
		List<EstadoTareaDTO> estadosTareaDTO = new ArrayList<EstadoTareaDTO>(); //recupero el listado
		for (EstadoTarea ep : estadosTarea) { 
			estadosTareaDTO.add(new EstadoTareaDTO(ep));
		}
		
		return ResponseEntity.ok(estadosTareaDTO);
	}
	
	
	//GET   http://localhost:8085/estados-tareas/1
		@GetMapping(path = "/{idEstadoTarea}") 
		public ResponseEntity<EstadoTareaDTO> buscarEstadoPorId(@PathVariable Long idEstadoTarea){
			
			EstadoTarea estadoTarea = estadoTareaService.buscarEstadoTareaPorId(idEstadoTarea);  
			EstadoTareaDTO estadoTareaDTO = new EstadoTareaDTO(estadoTarea);
			return ResponseEntity.ok(estadoTareaDTO);
			
			
		}
	
	
	//POST  http://localhost:8085/estados-tareas + Headers (Accept-applicationJson | Content-Type-applicationJson) + Body raw
	@PostMapping	
	public ResponseEntity<EstadoTareaDTO> guardarEstadoTarea(@Valid @RequestBody EstadoTareaDTO estadoTareaDTO){
		
		EstadoTarea estadoTarea = new EstadoTarea();
		estadoTarea.setIdEstadoTarea(estadoTareaDTO.getIdEstadoTarea());
		estadoTarea.setNombreEstadoTarea(estadoTareaDTO.getNombreEstadoTarea());
				
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoTareaDTO); //tiene que devolver un objeto
		
	}	
		
		

	
	
	
	
}
