package ImplementazioniPG_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import DAO.AscoltoTracciaDAO;
import Model.*;

public class AscoltoTracciaImplementazionePG_DAO implements AscoltoTracciaDAO {

	private Connection conn;

	public AscoltoTracciaImplementazionePG_DAO() {

		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JTable mostra_ascoltiTracce(JTable tabella, Utente U) {

		try{
	        PreparedStatement ps = conn.prepareStatement("SELECT traccia.nome, ascolto_traccia.num_ascolti\r\n"
	        		+ "FROM traccia, utente, ascolto_traccia\r\n"
	        		+ "WHERE traccia.id_track = ascolto_traccia.id_traccia and utente.user_id = ascolto_traccia.id_utente and utente.username = '"+U.getUsername()+"'\r\n"
	        		+ "ORDER BY ascolto_traccia.num_ascolti DESC");
	        ResultSet rs = ps.executeQuery();
	        DefaultTableModel tm = (DefaultTableModel)tabella.getModel();
	        tm.setRowCount(0);

	        while(rs.next()){

	            Object o[] = {rs.getString("nome"),rs.getInt("num_ascolti")};
	            tm.addRow(o);
	        }
	    }
	    catch(SQLException e){
	    	e.printStackTrace();
	    }
		
		return tabella;
    }

}
