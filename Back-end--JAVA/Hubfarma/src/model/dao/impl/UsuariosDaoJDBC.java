package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuarios obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByCPF(Double cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuarios findByCPF(Double cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM usuarios WHERE usuarios.cpf_user = ? ");
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

	@Override
	public List<Usuarios> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
