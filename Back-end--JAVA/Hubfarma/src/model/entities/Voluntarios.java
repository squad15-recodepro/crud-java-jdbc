package model.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

import model.dao.VoluntarioDao;

public class Voluntarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id_voluntario;
	private String periodo;
	
	
	private Usuarios usuarios;
	
	public Voluntarios() {
	}

	public Voluntarios(Integer id_voluntario, String periodo, Usuarios usuarios) {
		
		this.id_voluntario = id_voluntario;
		this.periodo = periodo;
		this.usuarios = usuarios;
		
	}

	public Integer getId_voluntario() {
		return id_voluntario;
	}

	public void setId_voluntario(Integer id_voluntario) {
		this.id_voluntario = id_voluntario;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Usuarios getUsuarios() {
		return usuarios ;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_voluntario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voluntarios other = (Voluntarios) obj;
		return Objects.equals(id_voluntario, other.id_voluntario);
	}

	@Override
	public String toString() {
		return "Voluntarios \nid_voluntario = " + id_voluntario + "\nperiodo = " + periodo + "\nusuarios = " + usuarios;
	}
	
	
	public static void cadatrarVoluntario(Voluntarios voluntario, VoluntarioDao voluntarioDao) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("CADASTRAR VOLUNTARIO");
		System.out.println("DIGITE O ID: ");
		int id = sc.nextInt();
		System.out.println("DIGITE O PERIODO: ");
		String periodo = sc.next();
		
		Usuarios user = new Usuarios();
		double cpf = sc.nextDouble();
		user.setCpf_user(cpf);
	
		
		voluntario = new Voluntarios(id, periodo, user);
		voluntarioDao.insert(voluntario);
		System.out.println("VOLUNTARIO ADICIONADO COM SUCESSO!");
	}
	
	public static void atualizarVoluntario(Voluntarios voluntario, VoluntarioDao voluntarioDao) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ATUALIZAR VOLUNTARIO");
		System.out.println("DIGITE O CPF DO VOLUNTARIO");
		int id = sc.nextInt();
		voluntario = voluntarioDao.findById(id);
		System.out.println("DIGITE OS NOVOS DADOS DO USUARIO");
		System.out.println("DIGITE O PERIODO: ");
		String periodo = sc.next();
		voluntario.setPeriodo(periodo);
		
		voluntarioDao.update(voluntario);
		System.out.println("ATUALIZAÇÃO REALIZADA COM SUCESSO!");
	}
	
	public static void pesquisarPorId(Voluntarios voluntario, VoluntarioDao voluntarioDao, int id) {
		voluntario = voluntarioDao.findById(id);
		System.out.println(voluntario);
	}
	
	public static void deletarPorId(Voluntarios voluntario, VoluntarioDao voluntarioDao, int id) {
		voluntario = new Voluntarios();
		voluntarioDao.deleteById(id);
		System.out.println("DELETADO COM SUCESSO!");
	}
	
}
