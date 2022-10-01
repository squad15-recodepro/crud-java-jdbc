package model.dao;

import java.util.List;

import model.entities.Alunos;

public interface AlunosDao {

	void insert(Alunos obj);
	void update(Alunos obj);
	void deleteByCPF(Double cpf);
	Alunos findByCPF(Double cpf);
	List<Alunos> findAll();
}
