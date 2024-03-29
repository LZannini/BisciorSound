package DAO;

import Model.*;
import java.sql.SQLException;

import javax.swing.*;

public interface UtenteDAO {

	JList mostra_utenti(JList lista);

	JList mostra_admin(JList lista);

	boolean checkLogin(Utente U) throws SQLException;

	boolean checkLoginAdmin(Utente U) throws SQLException;

	boolean checkIfAdmin(Utente U) throws SQLException;

	void registra_utente(String user_name, String user_password);

	Utente utenteLoggato();
	
	public boolean checkUserIfExists(String nome_utente);

}
