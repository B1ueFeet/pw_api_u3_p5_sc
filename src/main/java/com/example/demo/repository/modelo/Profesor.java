package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(generator = "seq_profesor", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_profesor", sequenceName = "seq_profesor", allocationSize = 1)
	@Column(name = "profe_id")
	private Integer id;
	@Column(name = "profe_cedula")
	private String cedula;
	@Column(name = "profe_nombre")
	private String nombre;
	@Column(name = "profe_apellido")
	private String apellido;
	@Column(name = "profe_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	@Column(name = "profe_genero")
	private String genero;
	@Column(name = "profe_asignatura")
	private String asignatura;
	
	//SET Y GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
}
