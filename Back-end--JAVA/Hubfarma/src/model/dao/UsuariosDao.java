package model.dao;

import java.util.List;

import model.entities.Usuarios;

public interface UsuariosDao {

	void insert(Usuarios obj);
	void update(Usuarios obj);
	void deleteByCPF(Double cpf);
	Usuarios findByCPF(Double cpf);
	List<Usuarios> findAll();
}
