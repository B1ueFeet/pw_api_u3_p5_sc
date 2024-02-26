package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Profesor;

public interface IProfesorService {

	public void guardar(Profesor profesor);

	public void actualizar(Profesor profesor);

	public void actualizarParcial(String asignatura, Integer id);

	public Profesor consultar(Integer id);

	public List<Profesor> consultarTodos(String genero);

	public void borrar(Integer id);
}
