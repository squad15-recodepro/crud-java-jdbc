package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.VoluntarioDao;
import model.entities.Voluntarios;

public class VoluntariosDaoJDBC implements VoluntarioDao{

	private Connection conn;
	
	public VoluntariosDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Voluntarios obj) {
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
										"INSERT INTO voluntarios "
										+ "(id_voluntario, periodo, cpf_user_fk) "
										+ "VALUES "
										+ "(?,?,?) ");
			
			st.setInt(1, obj.getId_voluntario());
			st.setString(2, obj.getPeriodo());
			st.setDouble(3, obj.getUsuarios().getCpf_user());
			
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
	public void update(Voluntarios obj) {
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
										"UPDATE voluntarios "
										+ "SET periodo = ? "
										+ "WHERE id_voluntario = ? ");
			
			
			st.setString(1, obj.getPeriodo());
			st.setInt(2, obj.getId_voluntario());
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
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM voluntarios WHERE id_voluntario = ? ");
			st.setInt(1, id);
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
	public Voluntarios findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM voluntarios WHERE voluntarios.id_voluntario = ? ");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Voluntarios voluntarios = instantiateVoluntarios(rs);
				return voluntarios;
				
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

	private Voluntarios instantiateVoluntarios(ResultSet rs) throws SQLException {
		Voluntarios voluntarios = new Voluntarios();
		voluntarios.setId_voluntario(rs.getInt("id_voluntario"));
		voluntarios.setPeriodo(rs.getString("periodo"));
		return voluntarios;
	}

}
