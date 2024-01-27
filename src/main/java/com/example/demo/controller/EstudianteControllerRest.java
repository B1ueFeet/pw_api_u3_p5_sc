package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping(path = "/buscar")
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	public Estudiante buscar() {
		
		return this.estudianteService.buscar(1);
	}
}
