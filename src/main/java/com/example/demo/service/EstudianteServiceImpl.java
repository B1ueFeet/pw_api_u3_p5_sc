package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteDTO;
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
	public EstudianteDTO buscarDTO(Integer id) {
		// TODO Auto-generated method stub
		return this.convertDTO(this.estudianteRepo.seleccionar(id));
	}

	@Override
	public EstudianteTO buscarTO(Integer id) {
		// TODO Auto-generated method stub
		return this.convertTO(this.estudianteRepo.seleccionar(id));
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepo.eliminar(id);
	}

	private EstudianteTO convertTO(Estudiante est) {
		EstudianteTO estTO = new EstudianteTO();
		estTO.setApellido(est.getApellido());
		estTO.setFechaNacimiento(est.getFechaNacimiento());
		estTO.setGenero(est.getGenero());
		estTO.setNombre(est.getNombre());
		estTO.setId(est.getId());
		estTO.setCelular(est.getCelular());
		estTO.setCiudad(est.getCiudad());
		estTO.setDireccion(est.getDireccion());
		estTO.setPais(est.getPais());
		estTO.setParroquia(est.getParroquia());

		return estTO;
	}

	private EstudianteDTO convertDTO(Estudiante est) {
		EstudianteDTO estTO = new EstudianteDTO();
		estTO.setApellido(est.getApellido());
		estTO.setNombre(est.getNombre());
		estTO.setId(est.getId());
		return estTO;

	}

	@Override
	public List<EstudianteDTO> buscarTodos(String gen) {
		var lista = this.estudianteRepo.getAll(gen);
		List<EstudianteDTO> listaDTO = new ArrayList<>();
		for (Estudiante estu : lista) {
			listaDTO.add(this.convertDTO(estu));
		}
		return listaDTO;
	}

}
