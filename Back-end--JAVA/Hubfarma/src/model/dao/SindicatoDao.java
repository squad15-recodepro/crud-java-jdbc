package model.dao;

import java.util.List;

import model.entities.Sindicato;

public interface SindicatoDao {

	void insert(Sindicato obj);
	void update(Sindicato obj);
	void deleteByCNPJ(Double cnpj);
	Sindicato findByCNPJ(Double cnpj);
	List<Sindicato> findAll();
}
