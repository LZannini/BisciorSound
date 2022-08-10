package DAO;

import javax.swing.JList;

public interface PreferitiCoverDAO {
	
	public JList mostra_preferiti_cover(JList lista);
	public void aggiungi_preferito_cover(String traccia);
	public void rimuovi_preferito_cover(String traccia);

}
