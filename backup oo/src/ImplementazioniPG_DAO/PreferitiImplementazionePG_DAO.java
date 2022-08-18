package ImplementazioniPG_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.*;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import DAO.PreferitiDAO;

public class PreferitiImplementazionePG_DAO implements PreferitiDAO {
	
    private static Connection conn;
	
    public PreferitiImplementazionePG_DAO() {
		
		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public JList mostra_preferiti(JList lista) {
		 
		 
		String nomeLogin = GUI.pagina_iniziale.getNomeLogin();
		String nomeLoginAdmin = GUI.adminLogin_frame.getNomeLoginAdmin();
		String query = "select nome from traccia, utente, preferiti where preferiti.id_traccia = traccia.id_track and preferiti.id_utente = utente.user_id and (utente.username = '" +nomeLogin+ "' or utente.username = '" +nomeLoginAdmin+ "') order by traccia.nome";
		DefaultListModel model = new DefaultListModel();  

	    Statement st = null;
	    ResultSet rs = null;
	    Connection conn = null;
		
		
		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    try {
			while (rs.next())
			{
			    String itemCodeNome = null;
				try {
					itemCodeNome = rs.getString("nome");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			    model.addElement(itemCodeNome);  
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    lista.setModel(model);

	    try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			st.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return lista;
    }
    
    public void aggiungi_preferito(String traccia) {

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
 
 public void rimuovi_preferito(String traccia) {

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

}
