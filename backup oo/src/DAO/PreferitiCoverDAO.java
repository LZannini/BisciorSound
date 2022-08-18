package DAO;

import javax.swing.JList;
import Model.PreferitiCover;
import Model.Utente;
import Model.Cover;

public interface PreferitiCoverDAO {
	
	JList mostra_preferiti_cover(JList lista, Cover C, Utente U, PreferitiCover PC);
	void aggiungi_preferito_cover(String traccia);
	void rimuovi_preferito_cover(String traccia);

}
