package org.lpav2.app.model.service;

import java.util.List;

import org.lpav2.app.model.entity.Estudiante;

public interface IEstudianteService {
	public List<Estudiante> findAll();
	public void update(Estudiante estudiante);
	public Estudiante findById(Integer id);
	public void deleteById(Integer id);
}
