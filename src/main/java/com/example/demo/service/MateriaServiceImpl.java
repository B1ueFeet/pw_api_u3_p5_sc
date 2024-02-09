package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepo;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepo materiaRepo;

	@Override
	public List<MateriaTO> buscarMateriasPorId(Integer id) {
		var lista = this.materiaRepo.seleccionar(id);
		List<MateriaTO> listaTO = new ArrayList<>();
		for (Materia mat : lista) {
			listaTO.add(this.convert(mat));
		}
		return listaTO;
	}

	private MateriaTO convert(Materia mat) {
		MateriaTO maTO = new MateriaTO();
		maTO.setCreditos(mat.getCreditos());
		maTO.setId(mat.getId());
		maTO.setNombre(mat.getNombre());
		return maTO;

	}

}
