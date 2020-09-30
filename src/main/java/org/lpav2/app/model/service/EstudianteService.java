package org.lpav2.app.model.service;

import java.util.List;

import org.lpav2.app.model.dao.IEstudianteDAO;
import org.lpav2.app.model.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudianteService implements IEstudianteService {

	@Autowired
	private IEstudianteDAO estudianteDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> findAll() {
		return (List<Estudiante>) estudianteDAO.findAll();
	}

	@Override
	@Transactional()
	public void update(Estudiante estudiante) {
		estudianteDAO.save(estudiante);
	}

	@Override
	@Transactional(readOnly = true)
	public Estudiante findById(Integer id) {
		return estudianteDAO.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		estudianteDAO.deleteById(id);
	}

}
