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
import edu.curso.java.trackandbug.bo.Usuario;

import edu.curso.java.trackandbug.service.*;

           ////////////////////////////////////API REST ///////////////////////////////////////////////////

@RestController 
@RequestMapping("/usuarios") //defino la URL base
public class UsuarioRestController {
	
	//GET-POST-PUT-DELETE + Inyeccion de dependencias de las interfaces de servicios
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ComentarioService comentarioService;
	
	
	//GET  http://localhost:8085/usuarios/ -- FUNCIONA OK
		@GetMapping(path = "/") 
		public ResponseEntity<List<UsuarioDTO>> buscarUsuarios(){
			
			Iterable<Usuario> usuarios = usuarioService.buscarUsuarios();
			List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
			for (Usuario u : usuarios) {
				usuariosDTO.add(new UsuarioDTO(u));
			}
			return ResponseEntity.ok(usuariosDTO);
		}
		
		
		//GET
		@GetMapping(path = "/{idUsuario}")    //http://localhost:8085/usuarios/1
		public ResponseEntity<UsuarioDTO> buscarUsuariosPorId(@PathVariable Long idUsuario){
			
			Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
			UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
			return ResponseEntity.ok(usuarioDTO);
		}
		
		//GET   http://localhost:8085/usuarios/buscador?nombre=Luciana
		@GetMapping(path = "/buscador") 
		public ResponseEntity<List<UsuarioDTO>> buscadorDeUsuariosPorNombre(@RequestParam String nombre){
			
			List<Usuario> usuarios = usuarioService.buscadorDeUsuarios(nombre);
			List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
			for (Usuario u : usuarios) {
				usuariosDTO.add(new UsuarioDTO(u));
			}
			
			return ResponseEntity.ok(usuariosDTO);
		}
		
		
		
		//POST  - FUNCIONA OK
		@PostMapping          //http://localhost:8085/usuarios + Headers (Accept-applicationJson | Content-Type-applicationJson) + Body raw 
		public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO){
			
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(usuarioDTO.getIdUsuarioDto());
			usuario.setNombreUsuario(usuarioDTO.getNombreUsuarioDTO());
			usuario.setUsuarioResponsable(usuario);
						
			try {
				Long idGenerado = usuarioService.guardarUsuario(usuario);
				usuarioDTO.setIdUsuarioDto(idGenerado);
				
				return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
				
			} catch (Exception e) {
				
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e); 
							
			}
			
		}
		
			
		
			
		
		
}
