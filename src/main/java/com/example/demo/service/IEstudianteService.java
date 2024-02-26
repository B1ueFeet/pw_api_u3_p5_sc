package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteLigeroTO;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {
	// CRUD
	// Create, Read, Uopdate, Delete
	public void guardar(Estudiante estudiante);

	public void guardarTO(EstudianteTO estudianteTO);

	public void actualizar(Estudiante estudiante);

	public void actualizarTO(EstudianteTO estudianteTO);

	public void actualizarParcial(String apellido, String nombre, Integer id);

	public Estudiante buscar(Integer id);

	public EstudianteTO buscarTO(Integer id);

	public List<Estudiante> buscarTodos(String genero);

	public List<EstudianteTO> buscarTodosTO();

	public void eliminar(Integer id);

	public EstudianteLigeroTO buscarLigero(Integer id);

}
