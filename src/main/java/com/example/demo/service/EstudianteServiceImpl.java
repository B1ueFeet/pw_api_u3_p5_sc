package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {
	@Autowired
	private IEstudianteRepo estudianteRepo;

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.actualizar(estudiante);
	}

	@Override
	public void actualizarParcial(String nombre, String apellido, Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepo.actualizarParcial(nombre, apellido, id);
	}

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepo.eliminar(id);
	}

	@Override
	public List<Estudiante> buscarTodos(String gen) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.getAll(gen);
	}

}
