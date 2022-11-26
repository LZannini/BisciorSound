package DAO;

import javax.swing.JList;
import Model.PreferitiCover;
import Model.Utente;
import Model.Cover;

public interface PreferitiCoverDAO {

	JList mostra_preferiti_cover(JList lista, Utente U);

	void aggiungi_preferito_cover(Cover C, Utente U);

	void rimuovi_preferito_cover(Cover C, Utente U);
}
