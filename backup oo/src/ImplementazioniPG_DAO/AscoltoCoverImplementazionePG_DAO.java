package ImplementazioniPG_DAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import DAO.AscoltoCoverDAO;
import Model.*;
import net.proteanit.sql.DbUtils;

public class AscoltoCoverImplementazionePG_DAO implements AscoltoCoverDAO {

	private Connection conn;

	public AscoltoCoverImplementazionePG_DAO() {

		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void riempiAscoltiCover(JTable tabella, Utente U) {
		
		String query = "SELECT cover.nome, ascolto_cover.num_ascolti AS Numero_di_ascolti\r\n"
				+ "FROM cover, ascolto_cover\r\n"
				+ "WHERE  ascolto_cover.id_cover = cover.id_cover AND ascolto_cover.id_utente = '" + U.getUser_id() + "'\r\n"
				+ "ORDER BY ascolto_cover.num_ascolti DESC";
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
	
	public void riempiUtentiPiuAscoltiCover(JTable tabella, Traccia T) {
		
		String query = "SELECT utente.username AS nome, ascolto_cover.num_ascolti AS numero_di_ascolti \r\n"
				+ "FROM utente, cover, ascolto_cover\r\n"
				+ "WHERE ascolto_cover.num_ascolti >= 10 AND cover.id_cover = ascolto_cover.id_cover AND utente.user_id = ascolto_cover.id_utente AND cover.nome LIKE '%" + T.getNome() + "%' \r\n"
				+ "ORDER BY ascolto_cover.num_ascolti DESC"; 
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
	
	public void riempiFasciaOrariaPiuAscoltiCover(JTable tabella, String nome_utente) {
		
		String query = "SELECT ascolto_cover.fascia_oraria, sum(ascolto_cover.num_ascolti) AS max_ascolti\r\n"
				+ "FROM ascolto_cover, utente \r\n"
				+ "WHERE ascolto_cover.id_utente = utente.user_id and utente.username = '" + nome_utente + "'\r\n"
				+ "GROUP BY ascolto_cover.fascia_oraria\r\n"
				+ "ORDER BY max_ascolti DESC\r\n"
				+ "LIMIT 1";
		
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
	
