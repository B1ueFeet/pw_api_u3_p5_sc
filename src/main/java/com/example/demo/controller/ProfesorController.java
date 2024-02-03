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

import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.IprofesorService;

@RestController // SERVICIO
@RequestMapping(path = "/profesores")
public class ProfesorController {
	@Autowired
	private IprofesorService profesorService;

	// CAPACIDADES

	@GetMapping
	// http://localhost:8080/API/v1.0/Matricula/profesores?gen=M
	public List<Profesor> buscarTodos(@RequestParam(defaultValue = "M", required = false)String gen) {
		return this.profesorService.buscarTodos(gen);
	}
	
	@GetMapping(path = "/{id}")
	// http://localhost:8080/API/v1.0/Matricula/profesores/1
	public Profesor buscar(@PathVariable Integer id) {
		return this.profesorService.buscar(id);
	}

	@PostMapping
	// http://localhost:8080/API/v1.0/Matricula/profesores
	public void guardar(@RequestBody Profesor profesor) {
		this.profesorService.guardar(profesor);
	}

	@PutMapping(path = "/{id}")
	// http://localhost:8080/API/v1.0/Matricula/profesores/i
	public void actualizar(@RequestBody Profesor profesor, @PathVariable Integer id) {
		this.profesorService.actualizar(profesor);
	}

	@PatchMapping(path = "/{id}")
	// http://localhost:8080/API/v1.0/Matricula/profesores/1
	public void actualizarParcial(@RequestBody Profesor profesor, @PathVariable Integer id) {
		this.profesorService.actualizarParcial(profesor.getNombre(), profesor.getApellido(), id);
	}

	@DeleteMapping(path = "/{id}")
	// http://localhost:8080/API/v1.0/Matricula/profesores/1
	public void eliminar(@PathVariable Integer id) {
		this.profesorService.borrar(id);
	}

}
