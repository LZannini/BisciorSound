package ImplementazioniPG_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class gestionePreferiti {
	
	 public static void aggiungi_preferito(String traccia) {

			PreparedStatement ps  = null;
		    Connection conn = null;
		    String ut1 = GUI.pagina_iniziale.getNomeLogin();
		    String ut2 = GUI.adminLogin_frame.getNomeLoginAdmin();
			
			String query = "INSERT INTO preferiti(id_utente, id_traccia) SELECT user_id, id_track from utente, traccia where traccia.nome = ? and (utente.username = ? or utente.username = ?)";
			
			try {
				conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
				ps = conn.prepareStatement(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				ps.setString(1, traccia);
				ps.setString(2, ut1);
				ps.setString(3, ut2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				ps.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		    try {
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	 
	 public static void rimuovi_preferito(String traccia) {

			PreparedStatement ps  = null;
		    Connection conn = null;
		    String ut1 = GUI.pagina_iniziale.getNomeLogin();
		    String ut2 = GUI.adminLogin_frame.getNomeLoginAdmin();
			
			String query = "delete from preferiti where id_utente = (select user_id from utente where (username = ? or username = ?)) and id_traccia = (select id_track from traccia where nome = ?)";
			
			try {
				conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
				ps = conn.prepareStatement(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				ps.setString(1, ut1);
				ps.setString(2, ut2);
				ps.setString(3, traccia);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				ps.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		    try {
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	 
	 public static void aggiungi_preferito_cover(String traccia) {

			PreparedStatement ps  = null;
		    Connection conn = null;
		    String ut1 = GUI.pagina_iniziale.getNomeLogin();
		    String ut2 = GUI.adminLogin_frame.getNomeLoginAdmin();
			
			String query = "INSERT INTO preferiti_cover(id_utente, id_cover) SELECT user_id, id_cover from utente, cover where cover.nome = ? and (utente.username = ? or utente.username = ?)";
			
			try {
				conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
				ps = conn.prepareStatement(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				ps.setString(1, traccia);
				ps.setString(2, ut1);
				ps.setString(3, ut2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				ps.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		    try {
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	 
	 public static void rimuovi_preferito_cover(String traccia) {

			PreparedStatement ps  = null;
		    Connection conn = null;
		    String ut1 = GUI.pagina_iniziale.getNomeLogin();
		    String ut2 = GUI.adminLogin_frame.getNomeLoginAdmin();
			
			String query = "delete from preferiti_cover where id_utente = (select user_id from utente where (username = ? or username = ?)) and id_cover = (select id_cover from cover where nome= ?)";
			
			try {
				conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
				ps = conn.prepareStatement(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				ps.setString(1, ut1);
				ps.setString(2, ut2);
				ps.setString(3, traccia);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				ps.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		    try {
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
   			}
	}

}
