package model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import model.dao.SindicatoDao;

public class Sindicato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double cnpj_sind;
	private String nome_sind;
	private String end_sind;
	private String uf_sind;
	private String cidade_sind;
	
	public Sindicato() {
	}

	public Sindicato(Double cnpj_sind, String nome_sind, String end_sind, String uf_sind, String cidade_sind) {
		this.cnpj_sind = cnpj_sind;
		this.nome_sind = nome_sind;
		this.end_sind = end_sind;
		this.uf_sind = uf_sind;
		this.cidade_sind = cidade_sind;
	}

	public Double getCnpj_sind() {
		return cnpj_sind;
	}

	public void setCnpj_sind(Double cnpj_sind) {
		this.cnpj_sind = cnpj_sind;
	}

	public String getNome_sind() {
		return nome_sind;
	}

	public void setNome_sind(String nome_sind) {
		this.nome_sind = nome_sind;
	}

	public String getEnd_sind() {
		return end_sind;
	}

	public void setEnd_sind(String end_sind) {
		this.end_sind = end_sind;
	}

	public String getUf_sind() {
		return uf_sind;
	}

	public void setUf_sind(String uf_sind) {
		this.uf_sind = uf_sind;
	}

	public String getCidade_sind() {
		return cidade_sind;
	}

	public void setCidade_sind(String cidade_sind) {
		this.cidade_sind = cidade_sind;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj_sind);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sindicato other = (Sindicato) obj;
		return Objects.equals(cnpj_sind, other.cnpj_sind);
	}

	@Override
	public String toString() {
		return "Sindicato \ncnpj_sind = " + cnpj_sind + "\nnome_sind = " + nome_sind + "\nend_sind = " + end_sind
				+ "\nuf_sind = " + uf_sind + "\ncidade_sind = " + cidade_sind;
	}
	
	public static void cadastroSindicato(SindicatoDao sindicatoDao) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("CADASTRAR NOVO SINDICATO");
		System.out.print("CNPJ: ");
		Double cnpj = sc.nextDouble();
		System.out.print("NOME DO SINDICATO: ");
		String nome = sc.next();
		System.out.print("ENDEREÇO DO SINDICATO: ");
		sc.nextLine();
		String end = sc.nextLine();
		System.out.print("UF DO SINDICATO: ");
		String uf = sc.next();
		sc.nextLine();
		System.out.print("CIDADE DO SINDICATO: ");
		String cidade = sc.nextLine();
		
		Sindicato sind = new Sindicato(cnpj, nome, end, uf, cidade);
		sindicatoDao.insert(sind);
		System.out.println("SINDICATO ADICIONADO COM SUCESSO!");
		
	}
	
	public static void atualizarSindicato(Sindicato sindicato, SindicatoDao sindicatoDao) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ATUALIZAR SINDICATO");
		System.out.print("DIGITE O CNPJ DO SINDICATO: ");
		Double cnpj = sc.nextDouble();
		sindicato = sindicatoDao.findByCNPJ(cnpj);
		System.out.println("DIGITE OS NOVOS DADOS DO SINDICATO:");
		System.out.print("NOME DO SINDICATO: ");
		sc.nextLine();
		String nome = sc.nextLine();
		sindicato.setNome_sind(nome);
		System.out.print("ENDEREÇO DO SINDICATO: ");
		String end = sc.nextLine();
		sindicato.setEnd_sind(end);
		System.out.print("UF DO SINDICATO: ");
		String uf = sc.next();
		sindicato.setUf_sind(uf);
		System.out.print("CIDADE DO SINDICATO: ");
		String cidade = sc.nextLine();
		sindicato.setCidade_sind(cidade);
		
		sindicatoDao.update(sindicato);
		System.out.println("ATUALIZAÇÃO FINALIZADA COM SUCESSO!");
	}
	
	public static void pesquisarSindicato(Sindicato sindicato, SindicatoDao sindicatoDao, Double cnpj) {
		sindicato = sindicatoDao.findByCNPJ(cnpj);
		System.out.println(sindicato);
	}
		
	public static void deletarPorCNPJ(Sindicato sindicato, SindicatoDao sindicatoDao, Double cnpj) {
		sindicato = new Sindicato();
		sindicatoDao.deleteByCNPJ(cnpj);;
		System.out.println("DELETADO COM SUCESSO!");
	}
}
