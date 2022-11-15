package DAO;

import javax.swing.*;
import Model.*;

public interface AscoltoTracciaDAO {
	
	public void riempiAscoltiTraccia(JTable tabella, Utente U);
	public void riempiUtentiPiuAscoltiTraccia(JTable tabella, Traccia T);
	public void riempiFasciaOrariaPiuAscoltiTraccia(JTable tabella, String nome_utente);

}
