package application;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

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

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SindicatoDao sindicatoDao = DaoFactory.createSindicatoDao();
		AlunosDao alunosDao = DaoFactory.createAlunosDao();
		UsuariosDao usuariosDao = DaoFactory.createUsuariosDao();
		VoluntarioDao voluntarioDao = DaoFactory.createVoluntarioDao();
		
		Sindicato sindicato = new Sindicato();
		Alunos aluno = new Alunos();
		Usuarios usuario = new Usuarios();
		Voluntarios voluntario = new Voluntarios();
		
		int a = 0;
		while (a != 2 ) {
			System.out.println("ESCOLHA A OPÇÃO DESEJADA");
			System.out.println("1 - Sindicatos \n2 - Alunos \n3 - Usuarios \n4 - Voluntarios");
			int escolha = sc.nextInt();
			switch (escolha) {
			case 1:
				int test = 0;
				while (test != 2) {
					System.out.println("AREA DO SINDICATO SELECIONADA!");
					System.out.println("ESCOLHA A OPÇÃO DESEJADA:");
					System.out.println("1 - Cadastrar novo sindicato \n2 - Atualizar sindicato \n3 - Deletar sindicato \n4 - Pesquisar sindicato");
					int opc = sc.nextInt();
					switch (opc) {
					case 1:
						sindicato.cadastroSindicato(sindicatoDao);
						break;
					
					case 2:
						sindicato.atualizarSindicato(sindicato, sindicatoDao);
						break;
						
					case 3:
						System.out.print("DIGITE O CNPJ DO SINDICATO PARA REMOVE-LO: ");
						double del = sc.nextDouble();
						sindicato.deletarPorCNPJ(sindicato, sindicatoDao, del);
						break;
						
					case 4:
						System.out.print("DIGITE O CNPJ DO SINDICATO PARA PESQUISA: ");
						double cnpj = sc.nextDouble();
						sindicato.pesquisarSindicato(sindicato, sindicatoDao, cnpj);
						break;
					}
					System.out.println("Deseja continuar?\n1 - SIM \n2 - NAO");
					sc.nextLine();
					test = sc.nextInt();
					if(test == 2) {
						break;
					}
				}
				continue;
			case 2:
				test = 0;
				while (test != 2) {
					System.out.println("AREA DO ALUNO SELECIONADA!");
					System.out.println("ESCOLHA A OPÇÃO DESEJADA:");
					System.out.println("1 - Cadastrar novo aluno \n2 - Atualizar aluno \n3 - Deletar aluno \n4 - Pesquisar aluno");
					int opc = sc.nextInt();
					switch (opc) {
					case 1:
						aluno.cadastrarAluno(alunosDao);
						break;
					
					case 2:
						aluno.atualizarAluno(aluno, alunosDao);
						break;
						
					case 3:
						System.out.print("DIGITE O CPF DO ALUNO PARA REMOVE-LO: ");
						double cpf = sc.nextDouble();
						aluno.deletarPorCPF(aluno, alunosDao, cpf);
						break;
						
					case 4:
						System.out.print("DIGITE O CPF DO ALUNO PARA PESQUISA: ");
						cpf = sc.nextDouble();
						aluno.pesquisarPorCPF(aluno, alunosDao, cpf);
						break;
					}
					System.out.println("Deseja continuar?\n1 - SIM \n2 - NAO");
					sc.nextLine();
					test = sc.nextInt();
					if(test == 2) {
						break;
					}
				}
				continue;
			case 3:
				test = 0;
				while (test != 2) {
					System.out.println("AREA DO USUARIO SELECIONADA!");
					System.out.println("ESCOLHA A OPÇÃO DESEJADA:");
					System.out.println("1 - Cadastrar novo usuario \n2 - Atualizar usuario \n3 - Deletar usuario \n4 - Pesquisar usuario");
					int opc = sc.nextInt();
					switch (opc) {
					case 1:
						usuario.cadastrarUsuarios(usuario, usuariosDao);
						break;
					
					case 2:
						usuario.atualizarUsuario(usuario, usuariosDao);
						break;
						
					case 3:
						System.out.print("DIGITE O CPF DO USUARIO PARA REMOVE-LO: ");
						double cpf = sc.nextDouble();
						usuario.deletarPorCPF(usuario, usuariosDao, cpf);
						break;
						
					case 4:
						System.out.print("DIGITE O CPF DO USUARIO PARA PESQUISA: ");
						cpf = sc.nextDouble();
						usuario.pesquisarPorCPF(usuario, usuariosDao, cpf);
						break;
					}
					System.out.println("Deseja continuar?\n1 - SIM \n2 - NAO");
					sc.nextLine();
					test = sc.nextInt();
					if(test == 2) {
						break;
					}
				}
				continue;
			case 4:
				test = 0;
				while (test != 2) {
					System.out.println("AREA DO VOLUNTARIO SELECIONADA!");
					System.out.println("ESCOLHA A OPÇÃO DESEJADA:");
					System.out.println("1 - Cadastrar novo voluntario \n2 - Atualizar voluntario \n3 - Deletar voluntario \n4 - Pesquisar voluntario");
					int opc = sc.nextInt();
					switch (opc) {
					case 1:
						voluntario.cadatrarVoluntario(voluntario, voluntarioDao);
						break;
					
					case 2:
						voluntario.atualizarVoluntario(voluntario, voluntarioDao);
						break;
						
					case 3:
						System.out.print("DIGITE O CPF DO USUARIO PARA REMOVE-LO: ");
						int id = sc.nextInt();
						voluntario.deletarPorId(voluntario, voluntarioDao, id);
						break;
						
					case 4:
						System.out.print("DIGITE O ID DO USUARIO PARA PESQUISA: ");
						id = sc.nextInt();
						voluntario.pesquisarPorId(voluntario, voluntarioDao, id);
						break;
					}
					System.out.println("Deseja continuar?\n1 - SIM \n2 - NAO");
					sc.nextLine();
					test = sc.nextInt();
					if(test == 2) {
						break;
					}
				}
				continue;
			}
		}
	}

}
