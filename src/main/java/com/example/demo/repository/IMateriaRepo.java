package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepo {

	public List<Materia> seleccionar(Integer id);
}
