package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

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

	@Override
	public List<EstudianteTO> buscarTodosTO() {
		var lista = this.estudianteRepo.getAllTO();

		List<EstudianteTO> listaTO = new ArrayList<>();
		for (Estudiante estu : lista) {
			listaTO.add(this.convert(estu));
		}
		return listaTO;
	}

	private EstudianteTO convert(Estudiante est) {
		EstudianteTO estTO = new EstudianteTO();
		estTO.setApellido(est.getApellido());
		estTO.setFechaNacimiento(est.getFechaNacimiento());
		estTO.setGenero(est.getGenero());
		estTO.setNombre(est.getNombre());
		estTO.setId(est.getId());
		return estTO;

	}

}
