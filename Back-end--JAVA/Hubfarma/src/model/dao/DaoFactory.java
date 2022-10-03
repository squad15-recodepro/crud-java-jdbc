package model.dao;

import db.DB;
import model.dao.impl.AlunosDaoJDBC;
import model.dao.impl.SindicatoDaoJDBC;
import model.dao.impl.UsuariosDaoJDBC;
import model.dao.impl.VoluntariosDaoJDBC;

public class DaoFactory {

	public static SindicatoDao createSindicatoDao() {
		return new SindicatoDaoJDBC(DB.getConnection());
	}
	
	public static AlunosDao createAlunosDao() {
		return new AlunosDaoJDBC(DB.getConnection());
	}
	
	public static UsuariosDao createUsuariosDao() {
		return new UsuariosDaoJDBC(DB.getConnection());
	}
	
	public static VoluntarioDao createVoluntarioDao() {
		return new VoluntariosDaoJDBC(DB.getConnection());
	}
	
}
