package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
										"INSERT INTO alunos "
										+ "(cpf_alun, nome_alun, data_nasc_alun) "
										+ "VALUES "
										+ "(?,?,?) ");
			st.setDouble(1, obj.getCpf_alun());
			st.setString(2, obj.getNome_alun());
			st.setDate(3, new java.sql.Date(obj.getData_nasc_alun().getTime()));
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Alunos obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
										"UPDATE alunos "
										+ "SET nome_alun = ?, data_nasc_alun = ? "
										+ "WHERE cpf_alun = ? ");
										
			st.setString(1, obj.getNome_alun());
			st.setDate(2, new java.sql.Date(obj.getData_nasc_alun().getTime()));
			st.setDouble(3, obj.getCpf_alun());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteByCPF(Double cpf) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM alunos WHERE cpf_alun = ? ");
			
			st.setDouble(1, cpf);
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
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
				Alunos alun = instantiateAlunos(rs);
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

	private Alunos instantiateAlunos(ResultSet rs) throws SQLException {
		Alunos alun = new Alunos();
		alun.setCpf_alun(rs.getDouble("cpf_alun"));
		alun.setNome_alun(rs.getString("nome_alun"));
		alun.setData_nasc_alun(rs.getDate("data_nasc_alun"));
		return alun;
	}
	
	@Override
	public List<Alunos> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
									"SELECT alunos.*,sindicatos.nome_sind as AlunosAll "
									+ "FROM alunos INNER JOIN sindicatos "
									+ "ON alunos.cnpj_sind_fk = sindicatos.cnpj_sind "
									+ "ORDER BY nome_alun ");
			rs = st.executeQuery();
			
			List<Alunos> lista = new ArrayList<>();
			return lista;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
}
