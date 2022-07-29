package FunzioniPG_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkLoginAdmin {
	
	public static boolean checkCredentialsAdmin(Connection conn, String user_name, String user_password) throws SQLException {

        String login = " ";
        ResultSet rs = null;

        do {
        	login = "select * from utente where username = ? and password = ? and admin = true" ;
        			
        	PreparedStatement ps = conn.prepareStatement(login);

            ps.setString(1, user_name);
            ps.setString(2, user_password);
            
            rs = ps.executeQuery();
            
            if (rs.next()) return true;
            else return false;
        }while (!rs.next());
    }

}
