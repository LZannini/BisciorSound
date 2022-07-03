package FunzioniDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.JList;

import GUI.pagina_iniziale;

public class checkLogin {
	
	public static String checkUsername() {
		
		String query = "select username from utente where admin = false";
		DefaultListModel model = new DefaultListModel();  

	    Statement st = null;
	    ResultSet rs = null;
	    Connection conn = null;
		String Check_Login=" ";
		String RisultatoQuery = " ";
		
		Check_Login = pagina_iniziale.getNomeLogin();
		
		
		
	    
		
		try {
			conn = ConfigurazioneDB.ConnessioneDB.connetti();
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
					RisultatoQuery = rs.getString("username");
					System.out.println(" " +RisultatoQuery);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			     
			}	 
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     
	    

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
		return RisultatoQuery;
	}
}