package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.manager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.manager.merge(estudiante);
	}

	@Override
	public void actualizarParcial(String nombre, String apellido, Integer id) {
		// TODO Auto-generated method stub
		Query query = this.manager
				.createQuery("UPDATE Estudiante e SET e.nombre = :valor1, e.apellido = :valor2 WHERE e.id = :valor3");
		query.setParameter("valor1", nombre);
		query.setParameter("valor2", apellido);
		query.setParameter("valor3", id);
		query.executeUpdate();
	}

	@Override
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.manager.find(Estudiante.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.manager.remove(this.seleccionar(id));
	}

	@Override
	public List<Estudiante> getAll(String gen) {
		TypedQuery<Estudiante> query = this.manager.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :valor",
				Estudiante.class);
		query.setParameter("valor", gen);
		var lista = query.getResultList();
		return lista;
	}

}
