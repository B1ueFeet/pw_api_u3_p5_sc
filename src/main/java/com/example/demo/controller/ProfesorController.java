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
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Profesor profesor) {
		this.profesorService.guardar(profesor);
	}

	@GetMapping(path = "/buscar/{id}")
	// http://localhost:8080/API/v1.0/Matricula/profesor/buscar/1
	public Profesor buscar(@PathVariable Integer id) {
		return this.profesorService.buscar(id);
	}

	@PutMapping(path = "/actualizar")
	// http://localhost:8080/API/v1.0/Matricula/profesor/actualizar
	public void actualizar(@RequestBody Profesor profesor) {
		this.profesorService.actualizar(profesor);
	}

	@PatchMapping(path = "/actualizar/parcial")
	// http://localhost:8080/API/v1.0/Matricula/profesor/actualizar/parcial
	public void actualizarParcial(@RequestBody Profesor profesor) {
		this.profesorService.actualizarParcial(profesor.getNombre(), profesor.getApellido(), profesor.getId());
	}

	@DeleteMapping(path = "/eliminar/{id}")
	// http://localhost:8080/API/v1.0/Matricula/profesor/eliminar/1
	public void eliminar(@PathVariable Integer id) {
		this.profesorService.borrar(id);
	}

	@GetMapping(path = "/buscar/todos")
	// http://localhost:8080/API/v1.0/Matricula/profesor/buscar/todos?gen=M
	public List<Profesor> buscarTodos(@RequestParam String gen) {
		return this.profesorService.buscarTodos(gen);
	}
}
