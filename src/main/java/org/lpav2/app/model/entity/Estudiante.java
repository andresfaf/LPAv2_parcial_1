package org.lpav2.app.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estudiantes")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 50)
	@NotEmpty
	private String nombre;

	@Column(name = "nota_final", nullable = false)
	@DecimalMax(value = "5.0", inclusive = true)
	@DecimalMin(value = "0.0", inclusive = true)
	@NotNull
	private double notaFinal;

	@Column(name = "numero_faltas", nullable = false)
	@NotNull
	@Min(value = 0)
	private Integer numeroFaltas;

	public Estudiante() {
	}

	public Estudiante(Integer id, @NotEmpty String nombre,
			@DecimalMax(value = "5.0", inclusive = true) @DecimalMin(value = "0.0", inclusive = true) @NotNull double notaFinal,
			@NotNull @Min(0) Integer numeroFaltas) {
		this.id = id;
		this.nombre = nombre;
		this.notaFinal = notaFinal;
		this.numeroFaltas = numeroFaltas;
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

	public double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public Integer getNumeroFaltas() {
		return numeroFaltas;
	}

	public void setNumeroFaltas(Integer numeroFaltas) {
		this.numeroFaltas = numeroFaltas;
	}

}
