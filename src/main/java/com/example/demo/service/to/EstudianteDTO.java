package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class EstudianteDTO extends RepresentationModel<EstudianteDTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 816016149027974469L;
	private Integer id;
	private String nombre;
	private String apellido;

	@Override
	public String toString() {
		return "EstudianteDTO [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
