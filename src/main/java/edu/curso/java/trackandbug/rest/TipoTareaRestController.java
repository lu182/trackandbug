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


import edu.curso.java.trackandbug.bo.TipoTarea;

import edu.curso.java.trackandbug.service.*;

         ////////////////////////////////////API REST ///////////////////////////////////////////////////

@RestController 
@RequestMapping("/tipos-tareas") //defino la URL base
public class TipoTareaRestController {

	//GET-POST-PUT-DELETE + Inyeccion de dependencias de las interfaces de servicios
	
}
