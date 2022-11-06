package DAO;

import Model.*;
import javax.swing.*;

public interface PreferitiDAO {

	JList mostra_preferiti(JList lista, Utente U);

	void aggiungi_preferito(Traccia T, Utente U);

	void rimuovi_preferito(Traccia T, Utente U);

}
