package model.dao;

import java.util.List;

import model.entities.Usuarios;

public interface UsuariosDao {

	void insert(Usuarios obj);
	void update(Usuarios obj);
	void deleteByCNPJ(Double cnpj);
	Usuarios findByCNPJ(Double cnpj);
	List<Usuarios> findAll();
}
