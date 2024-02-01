package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepo {

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void actualizarParcial(String nombre, String apellido, Integer id);

	public Estudiante seleccionar(Integer id);
	public List<Estudiante> getAll(String gen);

	public void eliminar(Integer id);

}
