package DAO;
import javax.swing.*;

public interface PreferitiDAO {
	
    JList mostra_preferiti(JList lista);
    void aggiungi_preferito(String traccia);
    void rimuovi_preferito(String traccia);

}
