package ImplementazioniPG_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class listaUtenti {
	
	public static JList mostra_admin(JList lista) {
		
		String query = "select username from utente where admin = true order by username";
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
			    String itemCode = null;
				try {
					itemCode = rs.getString("username");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			    model.addElement(itemCode);  
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
	
	public static JList mostra_utenti(JList lista) {
		
		String query = "select username from utente where admin = false order by username";
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
			    String itemCode = null;
				try {
					itemCode = rs.getString("username");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			    model.addElement(itemCode);  
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
