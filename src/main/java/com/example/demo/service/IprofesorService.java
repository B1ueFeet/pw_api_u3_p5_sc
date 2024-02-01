package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Profesor;

public interface IprofesorService {

	
	public void guardar(Profesor profesor);

	public void actualizar(Profesor profesor);

	public void actualizarParcial(String nombre, String apellido, Integer id);

	public Profesor buscar(Integer id);

	public List<Profesor> buscarTodos(String gen);

	public void borrar(Integer id);
}
