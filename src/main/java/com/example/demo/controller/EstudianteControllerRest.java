package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

//API: proyecto en si
//Servicio -> Controller : mediante Clase Controller
//Metodos : Capacidades

@RestController // SERVICIO
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRest {

	@Autowired
	private IEstudianteService estudianteService;

	// CAPACIDADES

	@GetMapping
	// http://localhost:8080/API/v1.0/Matricula/estudiantes?gen=M
	public List<Estudiante> buscarTodos(@RequestParam(defaultValue = "M", required = false) String gen) {
		return this.estudianteService.buscarTodos(gen);
	}

	@GetMapping(path = "/{id}")
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	public Estudiante buscar(@PathVariable Integer id) {
		return this.estudianteService.buscar(id);
	}

	@PostMapping
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
