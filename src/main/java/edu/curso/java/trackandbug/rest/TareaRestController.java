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
import edu.curso.java.trackandbug.bo.Proyecto;
import edu.curso.java.trackandbug.bo.Tarea;
import edu.curso.java.trackandbug.bo.TipoTarea;
import edu.curso.java.trackandbug.service.*;

          ////////////////////////////////////API REST ///////////////////////////////////////////////////

@RestController 
@RequestMapping("/tareas") //defino la URL base
public class TareaRestController {

	//GET-POST-PUT-DELETE + Inyeccion de dependencias de las interfaces de servicios
	
	@Autowired 
	private TareaService tareaService;
	
	@Autowired
	private EstadoTareaService estadoTareaService;
	
	@Autowired
	private TipoTareaService tipoTareaService;
		
	@Autowired 
	private ProyectoService proyectoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	//GET   http://localhost:8085/tareas/1
	@GetMapping(path = "/{id}") 
	public ResponseEntity<TareaDTO> buscarTareaPorId(@PathVariable Long id){
		
		Tarea tarea = tareaService.buscarTareaPorId(id);
		TareaDTO tareaDTO = new TareaDTO(tarea);
		return ResponseEntity.ok(tareaDTO);
	}
	
	
	//GET  http://localhost:8085/tareas/
	@GetMapping(path = "/") 
	public ResponseEntity<List<TareaDTO>> buscarTareas(){
		
		Iterable<Tarea> tareas = tareaService.buscarTareas();
		List<TareaDTO> tareasDTO = new ArrayList<TareaDTO>();
		for (Tarea t : tareas) {
			tareasDTO.add(new TareaDTO(t));
		}
		return ResponseEntity.ok(tareasDTO);
	}
	
	
	//PUT //Asignar una tarea al proyecto | //http://localhost:8085/tareas/1/agregar-tarea/2
	@PutMapping(path = "/{idProyecto}/agregar-tarea/{idTarea}")   	
	 
	public ResponseEntity<Long> agregarTareaAlProyecto(@PathVariable Long idProyecto, @PathVariable Long idTarea){
		
		proyectoService.asignarTareaAlProyecto(idProyecto, idTarea);
		ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(idProyecto);
	}
	
	//PUT     http://localhost:8085/tareas/1/agregar-usuario/5
	@PutMapping(path = "/{idTarea}/agregar-usuario/{idUsuario}")
	public ResponseEntity <Long> asignarUsuario(@PathVariable Long idTarea ,@PathVariable Long idUsuario){
		
		tareaService.agregarUsuarioTarea(idTarea, idUsuario);
		ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return  ResponseEntity.ok(idTarea);
	}
	
	
	
			
	
	
}
