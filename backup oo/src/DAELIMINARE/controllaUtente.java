package DAELIMINARE;

import Model.*;
import DAO.*;
import ImplementazioniPG_DAO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class controllaUtente { 
	
	public static boolean checkUserAdmin(Utente U) throws SQLException {
		
		

        String query = " ";
        ResultSet rs = null;
        Connection conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();

        do {
        	query = "select * from utente where username = '"+U.getUsername()+"' and admin = true" ;
        			
        	PreparedStatement ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            if (rs.next()) return true;
            else return false;
        }while (!rs.next());
    } 

}
