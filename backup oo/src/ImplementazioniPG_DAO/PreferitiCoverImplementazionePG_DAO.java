package ImplementazioniPG_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import DAO.PreferitiCoverDAO;


public class PreferitiCoverImplementazionePG_DAO implements PreferitiCoverDAO {
	
	private static Connection conn;

	public PreferitiCoverImplementazionePG_DAO() {
		
		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JList mostra_preferiti_cover(JList lista) {
		 
		String nomeLogin = GUI.pagina_iniziale.getNomeLogin();
		String nomeLoginAdmin = GUI.adminLogin_frame.getNomeLoginAdmin();
		String query = "select nome from cover, utente, preferiti_cover where preferiti_cover.id_cover = cover.id_cover and preferiti_cover.id_utente = utente.user_id and (utente.username = '" +nomeLogin+ "' or utente.username = '" +nomeLoginAdmin+ "') order by cover.nome";
		DefaultListModel model = new DefaultListModel();  

	    Statement st = null;
	    ResultSet rs = null;
	    try {
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
	    
	    try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return lista;
}
	public void aggiungi_preferito_cover(String traccia) {

		PreparedStatement ps  = null;
	    String ut1 = GUI.pagina_iniziale.getNomeLogin();
	    String ut2 = GUI.adminLogin_frame.getNomeLoginAdmin();
		
		String query = "INSERT INTO preferiti_cover(id_utente, id_cover) SELECT user_id, id_cover from utente, cover where cover.nome = ? and (utente.username = ? or utente.username = ?)";
		
		try {
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
	    
	    try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
 
 public void rimuovi_preferito_cover(String traccia) {

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
	    try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
