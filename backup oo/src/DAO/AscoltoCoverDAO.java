package DAO;

import javax.swing.JTable;
import Model.*;

public interface AscoltoCoverDAO {

	public void riempiAscoltiCover(JTable tabella, Utente U);

	public void riempiUtentiPiuAscoltiCover(JTable tabella, Traccia T);

	public void riempiFasciaOrariaPiuAscoltiCover(JTable tabella, String nome_utente);

	public boolean checkListeningCover(Cover C, Utente U);
	
	public void aggiungi_ascolto_cover(Cover C, Utente U);
	
	public void aggiorna_ascolto_cover(Cover C, Utente U);
}
