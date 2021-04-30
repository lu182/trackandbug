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


import edu.curso.java.trackandbug.bo.Proyecto;

import edu.curso.java.trackandbug.service.*;

       ////////////////////////////////////API REST ///////////////////////////////////////////////////

@RestController 
@RequestMapping("/proyectos") //defino la URL base
public class ProyectoRestController {

	//GET-POST-PUT-DELETE + Inyeccion de dependencias de las interfaces de servicios
	
	@Autowired 
	ProyectoService proyectoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	TareaService tareaService;
	
	
	//GET
	@GetMapping(path = "/{id}")       //http://localhost:8085/proyectos/123
public ResponseEntity<ProyectoDTO> buscarProyectoPorId(@PathVariable Long id){
		
		Proyecto proyecto = proyectoService.buscarProyectoPorId(id); //Le paso al proyectoService el id del elemento q quiero buscar
		ProyectoDTO proyectoDTO = new ProyectoDTO(proyecto); //lo transformo en DTO 		
		return ResponseEntity.ok(proyectoDTO); //y devuelve un objetoDTO a partir del proyecto q yo le paso	
		
	}
	
	//GET
	@GetMapping(path = "/")   //http://localhost:8085/proyectos/ --> FUNCIONA OK -- 200 OK. Me va a traer los dos proyectos (devuelve una coleccion). 
	public ResponseEntity<List<ProyectoDTO>> buscarProyectos(){
		
		List<Proyecto> proyectos = proyectoService.buscarProyectos();		
		List<ProyectoDTO> proyectosDTO = new ArrayList<ProyectoDTO>(); //recupero el listado
		for (Proyecto p : proyectos) { 
			proyectosDTO.add(new ProyectoDTO(p));
		}
		
		return ResponseEntity.ok(proyectosDTO);
	}
	
	
	//GET	
	@GetMapping(path = "/buscador")   //http://localhost:8085/proyectos/buscador?nombre=Prueba --FUNCIONA OK - 200 OK
	public ResponseEntity<List<ProyectoDTO>> buscadorDeProyectos(@RequestParam String nombre){
		
		List<Proyecto> proyectos = proyectoService.buscadorDeProyectos(nombre);
		List<ProyectoDTO> proyectosDTO = new ArrayList<ProyectoDTO>();
		for (Proyecto p : proyectos) { 
			proyectosDTO.add(new ProyectoDTO(p));
		}
		
		return ResponseEntity.ok(proyectosDTO);
		
	}
	
	
	//POST	
	@PostMapping //http://localhost:8085/proyectos + Headers (Accept-applicationJson | Content-Type-applicationJson) + Body raw ----> FUNCIONA OK 201 Created
	public ResponseEntity<ProyectoDTO> guardarProyecto(@RequestBody ProyectoDTO proyectoDTO){		
			
		   Proyecto proyecto = new Proyecto();
		   proyecto.setNombre(proyectoDTO.getNombre());
		   proyecto.setHorasTotales(proyecto.getHorasTotales());
		 		   
	       proyectoService.guardarProyecto(proyecto);		  
	
	       return ResponseEntity.status(HttpStatus.CREATED).body(proyectoDTO);
	}
		
	//PUT
	//ACTUALIZAR //Para hacer PUT podes combinar @PathVariable Long id (para enviarle el id por Url) y @RequestBody para enviarle el dato/los datos por el BODY.
	@PutMapping(path = "/{id}")	 // http://localhost:8085/proyectos/123 + Header + Body  --FUNCIONA OK -- devuelve 204 No Content
	public ResponseEntity actualizarProyecto(@PathVariable Long id, @RequestBody ProyectoDTO proyectoDTO) {
		
		   Proyecto proyecto = new Proyecto();
		   proyecto.setNombre(proyectoDTO.getNombre());
		   proyecto.setHorasTotales(proyecto.getHorasTotales());
		 		   
	       proyectoService.actualizarProyecto(proyecto);		  
	
	       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	      
	}
	
	//DELETE
	@DeleteMapping(path = "/{id}") //http://localhost:8085/proyectos/123   --FUNCIONA OK -- devuelve 204 No Content
	public ResponseEntity borrarProyecto(@PathVariable Long id) {
		
		proyectoService.borrarProyecto(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	
	
	
}	
	
	

