package model.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import model.dao.UsuariosDao;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double cpf_user;
	private String nome_user;
	private String end_user;
	private String email_user;
	private String uf_user;
	private String cidade_user;
	private String formacao_user;
	private Date data_nasc_user;
	
	public Usuarios() {
	}

	

	public Usuarios(Double cpf_user, String nome_user, String end_user, String email_user, String uf_user,
			String cidade_user, String formacao_user, Date data_nasc_user) {
		
		this.cpf_user = cpf_user;
		this.nome_user = nome_user;
		this.end_user = end_user;
		this.email_user = email_user;
		this.uf_user = uf_user;
		this.cidade_user = cidade_user;
		this.formacao_user = formacao_user;
		this.data_nasc_user = data_nasc_user;
	}



	public Double getCpf_user() {
		return cpf_user;
	}

	public void setCpf_user(Double cpf_user) {
		this.cpf_user = cpf_user;
	}

	public String getNome_user() {
		return nome_user;
	}

	public void setNome_user(String nome_user) {
		this.nome_user = nome_user;
	}

	public String getEnd_user() {
		return end_user;
	}

	public void setEnd_user(String end_user) {
		this.end_user = end_user;
	}

	public String getUf_user() {
		return uf_user;
	}

	public void setUf_user(String uf_user) {
		this.uf_user = uf_user;
	}

	public String getCidade_user() {
		return cidade_user;
	}

	public void setCidade_user(String cidade_user) {
		this.cidade_user = cidade_user;
	}

	public String getFormacao_user() {
		return formacao_user;
	}

	public void setFormacao_user(String formacao_user) {
		this.formacao_user = formacao_user;
	}

	public Date getData_nasc_user() {
		return data_nasc_user;
	}

	public void setData_nasc_user(Date data_nasc_user) {
		this.data_nasc_user = data_nasc_user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf_user);
	}

	public String getEmail_user() {
		return email_user;
	}

	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		return Objects.equals(cpf_user, other.cpf_user);
	}



	@Override
	public String toString() {
		return "Usuarios \ncpf = " + cpf_user + "\nnome = " + nome_user + "\nendereço = " + end_user + "\nemail_user = " + email_user + "\nuf = "
		+ uf_user + "\ncidade = " + cidade_user + "\nformação = " + formacao_user + "\ndata_nasc = "
		+ data_nasc_user;
	}


	public static void cadastrarUsuarios(Usuarios usuario, UsuariosDao usuarioDao) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat();
		
		System.out.println("CADASTRAR NOVO USUARIO");
		System.out.print("CPF: ");
		double cpf = sc.nextDouble();
		System.out.print("NOME: ");
		String nome = sc.next();
		System.out.println("ENDEREÇO: ");
		sc.nextLine();
		String end = sc.nextLine();
		System.out.println("EMAIL: ");
		String email = sc.next();
		System.out.println("UF: ");
		String uf = sc.next();
		System.out.println("CIDADE: ");
		String cidade = sc.next();
		System.out.println("FORMAÇÃO: ");
		String formacao = sc.next();
		System.out.println("DATA DE NASC: ");
		Date data = new Date();
		
		Usuarios user = new Usuarios(cpf, nome, end, email, uf, cidade, formacao, data);
		usuarioDao.insert(user);
		System.out.println("USUARIO CADASTRADO!");
		
	}
	
	public static void atualizarUsuario(Usuarios usuario, UsuariosDao usuarioDao) throws ParseException {
		Scanner sc = new Scanner(System.in);
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("ATUALIZAR USUARIO");
		System.out.print("DIGITE O CPF DO USUARIO: ");
		Double cpf = sc.nextDouble();
		usuario = usuarioDao.findByCPF(cpf);
		System.out.println("DIGITE OS NOVOS DADOS DO USUARIO");
		System.out.print("NOME: ");
		String nome = sc.next();
		usuario.setNome_user(nome);
		System.out.println("ENDEREÇO: ");
		sc.nextLine();
		String end = sc.nextLine();
		usuario.setEnd_user(end);
		System.out.println("EMAIL: ");
		String email = sc.next();
		usuario.setEmail_user(email);
		System.out.println("UF: ");
		String uf = sc.next();
		usuario.setUf_user(uf);
		System.out.println("CIDADE: ");
		sc.nextLine();
		String cidade = sc.nextLine();
		usuario.setCidade_user(cidade);
		System.out.println("FORMAÇÃO: ");
		String formacao = sc.next();
		usuario.setFormacao_user(formacao);
		System.out.println("DATA DE NASC: ");
		Date data = new Date();
		usuario.setData_nasc_user(data);
		
		usuarioDao.update(usuario);
		System.out.println("USUARIO ATUALIZADO COM SUCESSO!");
	}
	
	public static void pesquisarPorCPF(Usuarios usuario, UsuariosDao usuarioDao, Double cpf) {
		usuario = usuarioDao.findByCPF(cpf);
		System.out.println(usuario);
	}
	
	public static void deletarPorCPF(Usuarios usuario, UsuariosDao usuarioDao, Double cpf) {
		usuario = new Usuarios();
		usuarioDao.deleteByCPF(cpf);
		System.out.println("DELETADO COM SUCESSO!");
	}
	
}
