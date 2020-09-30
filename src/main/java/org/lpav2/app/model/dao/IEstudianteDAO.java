package org.lpav2.app.model.dao;

import org.lpav2.app.model.entity.Estudiante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteDAO extends CrudRepository<Estudiante, Integer> {

}
