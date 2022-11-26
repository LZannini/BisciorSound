package ImplementazioniPG_DAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import DAO.AscoltoTracciaDAO;
import Model.*;
import net.proteanit.sql.DbUtils;

public class AscoltoTracciaImplementazionePG_DAO implements AscoltoTracciaDAO {

	private Connection conn;

	public AscoltoTracciaImplementazionePG_DAO() {

		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void aggiorna_ascolto_traccia(Traccia T, Utente U) {

		PreparedStatement ps = null;

		String query = "UPDATE ascolto_traccia SET num_ascolti = num_ascolti + 1 WHERE id_utente = ? AND id_traccia = ?";
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
	}

	public void aggiungi_ascolto_traccia(Traccia T, Utente U) {

		PreparedStatement ps = null;
		String query = null;

		int rand = (int) (Math.random() * 4);

		if (rand == 0)
			query = "INSERT INTO ascolto_traccia(id_utente, id_traccia, num_ascolti, fascia_oraria) VALUES (?, ?, 1, '00:00 - 06:00')";
		if (rand == 1)
			query = "INSERT INTO ascolto_traccia(id_utente, id_traccia, num_ascolti, fascia_oraria) VALUES (?, ?, 1, '06:00 - 12:00')";
		if (rand == 2)
			query = "INSERT INTO ascolto_traccia(id_utente, id_traccia, num_ascolti, fascia_oraria) VALUES (?, ?, 1, '12:00 - 18:00')";
		if (rand == 3)
			query = "INSERT INTO ascolto_traccia(id_utente, id_traccia, num_ascolti, fascia_oraria) VALUES (?, ?, 1, '18:00 - 00:00')";

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
	}

	public boolean checkListeningTraccia(Traccia T, Utente U) {

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from ascolto_traccia where id_traccia = '" + T.getId_track()
					+ "' AND id_utente = '" + U.getUser_id() + "' ");
			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void riempiAscoltiTraccia(JTable tabella, Utente U) {

		String query = "SELECT traccia.nome, ascolto_traccia.num_ascolti AS Numero_di_ascolti\r\n"
				+ "FROM traccia, ascolto_traccia\r\n"
				+ "WHERE  ascolto_traccia.id_traccia = traccia.id_track AND ascolto_traccia.id_utente = '"
				+ U.getUser_id() + "'\r\n" + "ORDER BY ascolto_traccia.num_ascolti DESC";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			tabella.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void riempiUtentiPiuAscoltiTraccia(JTable tabella, Traccia T) {

		String query = "SELECT utente.username AS nome, ascolto_traccia.num_ascolti AS numero_di_ascolti\r\n"
				+ "FROM utente, traccia, ascolto_traccia\r\n"
				+ "WHERE ascolto_traccia.num_ascolti >= 10 AND traccia.id_track = ascolto_traccia.id_traccia AND utente.user_id = ascolto_traccia.id_utente AND traccia.nome = '"
				+ T.getNome() + "' \r\n" + "ORDER BY ascolto_traccia.num_ascolti DESC";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			tabella.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void riempiFasciaOrariaPiuAscoltiTraccia(JTable tabella, String nome_utente) {

		String query = "SELECT ascolto_traccia.fascia_oraria, sum(ascolto_traccia.num_ascolti) AS max_ascolti\r\n"
				+ "FROM ascolto_traccia, utente \r\n"
				+ "WHERE ascolto_traccia.id_utente = utente.user_id and utente.username = '" + nome_utente + "'\r\n"
				+ "GROUP BY ascolto_traccia.fascia_oraria\r\n" + "ORDER BY max_ascolti DESC\r\n" + "LIMIT 1";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			tabella.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
