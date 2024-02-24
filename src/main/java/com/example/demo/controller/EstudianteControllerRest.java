package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.EstudianteDTO;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

//API: proyecto en si
//Servicio -> Controller : mediante Clase Controller
//Metodos : Capacidades

@RestController // SERVICIO
@RequestMapping(path = "/estudiantes")
@CrossOrigin()
public class EstudianteControllerRest {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService materiaService;
	// CAPACIDADES

	// OBTENER LAS MATERIAS POR ESTUDIANTE
	@GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}/materias
	public ResponseEntity<List<MateriaTO>> consultarMateriasPorId(@PathVariable Integer id) {
		List<MateriaTO> lista = this.materiaService.buscarMateriasPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	// http://localhost:8080/API/v1.0/Matricula/estudiantes
	public ResponseEntity<List<EstudianteDTO>> buscarTodos(
			@RequestParam(defaultValue = "M", required = false) String gen) {
		List<EstudianteDTO> lista = this.estudianteService.buscarTodos(gen);
		for (EstudianteDTO est : lista) {
			est.add(linkTo(methodOn(EstudianteControllerRest.class).buscarCompleto(est.getId())).withSelfRel());
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	public ResponseEntity<EstudianteDTO> buscar(@PathVariable Integer id) {

		EstudianteDTO est = this.estudianteService.buscarDTO(id);
		est.add(linkTo(methodOn(EstudianteControllerRest.class).buscarCompleto(id)).withSelfRel());
		return ResponseEntity.status(250).body(est);
	}

	@GetMapping(path = "/{id}/info", produces = MediaType.APPLICATION_JSON_VALUE)
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	public ResponseEntity<EstudianteTO> buscarCompleto(@PathVariable Integer id) {

		EstudianteTO est = this.estudianteService.buscarTO(id);
		est.add(linkTo(methodOn(EstudianteControllerRest.class).consultarMateriasPorId(id)).withRel("materias"));
		return ResponseEntity.status(250).body(est);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	// http://localhost:8080/API/v1.0/Matricula/estudiantes
	public void guardar(@RequestBody EstudianteTO estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@PutMapping(path = "/{id}")
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	public void actualizar(@RequestBody EstudianteTO estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
	}

	@PatchMapping(path = "/{id}")
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		this.estudianteService.actualizarParcial(estudiante.getNombre(), estudiante.getApellido(), id);
	}

	@DeleteMapping(path = "/{id}")
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	public void eliminar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
	}
}
