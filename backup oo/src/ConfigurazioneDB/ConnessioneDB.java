package ConfigurazioneDB;

import java.sql.*;

public class ConnessioneDB {

	private static ConnessioneDB instance;
	private Connection conn = null;
	private String user = "postgres";
	private String password = "universita10";
	private String url = "jdbc:postgresql:LibreriaMusicale_db";
	private String driver = "org.postgresql.Driver";

	public ConnessioneDB() throws SQLException {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			if (conn != null)
				System.out.println("Connessione con il DB avvenuta con successo!");
		} catch (ClassNotFoundException ex) {
			System.out.println("Impossibile connettere il DB!");
			ex.printStackTrace();
		}
	}

	public Connection getConnection() {

		return conn;
	}

	public static ConnessioneDB getInstance() throws SQLException {
		if (instance == null) {
			instance = new ConnessioneDB();
		} else if (instance.getConnection().isClosed()) {
			instance = new ConnessioneDB();
		}
		return instance;
	}
}
