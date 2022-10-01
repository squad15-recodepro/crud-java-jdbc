package model.entities;

import java.io.Serializable;
import java.util.Objects;

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
	
	
	
	
}
