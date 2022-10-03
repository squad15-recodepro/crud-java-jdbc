package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Alunos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Double cpf_alun;
	private String nome_alun;
	private Date data_nasc_alun;
	
	
	
	public Alunos() {
	}

	public Alunos(Double cpf_alun, String nome_alun, Date data_nasc_alun) {
		this.cpf_alun = cpf_alun;
		this.nome_alun = nome_alun;
		this.data_nasc_alun = data_nasc_alun;
		
	}

	public Double getCpf_alun() {
		return cpf_alun;
	}

	public void setCpf_alun(Double cpf_alun) {
		this.cpf_alun = cpf_alun;
	}

	public String getNome_alun() {
		return nome_alun;
	}

	public void setNome_alun(String nome_alun) {
		this.nome_alun = nome_alun;
	}

	public Date getData_nasc_alun() {
		return data_nasc_alun;
	}

	public void setData_nasc_alun(Date data_nasc_alun) {
		this.data_nasc_alun = data_nasc_alun;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf_alun);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alunos other = (Alunos) obj;
		return Objects.equals(cpf_alun, other.cpf_alun);
	}

	@Override
	public String toString() {
		return "Alunos \ncpf_alun = " + cpf_alun + "\nnome_alun = " + nome_alun + "\ndata_nasc_alun = " + data_nasc_alun;
	}
	
	
}
