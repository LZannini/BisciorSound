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

import DAO.UtenteDAO;
import GUI.AdminLogin;
import GUI.PaginaIniziale;

public class UtenteImplementazionePG_DAO implements UtenteDAO {

	private Connection conn;
	private Utente U;

	public UtenteImplementazionePG_DAO() {

		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JList mostra_admin(JList lista) {

		String query = "select username from utente where admin = true order by username";
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

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public JList mostra_utenti(JList lista) {

		String query = "select username from utente where admin = false order by username";
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

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;

	}

	public boolean checkLogin(Utente U) throws SQLException {

		String login = " ";
		ResultSet rs = null;

		do {
			login = "select * from utente where username = '" + U.getUsername() + "' and password = '" + U.getPassword()
					+ "' and admin = false";

			PreparedStatement ps = conn.prepareStatement(login);

			rs = ps.executeQuery();

			if (rs.next())
				return true;
			else
				return false;
		} while (!rs.next());

	}

	public Utente utenteLoggato() {

		Utente U = null;

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from utente where (username = '" + PaginaIniziale.getNomeLogin() + "'AND password = '" + PaginaIniziale.getPasswordLogin() + "') OR (username = '" + AdminLogin.getNomeLoginAdmin() + "' AND password = '" + AdminLogin.getPasswordLoginAdmin() + "') ");
			while (rs.next()) {
				U = new Utente(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"),
						rs.getBoolean("admin"));
			}
			rs.close();
			st.close();
			return U;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean checkUserIfExists(String nome_utente) {
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from utente where username = '" + nome_utente + "' ");
			if (rs.next()) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean checkLoginAdmin(Utente U) throws SQLException {

		String login = " ";
		ResultSet rs = null;

		do {
			login = "select * from utente where username = '" + U.getUsername() + "' and password = '" + U.getPassword()
					+ "' and admin = true";

			PreparedStatement ps = conn.prepareStatement(login);

			rs = ps.executeQuery();

			if (rs.next())
				return true;
			else
				return false;
		} while (!rs.next());
	}

	public boolean checkIfAdmin(Utente U) throws SQLException {

		String query = " ";
		ResultSet rs = null;

		do {
			query = "select * from utente where username = '" + U.getUsername() + "' and admin = true";

			PreparedStatement ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			if (rs.next())
				return true;
			else
				return false;
		} while (!rs.next());

	}

	public void registra_utente(String nome_ut, String password) {

		PreparedStatement ps = null;

		String query = "INSERT INTO utente (username, password, admin) VALUES (?, ?, false)";

		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
			ps = conn.prepareStatement(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			ps.setString(1, nome_ut);
			ps.setString(2, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ps.setString(2, password);
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
