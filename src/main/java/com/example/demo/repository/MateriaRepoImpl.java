package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Materia> seleccionar(Integer id) {
		TypedQuery<Materia> query = this.manager.createQuery("SELECT m FROM Materia m WHERE m.estudiante.id = :valor",
				Materia.class);
		query.setParameter("valor", id);
		var lista = query.getResultList();
		return lista;
	}

}
