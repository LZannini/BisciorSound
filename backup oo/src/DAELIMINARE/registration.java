package DAELIMINARE;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class registration {
	
	 public static void inserisci_utente(String nome_ut, String password) {

			PreparedStatement ps  = null;
		    Connection conn = null;
			
			nome_ut = GUI.registration_frame.getNomeReg(nome_ut);
			password = GUI.registration_frame.getPasswordReg(password);
			
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
	}
	
}
