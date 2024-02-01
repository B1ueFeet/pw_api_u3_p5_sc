package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Profesor;

public interface IProfesorRepo {

	public void insertar(Profesor profesor);

	public void actualizar(Profesor profesor);

	public void actualizarParcial(String nombre, String apellido, Integer id);

	public Profesor seleccionar(Integer id);

	public List<Profesor> getAll(String gen);

	public void eliminar(Integer id);
}
