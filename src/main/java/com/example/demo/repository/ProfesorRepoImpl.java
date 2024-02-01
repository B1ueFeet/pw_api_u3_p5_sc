package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProfesorRepoImpl implements IProfesorRepo {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insertar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.manager.persist(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.manager.merge(profesor);
	}

	@Override
	public void actualizarParcial(String nombre, String apellido, Integer id) {
		// TODO Auto-generated method stub
		Query query = this.manager
				.createQuery("UPDATE Profesor p SET p.nombre = :valor1, p.apellido = :valor2 WHERE p.id = :valor3");
		query.setParameter("valor1", nombre);
		query.setParameter("valor2", apellido);
		query.setParameter("valor3", id);
		query.executeUpdate();
	}

	@Override
	public Profesor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.manager.find(Profesor.class, id);
	}

	@Override
	public List<Profesor> getAll(String gen) {
		TypedQuery<Profesor> query = this.manager.createQuery("SELECT p FROM Profesor p WHERE p.genero = :valor",
				Profesor.class);
		query.setParameter("valor", gen);
		var lista = query.getResultList();
		return lista;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.manager.remove(this.seleccionar(id));
	}

}
