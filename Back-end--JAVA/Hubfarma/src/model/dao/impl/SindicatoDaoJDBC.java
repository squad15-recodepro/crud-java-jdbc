package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Sindicato obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByCNPJ(Double cnpj) {
		// TODO Auto-generated method stub
		
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
		obj.setEnd_sind(rs.getString("end_sind"));
		obj.setUf_sind(rs.getString("uf_sind"));
		obj.setCidade_sind(rs.getString("cidade_sind"));
		return obj;
	}
	@Override
	public List<Sindicato> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
