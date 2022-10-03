package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.UsuariosDao;
import model.entities.Usuarios;

public class UsuariosDaoJDBC implements UsuariosDao {

	private Connection conn;
	
	public UsuariosDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Usuarios obj) {
		PreparedStatement st = null;
		try {
			st= conn.prepareStatement(
										"INSERT INTO usuarios "
										+ "(cpf_user, nome_user, endereco_user, email_user, uf_user, cidade_user, formacao_user, data_nasc_user) "
										+ "VALUES "
										+ "(?,?,?,?,?,?,?,?) ");
			st.setDouble(1, obj.getCpf_user());
			st.setString(2, obj.getNome_user());
			st.setString(3, obj.getEnd_user());
			st.setString(4, obj.getEmail_user());
			st.setString(5, obj.getUf_user());
			st.setString(6, obj.getCidade_user());
			st.setString(7, obj.getFormacao_user());
			st.setDate(8, new java.sql.Date(obj.getData_nasc_user().getTime()));
			
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
	public void update(Usuarios obj) {
		PreparedStatement st = null;
		try {
			st= conn.prepareStatement(
										"UPDATE usuarios "
										+ "SET nome_user = ?, endereco_user = ?, email_user = ?, uf_user = ?, cidade_user = ?, formacao_user = ?, data_nasc_user = ? "
										+ "WHERE cpf_user = ? ");
			
			
			
			st.setString(1, obj.getNome_user());
			st.setString(2, obj.getEnd_user());
			st.setString(3, obj.getEmail_user());
			st.setString(4, obj.getUf_user());
			st.setString(5, obj.getCidade_user());
			st.setString(6, obj.getFormacao_user());
			st.setDate(7, new java.sql.Date(obj.getData_nasc_user().getTime()));
			st.setDouble(8, obj.getCpf_user());
			
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
			st = conn.prepareStatement("DELETE FROM usuarios WHERE cpf_user = ? ");
			
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
	public Usuarios findByCPF(Double cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM usuarios WHERE cpf_user = ? ");
			st.setDouble(1, cpf);
			rs = st.executeQuery();
			if (rs.next()) {
				Usuarios usuario = instantiateUsuarios(rs);
				return usuario;
				
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

	private Usuarios instantiateUsuarios(ResultSet rs) throws SQLException {
		Usuarios usuario = new Usuarios();
		usuario.setCpf_user(rs.getDouble("cpf_user"));
		usuario.setNome_user(rs.getString("nome_user"));
		usuario.setEnd_user(rs.getString("endereco_user"));
		usuario.setEmail_user(rs.getString("email_user"));
		usuario.setUf_user(rs.getString("uf_user"));
		usuario.setCidade_user(rs.getString("cidade_user"));
		usuario.setFormacao_user(rs.getString("formacao_user"));
		usuario.setData_nasc_user(rs.getDate("data_nasc_user"));
		return usuario;
	}

}
