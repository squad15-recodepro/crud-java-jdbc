package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Voluntarios obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
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

	@Override
	public List<Voluntarios> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
