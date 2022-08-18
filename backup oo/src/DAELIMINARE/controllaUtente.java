package DAELIMINARE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class controllaUtente { 
	
	public static boolean checkUserAdmin(Connection conn, String user_name) throws SQLException {

        String query = " ";
        ResultSet rs = null;
        conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();

        do {
        	query = "select * from utente where username = ? and admin = true" ;
        			
        	PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, user_name);
            
            rs = ps.executeQuery();
            
            if (rs.next()) return true;
            else return false;
        }while (!rs.next());
    } 

}
