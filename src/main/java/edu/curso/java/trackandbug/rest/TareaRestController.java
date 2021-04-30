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
	TareaService tareaService;
	
	@Autowired 
	ProyectoService proyectoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	EstadoTareaService estadoTareaService;
	
	@Autowired
	TipoTareaService tipoTareaService;
	
	
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
		
		List<Tarea> tareas = tareaService.buscarTareas();
		List<TareaDTO> tareasDTO = new ArrayList<TareaDTO>();
		for (Tarea t : tareas) {
			tareasDTO.add(new TareaDTO(t));
		}
		return ResponseEntity.ok(tareasDTO);
	}
	
	
	//POST 
	@PostMapping(path = "/{idProyecto}/tareas")   //Le paso/le envío las variables por la URL 
	
	//podes combinar @PathVariable Long idProyecto (para enviarle el id por Url) y @RequestBody para enviarle el dato/los datos por el BODY.
	 //http://localhost:8085/proyectos/1/idTarea ó body raw de tareaDto???????  
	public ResponseEntity<TareaDTO> guardarTarea(@PathVariable Long idProyecto, @RequestBody TareaDTO tareaDTO){
		
		Tarea tarea = new Tarea();
		tarea.setHorasAsignadas(tareaDTO.getHorasAsignadasTarea());
		tareaService.guardarTarea(tarea);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tareaDTO);
	}
			
	
	
	
	
	
}
