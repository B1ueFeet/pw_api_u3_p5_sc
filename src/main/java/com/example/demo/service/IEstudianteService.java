package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteDTO;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {

	public void guardar(EstudianteTO estudiante);

	public void actualizar(EstudianteTO estudiante);

	public void actualizarParcial(String nombre, String apellido, Integer id);

	public EstudianteDTO buscarDTO(Integer id);

	public EstudianteTO buscarTO(Integer id);

	public List<EstudianteDTO> buscarTodos(String gen);

	public void borrar(Integer id);

}
