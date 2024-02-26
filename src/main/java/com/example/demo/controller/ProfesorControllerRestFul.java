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

import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping(path = "/profesores")
public class ProfesorControllerRestFul {

	@Autowired
	private IProfesorService profesorService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody Profesor profesor) {
		this.profesorService.guardar(profesor);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Profesor>> consultarTodos(@RequestParam(required = false, defaultValue = "M") String genero) {
		List<Profesor> lista = this.profesorService.consultarTodos(genero);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_242", "Lista consultada de manera exitosa");
		return new ResponseEntity<>(lista, cabeceras, 242);
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Profesor> consultar(@PathVariable Integer id) {
		Profesor profesor = this.profesorService.consultar(id);
		return ResponseEntity.status(HttpStatus.OK).body(profesor);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Profesor profesor, @PathVariable Integer id) {
		profesor.setId(id);
		this.profesorService.actualizar(profesor);
	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarParcial(@RequestBody Profesor profesor, @PathVariable Integer id) {
		this.profesorService.actualizarParcial(profesor.getAsignatura(), id);
	}

	@DeleteMapping(path = "/{id}", consumes = MediaType.ALL_VALUE)
	public void eliminar(@PathVariable Integer id) {
		this.profesorService.borrar(id);
	}
}
