package DAO;

import javax.swing.*;
import Model.*;

public interface AscoltoTracciaDAO {

	public void riempiAscoltiTraccia(JTable tabella, Utente U);

	public void riempiUtentiPiuAscoltiTraccia(JTable tabella, Traccia T);

	public void riempiFasciaOrariaPiuAscoltiTraccia(JTable tabella, String nome_utente);

	public boolean checkListeningTraccia(Traccia T, Utente U);
	
	public void aggiungi_ascolto_traccia(Traccia T, Utente U);
	
	public void aggiorna_ascolto_traccia(Traccia T, Utente U);
}
