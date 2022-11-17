package ImplementazioniPG_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.*;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import DAO.*;

public class PreferitiTracciaImplementazionePG_DAO implements PreferitiTracceDAO {

	private Connection conn;

	public PreferitiTracciaImplementazionePG_DAO() {

		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JList mostra_preferiti(JList lista, Utente U) {

		String query = "select nome from traccia, utente, preferiti_traccia where preferiti_traccia.id_utente = '" + U.getUser_id()
				+ "' and preferiti_traccia.id_traccia = traccia.id_track and  utente.username = '" + U.getUsername()
				+ "' order by traccia.nome";
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

	public void aggiungi_preferito(Traccia T, Utente U) {

		PreparedStatement ps = null;

		String query = "INSERT INTO preferiti_traccia(id_utente, id_traccia) VALUES (?, ?);";

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, U.getUser_id());
			ps.setInt(2, T.getId_track());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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

	public void rimuovi_preferito(Traccia T, Utente U) {

		PreparedStatement ps = null;

		String query = "delete from preferiti_traccia where id_utente = (select user_id from utente where username = '"
				+ U.getUsername() + "') and id_traccia = (select id_track from traccia where nome = '" + T.getNome()
				+ "')";

		try {
			ps = conn.prepareStatement(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
