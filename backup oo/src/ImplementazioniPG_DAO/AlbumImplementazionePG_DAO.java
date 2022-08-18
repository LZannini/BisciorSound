package ImplementazioniPG_DAO;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import DAO.AlbumDAO;
import Model.*;

public class AlbumImplementazionePG_DAO implements AlbumDAO {
	
	private static Connection conn;
	
    public AlbumImplementazionePG_DAO() {
		
		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public JList mostra_album(JList lista) {
		
		String query = "select nome_album from album order by nome_album";
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
			    String itemCodeNomeA = null;
				try {
					itemCodeNomeA = rs.getString("nome_album");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			    model.addElement(itemCodeNomeA);  
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
