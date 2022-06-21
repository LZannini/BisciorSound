package ConfigurazioneDB;

import java.sql.*;

public class ConnessioneDB { 
	
	public static Connection connetti() {
        
		Connection conn = null;
	    String url = "jdbc:postgresql://localhost/LibreriaMusicale_db";
	    String user = "postgres";
	    String password = "universita10";
	
	    try {
		    conn = DriverManager.getConnection(url, user, password);
		    if (conn!=null)
			    System.out.println("Connessione con il DB avvenuta con successo!");		    	
	    }catch(SQLException e) {
	    	System.out.println("Impossibile connettere il DB!");
	    }
		return conn;
	}

	public static void main(String[] args) {

        connetti();
		
		// TODO Auto-generated method stub

	}

}
