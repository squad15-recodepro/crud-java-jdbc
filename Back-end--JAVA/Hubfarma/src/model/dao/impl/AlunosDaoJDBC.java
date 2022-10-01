package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.AlunosDao;
import model.entities.Alunos;
import model.entities.Sindicato;

public class AlunosDaoJDBC implements AlunosDao{

	private Connection conn;
	
	public AlunosDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Alunos obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Alunos obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByCPF(Double cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alunos findByCPF(Double cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM sindicatos "
					+ "WHERE sindicatos.cnpj_sind = ?"
					);
			st.setDouble(1, cpf);
			rs = st.executeQuery();
			if (rs.next()) {
				Sindicato sind = new Sindicato();
				sind.setCnpj_sind(rs.getDouble("cnpj_sind"));
				sind.setNome_sind(rs.getString("nome_sind"));
				sind.setEnd_sind(rs.getString("end_sind"));
				sind.setUf_sind(rs.getString("uf_sind"));
				sind.setCidade_sind(rs.getString("cidade_sind"));
				Alunos alun = new Alunos();
				alun.setCpf_alun(rs.getDouble("cpf_alun"));
				alun.setNome_alun(rs.getString("nome_alun"));
				alun.setData_nasc_alun(rs.getDate("data_nasc_alun"));
				alun.setSindicato(sind);
				return alun;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Alunos> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
