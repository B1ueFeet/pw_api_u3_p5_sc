package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

//API: proyecto en si
//Servicio -> Controller : mediante Clase Controller
//Metodos : Capacidades

@RestController // SERVICIO
@RequestMapping(path = "/estudiantes")
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

	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE, path = "/temp")
	// http://localhost:8080/API/v1.0/Matricula/estudiantes
	public ResponseEntity<List<EstudianteTO>> buscarTodosHateoas() {
		List<EstudianteTO> lista = this.estudianteService.buscarTodosTO();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	// http://localhost:8080/API/v1.0/Matricula/estudiantes?gen=M
	public ResponseEntity<List<Estudiante>> buscarTodos(
			@RequestParam(defaultValue = "M", required = false) String gen) {
		List<Estudiante> lista = this.estudianteService.buscarTodos(gen);

		HttpHeaders cabecera = new HttpHeaders();

		cabecera.add("mensaje_242", "Lista consultada con filtros de manera satisfactoria");

		return new ResponseEntity<>(lista, cabecera, 242);
	}

	@GetMapping(path = "/{id}", produces = "application/xml")
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	public ResponseEntity<Estudiante> buscar(@PathVariable Integer id) {

		Estudiante est = this.estudianteService.buscar(id);
		return ResponseEntity.status(250).body(est);
	}

	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	// http://localhost:8080/API/v1.0/Matricula/estudiantes
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@PutMapping(path = "/{id}")
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
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
