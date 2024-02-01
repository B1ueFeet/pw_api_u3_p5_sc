package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProfesorRepo;
import com.example.demo.repository.modelo.Profesor;

@Service
public class ProfesorServiceImpl implements IprofesorService {

	@Autowired
	private IProfesorRepo profesorRepo;

	@Override
	public void guardar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.profesorRepo.insertar(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.profesorRepo.actualizar(profesor);
	}

	@Override
	public void actualizarParcial(String nombre, String apellido, Integer id) {
		// TODO Auto-generated method stub
		this.profesorRepo.actualizarParcial(nombre, apellido, id);
	}

	@Override
	public Profesor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.profesorRepo.seleccionar(id);
	}

	@Override
	public List<Profesor> buscarTodos(String gen) {
		// TODO Auto-generated method stub
		return this.profesorRepo.getAll(gen);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.profesorRepo.eliminar(id);
	}	

}
