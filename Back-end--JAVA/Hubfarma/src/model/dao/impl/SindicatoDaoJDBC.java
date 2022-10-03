package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import db.DB;
import db.DbException;
import model.dao.SindicatoDao;
import model.entities.Sindicato;

public class SindicatoDaoJDBC implements SindicatoDao{

	private Connection conn;
	
	public SindicatoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Sindicato obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
										"INSERT INTO sindicatos "
										+ "(cnpj_sind, nome_sind, endereco_sind, uf_sind, cidade_sind) "
										+ "VALUES "
										+ "(?,?,?,?,?) ");
										
			st.setDouble(1, obj.getCnpj_sind());
			st.setString(2, obj.getNome_sind());
			st.setString(3, obj.getEnd_sind());
			st.setString(4, obj.getUf_sind());
			st.setString(5, obj.getCidade_sind());
			
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
	public void update(Sindicato obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
										"UPDATE sindicatos "
										+ "SET nome_sind = ?, endereco_sind = ?, uf_sind = ?, cidade_sind = ? "
										+ "WHERE cnpj_sind = ?");
										
			st.setString(1, obj.getNome_sind());
			st.setString(2, obj.getEnd_sind());
			st.setString(3, obj.getUf_sind());
			st.setString(4, obj.getCidade_sind());
			st.setDouble(5, obj.getCnpj_sind());
			
			
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
	public void deleteByCNPJ(Double cnpj) {
		Locale.setDefault(Locale.US);
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
										"DELETE FROM sindicatos "
										+ "WHERE cnpj_sind = ? "
										);
			st.setDouble(1, cnpj);
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
	public Sindicato findByCNPJ(Double cnpj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
										"SELECT * FROM sindicatos "
										+ "WHERE sindicatos.cnpj_sind = ?"
										);
			st.setDouble(1, cnpj);
			rs = st.executeQuery();
			if (rs.next()) {
				Sindicato obj = instantiateSindicato(rs);
				return obj;
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

	private Sindicato instantiateSindicato(ResultSet rs) throws SQLException {
		Sindicato obj = new Sindicato();
		obj.setCnpj_sind(rs.getDouble("cnpj_sind"));
		obj.setNome_sind(rs.getString("nome_sind"));
		obj.setEnd_sind(rs.getString("endereco_sind"));
		obj.setUf_sind(rs.getString("uf_sind"));
		obj.setCidade_sind(rs.getString("cidade_sind"));
		return obj;
	}
		
}
