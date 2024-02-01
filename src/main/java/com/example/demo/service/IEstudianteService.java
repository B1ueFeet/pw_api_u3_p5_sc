package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void actualizarParcial(String nombre, String apellido, Integer id);

	public Estudiante buscar(Integer id);

	public List<Estudiante> buscarTodos(String gen);

	public void borrar(Integer id);

}
