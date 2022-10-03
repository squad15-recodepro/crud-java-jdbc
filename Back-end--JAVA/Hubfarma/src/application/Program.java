package application;

import java.util.Locale;
import java.util.Scanner;

import model.dao.AlunosDao;
import model.dao.DaoFactory;
import model.dao.SindicatoDao;
import model.dao.UsuariosDao;
import model.dao.VoluntarioDao;
import model.entities.Usuarios;
import model.entities.Voluntarios;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SindicatoDao sindicatoDao = DaoFactory.createSindicatoDao();
		AlunosDao alunosDao = DaoFactory.createAlunosDao();
		UsuariosDao usuariosDao = DaoFactory.createUsuariosDao();
		VoluntarioDao voluntarioDao = DaoFactory.createVoluntarioDao();
		/*
		System.out.println("Teste do insert Sindicato");
		Sindicato novoSindicato = new Sindicato(7.245, "Teste11", "Rua qualquer 07", "RJ", "Rio de Janeiro");
		sindicatoDao.insert(novoSindicato);
		System.out.println("Inserido com sucesso!");
		
		System.out.println("Teste do insert Alunos");
		Alunos novoAluno = new Alunos(024.38, "Bob", new Date());
		alunosDao.insert(novoAluno);
		System.out.println("Inserido com sucesso!");
				
		System.out.println("Teste do insert Usuarios");
		Usuarios novoUsuario = new Usuarios(3.39, "Paulo", "Rua alguma 22", "email@email.com", "RJ", "Petropolis", "TI", new Date());
		usuariosDao.insert(novoUsuario);
		System.out.println("Inserido com sucesso!");
		
		System.out.println("Teste do insert Voluntarios");
		Voluntarios novoVoluntario = new Voluntarios(1, "Manhã", novoUsuario, novoSindicato);
		voluntarioDao.insert(novoVoluntario);
		System.out.println("Inserido com sucesso!");
		*/
		System.out.println("TESTE FindByCPF");
		Usuarios usuario = usuariosDao.findByCPF(1953.66);
		System.out.println(usuario);
		
		System.out.println("TESTE UPDATE");
		usuariosDao.findByCPF(1953.66);
		usuario.setNome_user("Jonas");
		usuariosDao.update(usuario);
		System.out.println("Concluido!");
		
		Voluntarios voluntario = voluntarioDao.findById(1);
		System.out.println(voluntario);
		
		System.out.println("teste update");
		voluntarioDao.findById(1);
		voluntario.setPeriodo("Tarde");
		voluntarioDao.update(voluntario);
		System.out.println("Concluido");
		
		System.out.println("Teste Delete CNPJ");
		System.out.print("Entre com o cnpj para deletar: ");
		Double cnpj = sc.nextDouble();
		sindicatoDao.deleteByCNPJ(cnpj);
		System.out.println("Concluido!");
	}

}
