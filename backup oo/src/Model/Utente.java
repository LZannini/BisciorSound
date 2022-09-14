package Model;
import Controller.*;

public class Utente {
	
	private int user_id;
	private String username;
	private String password;
	private boolean admin;
	private int id;
	
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public Utente(int user_id, String username, String password, boolean admin) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.admin = admin;
	}

	public boolean checkIfAdmin(Utente u) {
		// TODO Auto-generated method stub
		return false;
	}
}
