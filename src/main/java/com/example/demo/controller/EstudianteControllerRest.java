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
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@GetMapping(path = "/buscar/{id}")
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/1
	public Estudiante buscar(@PathVariable Integer id) {
		return this.estudianteService.buscar(id);
	}

	@PutMapping(path = "/actualizar")
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	public void actualizar(@RequestBody Estudiante estudiante) {
		this.estudianteService.actualizar(estudiante);
	}

	@PatchMapping(path = "/actualizar/parcial")
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/parcial
	public void actualizarParcial(@RequestBody Estudiante estudiante) {
		this.estudianteService.actualizarParcial(estudiante.getNombre(), estudiante.getApellido(), estudiante.getId());
	}

	@DeleteMapping(path = "/eliminar/{id}")
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/eliminar/1
	public void eliminar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
	}

	@GetMapping(path = "/buscar/todos")
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/todos?gen=M
	public List<Estudiante> buscarTodos(@RequestParam String gen) {
		return this.estudianteService.buscarTodos(gen);
	}

}
