package application;

import java.util.Date;

import model.dao.AlunosDao;
import model.dao.DaoFactory;
import model.dao.SindicatoDao;
import model.dao.UsuariosDao;
import model.dao.VoluntarioDao;
import model.entities.Alunos;
import model.entities.Sindicato;
import model.entities.Usuarios;
import model.entities.Voluntarios;

public class Program {

	public static void main(String[] args) {
		
		SindicatoDao sindicatoDao = DaoFactory.createSindicatoDao();
		AlunosDao alunosDao = DaoFactory.createAlunosDao();
		UsuariosDao usuariosDao = DaoFactory.createUsuariosDao();
		VoluntarioDao voluntarioDao = DaoFactory.createVoluntarioDao();
		
		System.out.println("Teste do insert Sindicato");
		Sindicato novoSindicato = new Sindicato(7.245, "Teste11", "Rua qualquer 07", "RJ", "Rio de Janeiro");
		sindicatoDao.insert(novoSindicato);
		System.out.println("Inserido com sucesso!");
		/*
		System.out.println("Teste do insert Alunos");
		Alunos novoAluno = new Alunos(1566.44, "Joao", new Date());
		alunosDao.insert(novoAluno);
		System.out.println("Inserido com sucesso!");
		*/		
		System.out.println("Teste do insert Usuarios");
		Usuarios novoUsuario = new Usuarios(3.39, "Paulo", "Rua alguma 22", "email@email.com", "RJ", "Petropolis", "TI", new Date());
		usuariosDao.insert(novoUsuario);
		System.out.println("Inserido com sucesso!");
		
		System.out.println("Teste do insert Voluntarios");
		Voluntarios novoVoluntario = new Voluntarios(1, "Manhã", novoUsuario, novoSindicato);
		voluntarioDao.insert(novoVoluntario);
		System.out.println("Inserido com sucesso!");
	}

}
