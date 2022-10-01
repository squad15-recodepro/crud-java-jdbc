package model.dao;

import db.DB;
import model.dao.impl.SindicatoDaoJDBC;

public class DaoFactory {

	public static SindicatoDao createSindicatoDao() {
		return new SindicatoDaoJDBC(DB.getConnection());
	}
	
	
}
