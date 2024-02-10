package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void actualizarParcial(String nombre, String apellido, Integer id);

	public EstudianteTO buscar(Integer id);

	public List<Estudiante> buscarTodos(String gen);

	public List<EstudianteTO> buscarTodosTO();

	public void borrar(Integer id);

}
