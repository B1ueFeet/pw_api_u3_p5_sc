package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteLigeroTO;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizarParcial(apellido, nombre, id);
	}

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public List<Estudiante> buscarTodos(String genero) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarTodos(genero);
	}

	@Override
	public List<EstudianteTO> buscarTodosTO() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianteRepository.seleccionarTodos("M");
		List<EstudianteTO> listaFinal = new ArrayList<>();
		for (Estudiante est : lista) {
			listaFinal.add(this.convertir(est));
		}
		return listaFinal;
	}

	private EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO estuTO = new EstudianteTO();
		estuTO.setApellido(estudiante.getApellido());
		estuTO.setFechaNacimiento(estudiante.getFechaNacimiento());
		estuTO.setGenero(estudiante.getGenero());
		estuTO.setId(estudiante.getId());
		estuTO.setNombre(estudiante.getNombre());
		estuTO.setNacionalidad(estudiante.getNacionalidad());
		estuTO.setCedula(estudiante.getCedula());
		estuTO.setDireccion(estudiante.getDireccion());
		estuTO.setEdad(estudiante.getEdad());
		estuTO.setEstadoCivil(estudiante.getEstadoCivil());
		estuTO.setLugarNacimiento(estudiante.getLugarNacimiento());
		return estuTO;
	}

	@Override
	public EstudianteTO buscarTO(Integer id) {
		// TODO Auto-generated method stub
		return this.convertir(this.estudianteRepository.seleccionar(id));
	}

	@Override
	public EstudianteLigeroTO buscarLigero(Integer id) {
		// TODO Auto-generated method stub

		return this.convertirLigeroTO(this.estudianteRepository.seleccionar(id));
	}

	public EstudianteLigeroTO convertirLigeroTO(Estudiante estudiante) {
		// TODO Auto-generated method stub
		EstudianteLigeroTO ligeroTO = new EstudianteLigeroTO();
		ligeroTO.setId(estudiante.getId());
		ligeroTO.setNombre(estudiante.getNombre());
		ligeroTO.setApellido(estudiante.getApellido());
		return ligeroTO;
	}

	public Estudiante conversion(EstudianteTO estudiante) {
		Estudiante estu = new Estudiante();
		estu.setApellido(estudiante.getApellido());
		estu.setFechaNacimiento(estudiante.getFechaNacimiento());
		estu.setGenero(estudiante.getGenero());
		estu.setNombre(estudiante.getNombre());
		estu.setId(estudiante.getId());
		estu.setNacionalidad(estudiante.getNacionalidad());
		estu.setCedula(estudiante.getCedula());
		estu.setDireccion(estudiante.getDireccion());
		estu.setEdad(estudiante.getEdad());
		estu.setEstadoCivil(estudiante.getEstadoCivil());
		estu.setLugarNacimiento(estudiante.getLugarNacimiento());
		return estu;
	}

	@Override
	public void guardarTO(EstudianteTO estudianteTO) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(this.conversion(estudianteTO));
	}

	@Override
	public void actualizarTO(EstudianteTO estudianteTO) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(this.conversion(estudianteTO));
	}

}
