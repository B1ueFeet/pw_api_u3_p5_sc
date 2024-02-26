package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Profesor;

@Repository
@Transactional
public class ProfesorRepositoryImpl implements IProfesorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(profesor);
	}

	@Override
	public void actualizarParcial(String asignatura, Integer id) {
		// TODO Auto-generated method stub
		javax.persistence.Query query = this.entityManager
				.createQuery("UPDATE Profesor p set p.asignatura= :valor1 WHERE p.id= :valor2");
		query.setParameter("valor1", asignatura);
		query.setParameter("valor2", id);
		query.executeUpdate();
	}

	@Override
	public Profesor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Profesor.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public List<Profesor> seleccionarTodos(String genero) {
		// TODO Auto-generated method stub
		TypedQuery<Profesor> query = this.entityManager.createQuery("SELECT p FROM Profesor p WHERE p.genero= :valor1",
				Profesor.class);
		query.setParameter("valor1", genero);

		return query.getResultList();
	}

}
