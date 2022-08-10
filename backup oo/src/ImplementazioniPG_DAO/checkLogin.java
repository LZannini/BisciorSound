package ImplementazioniPG_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class checkLogin {
	
	public static boolean checkCredentials(Connection conn, String user_name, String user_password) throws SQLException {

        String login = " ";
        ResultSet rs = null;
        conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();

        do {
        	login = "select * from utente where username = ? and password = ? and admin = false" ;
        			
        	PreparedStatement ps = conn.prepareStatement(login);

            ps.setString(1, user_name);
            ps.setString(2, user_password);
            
            rs = ps.executeQuery();
            
            if (rs.next()) return true;
            else return false;
        }while (!rs.next());
    }  
	
}