package DAO;
import java.sql.SQLException;

import javax.swing.*;

public interface UtenteDAO {
	
	JList mostra_utenti(JList lista);
	JList mostra_admin(JList lista);
	boolean checkLogin(String user_name, String user_password) throws SQLException;
    boolean checkLoginAdmin(String user_name, String user_password) throws SQLException;
    boolean checkIfAdmin(String user_name) throws SQLException;
    void registra_utente(String user_name, String user_password);
    
}
