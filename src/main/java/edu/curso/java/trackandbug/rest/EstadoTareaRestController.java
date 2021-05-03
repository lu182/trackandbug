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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import edu.curso.java.trackandbug.bo.EstadoTarea;

import edu.curso.java.trackandbug.service.*;

         ////////////////////////////////////API REST ///////////////////////////////////////////////////

@RestController 
@RequestMapping("/estados-tareas") //defino la URL base
public class EstadoTareaRestController {

	//GET-POST-PUT-DELETE + Inyeccion de dependencias de las interfaces de servicios
	
	@Autowired
	private EstadoTareaService estadoTareaService;
	
		
	
	//GET
	@GetMapping(path = "/")   // http://localhost:8085/estados-tareas/  --->  devuelve todos ---FUNCIONA OK
		public ResponseEntity<List<EstadoTareaDTO>> buscarEstadosTarea(){
		
		Iterable<EstadoTarea> estadosTarea = estadoTareaService.buscarEstadosTareas();
		List<EstadoTareaDTO> estadosTareaDTO = new ArrayList<EstadoTareaDTO>(); 
		for (EstadoTarea et : estadosTarea) { 
			estadosTareaDTO.add(new EstadoTareaDTO(et));
		}
		
		return ResponseEntity.ok(estadosTareaDTO);
		
		}
	
	
	                              //http://localhost:8085/estados-tareas/1   --FUNCIONA OK
	//GET   
	@GetMapping(path = "/{idEstadoTarea}")  
		public ResponseEntity<EstadoTareaDTO> buscarEstadoPorId(@PathVariable Long idEstadoTarea){ 
			
			EstadoTarea estadoTarea = estadoTareaService.buscarEstadoTareaPorId(idEstadoTarea);  
			EstadoTareaDTO estadoTareaDTO = new EstadoTareaDTO(estadoTarea);
			return ResponseEntity.ok(estadoTareaDTO);
					
		}
	
			
	@GetMapping(path = "/buscador")   //http://localhost:8085/estados-tareas/buscador?nombre=ABIERTA --FUNCIONA OK
		public ResponseEntity<List<EstadoTareaDTO>> buscadorDeEstadosTareaPorNombre(@RequestParam String nombre){
		
		List<EstadoTarea> estadosTarea = estadoTareaService.buscadorDeEstadosTareaPorNombre(nombre);
		List<EstadoTareaDTO> estadosTareaDTO = new ArrayList<EstadoTareaDTO>();
		for (EstadoTarea et : estadosTarea) {
			
			estadosTareaDTO.add(new EstadoTareaDTO(et));
		}
		
		return ResponseEntity.ok(estadosTareaDTO);
		
	}
	
		
	
}
