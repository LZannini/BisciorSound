package ImplementazioniPG_DAO;

import java.sql.Connection;
import java.sql.ResultSet;

import Model.*;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import DAO.TracciaDAO;
import GUI.*;

public class TracciaImplementazionePG_DAO implements TracciaDAO {

	private Connection conn;

	public TracciaImplementazionePG_DAO() {

		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JList mostra_tracce(JList lista) {

		String query = "select nome from traccia order by nome";
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

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public String[] sfogliaTracce() {

		String[] t = new String[128];
		int i, j;

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select nome from traccia");
			for (i = 0; rs.next(); i++) {
				t[i] = rs.getString("nome");
			}
			String[] tmp = new String[i];
			for (j = 0; j < i; j++) {
				tmp[j] = t[j];
			}
			rs.close();
			st.close();
			return tmp;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Traccia tracciaSelezionata(String nome_traccia) {

		Traccia T = null;

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from traccia where nome = '" + nome_traccia
					+ "' ");
			while (rs.next()) {
				T = new Traccia(rs.getInt("id_track"), rs.getString("autore"), rs.getInt("versione"),
						rs.getString("nome"), rs.getString("album"));
			}
			rs.close();
			st.close();
			return T;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
