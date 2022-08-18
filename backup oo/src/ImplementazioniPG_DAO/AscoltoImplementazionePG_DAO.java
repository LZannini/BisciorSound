package ImplementazioniPG_DAO;

import java.sql.Connection;
import java.sql.SQLException;

import DAO.AscoltoDAO;
import Model.*;

public class AscoltoImplementazionePG_DAO implements AscoltoDAO {
	
    private static Connection conn;
	
    public AscoltoImplementazionePG_DAO() {
		
		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
