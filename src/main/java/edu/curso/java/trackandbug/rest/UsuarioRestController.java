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
	UsuarioService usuarioService;
	
	
	//GET  http://localhost:8085/usuarios/ -- ver todos los usuarios
		@GetMapping(path = "/") 
		public ResponseEntity<List<UsuarioDTO>> buscarUsuarios(){
			
			List<Usuario> usuarios = usuarioService.buscarUsuarios();
			List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
			for (Usuario u : usuarios) {
				usuariosDTO.add(new UsuarioDTO(u));
			}
			return ResponseEntity.ok(usuariosDTO);
		}
		
		
		//POST
		@PostMapping          //http://localhost:8085/usuarios + Headers (Accept-applicationJson | Content-Type-applicationJson) + Body raw 
		public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO){
			
			Usuario usuario = new Usuario();
			usuario.setNombreUsuario(usuarioDTO.getNombreUsuarioDTO());
			
			usuarioService.guardarUsuario(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
			
		}
		
			
		
			
		
		
}
