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
import edu.curso.java.trackandbug.bo.Tarea;

import edu.curso.java.trackandbug.service.*;

       ////////////////////////////////////API REST ///////////////////////////////////////////////////

@RestController 
@RequestMapping("/proyectos") //defino la URL base
public class ProyectoRestController {

	//GET-POST-PUT-DELETE + Inyeccion de dependencias de las interfaces de servicios
	
	@Autowired 
	private ProyectoService proyectoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TareaService tareaService;
	
	
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
	@GetMapping(path = "/{idProyecto}")       //http://localhost:8085/proyectos/123 --FUNCIONA OK
public ResponseEntity<ProyectoDTO> buscarProyectoPorId(@PathVariable Long idProyecto){
		
		Proyecto proyecto = proyectoService.buscarProyectoPorId(idProyecto); 
		ProyectoDTO proyectoDTO = new ProyectoDTO(proyecto);  		
		return ResponseEntity.ok(proyectoDTO); 
		
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
	
	
	//POST	-- FUNCIONA OK
	@PostMapping //http://localhost:8085/proyectos + Headers (Accept-applicationJson | Content-Type-applicationJson) + Body raw ----> FUNCIONA OK 201 Created
	public ResponseEntity<ProyectoDTO> guardarProyecto(@RequestBody ProyectoDTO proyectoDTO) throws ProyectoException{		
			//@Valid = 400 Bad Request si no le pones los datos requeridos
		
		   Proyecto proyecto = new Proyecto();
		   
		   proyecto.setNombre(proyectoDTO.getNombreProyecto());
		   proyecto.setHorasTotales(proyectoDTO.getHorasTotalesProyecto());
		   proyecto.setIdUsuarioResponsable(proyectoDTO.getIdUsuarioResponsable());
		   
		   try {
			   Long idGeneradoProyecto = proyectoService.guardarProyecto(proyecto);	
			   proyectoDTO.setIdProyectoDto(idGeneradoProyecto);			   
			   
			   return ResponseEntity.status(HttpStatus.CREATED).body(proyectoDTO); 
		       
		   }catch (ProyectoException e) {
			
			   throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		   }    
	       
	}	
	
			
	//PUT --- FUNCIONA OK
	//ACTUALIZAR //Para hacer PUT podes combinar @PathVariable Long id (para enviarle el id por Url) y @RequestBody para enviarle el dato/los datos por el BODY.
	@PutMapping(path = "/{id}")	 // http://localhost:8085/proyectos/123 + Header + Body  --FUNCIONA OK -- devuelve 204 No Content
	public ResponseEntity actualizarProyecto(@PathVariable Long id, @RequestBody ProyectoDTO proyectoDTO) {
		
		   Proyecto proyecto = new Proyecto();
		   proyecto.setNombre(proyectoDTO.getNombreProyecto());
		   proyecto.setHorasTotales(proyecto.getHorasTotales());
		 		   
	       proyectoService.actualizarProyecto(proyecto);		  
	
	       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	      
	}
	
	
	//DELETE
	@DeleteMapping(path = "/{id}") //http://localhost:8085/proyectos/22   --FUNCIONA OK -- devuelve 204 No Content
	public ResponseEntity borrarProyecto(@PathVariable Long id) {
		
		proyectoService.borrarProyecto(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	//GET  //  http://localhost:8085/proyectos/22/horas-totales ----200 OK 
		@GetMapping(path = "/{idProyecto}/horas-totales") 
		public ResponseEntity<Integer> consultarHorasTotalesProyecto(@PathVariable Long idProyecto){
			
			Integer horas = proyectoService.consultarHorasTotalesProyecto(idProyecto);
			
			return ResponseEntity.ok(horas);  
		}
		
			
	
	//PUT //Asignar un usuario al proyecto - http://localhost:8085/proyectos/22/agregar-usuario/1 
	@PutMapping(path = "/{idProyecto}/agregar-usuario/{idUsuario}") 
	public ResponseEntity<Long> agregarUsuarioProyecto(@PathVariable Long idProyecto, @PathVariable Long idUsuario){ 
		
		proyectoService.agregarUsuarioProyecto(idProyecto, idUsuario);
		
		ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.ok(idProyecto); // ----------------------- 200 OK 
	}
			
	//LISTAR TAREAS POR PROYECTO
	@GetMapping(path = "/{idProyecto}/listado-tareas") 
	public ResponseEntity<List<TareaDTO>> verTareasPorProyecto(@PathVariable Long idProyecto){
		
		List<Tarea> tareasPorProyecto = proyectoService.tareasProyectoPorId(idProyecto);
		List<TareaDTO> tareasDTO = new ArrayList<TareaDTO>();
		for (Tarea t : tareasPorProyecto) {
			tareasDTO.add(new TareaDTO(t));
		}
		
		
		return ResponseEntity.ok(tareasDTO);
	}
	

		
}
	
		
		
	

	

	
	

