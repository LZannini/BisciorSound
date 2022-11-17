package ImplementazioniPG_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Model.*;
import DAO.CoverDAO;
import GUI.*;

public class CoverImplementazionePG_DAO implements CoverDAO {

	private Connection conn;

	public CoverImplementazionePG_DAO() {

		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JList mostra_cover(JList lista) {

		String query = "select nome from cover order by nome";
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
			while (rs.next()) {
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
	
	public boolean hasCover(String nome_traccia) {
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from cover where cover.nome LIKE '%" + nome_traccia + "%'");
			if (rs.next()) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	
	public Cover coverSelezionata(String nome_cover) {

		Cover C = null;

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from cover where nome = '" + nome_cover
					+ "' ");
			while (rs.next()) {
				C = new Cover(rs.getString("autore"), rs.getInt("anno_nascita"), rs.getInt("anno_rivisitazione"),
						rs.getString("nome"), rs.getString("album"), rs.getInt("id_cover"), rs.getInt("traccia_originale"));
			}
			rs.close();
			st.close();
			return C;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
