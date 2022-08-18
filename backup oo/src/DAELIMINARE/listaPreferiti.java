package DAELIMINARE;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class listaPreferiti {
	
	 public static JList mostra_preferiti(JList lista) {
		 
		 
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
	 
	 public static JList mostra_preferiti_cover(JList lista) {
		 
		 
			String nomeLogin = GUI.pagina_iniziale.getNomeLogin();
			String nomeLoginAdmin = GUI.adminLogin_frame.getNomeLoginAdmin();
			String query = "select nome from cover, utente, preferiti_cover where preferiti_cover.id_cover = cover.id_cover and preferiti_cover.id_utente = utente.user_id and (utente.username = '" +nomeLogin+ "' or utente.username = '" +nomeLoginAdmin+ "') order by cover.nome";
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

}
