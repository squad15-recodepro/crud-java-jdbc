package model.dao;

import java.util.List;

import model.entities.Voluntarios;

public interface VoluntarioDao {

	void insert(Voluntarios obj);
	void update(Voluntarios obj);
	void deleteById(Integer id);
	Voluntarios findById(Integer id);
	List<Voluntarios> findAll();
}
