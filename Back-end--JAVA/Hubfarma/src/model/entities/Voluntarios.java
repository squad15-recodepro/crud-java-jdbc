package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Voluntarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id_voluntario;
	private String periodo;
	
	
	private Usuarios usuarios;
	private Sindicato sindicato;
	
	public Voluntarios() {
	}

	public Voluntarios(Integer id_voluntario, String periodo, Usuarios usuarios, Sindicato sindicato) {
		
		this.id_voluntario = id_voluntario;
		this.periodo = periodo;
		this.usuarios = usuarios;
		this.sindicato = sindicato;
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
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
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
		return "Voluntarios \nid_voluntario = " + id_voluntario + "\nperiodo = " + periodo + "\nusuarios = " + usuarios
				+ "\nsindicato = " + sindicato;
	}
	
	
	
	
	
	
}
