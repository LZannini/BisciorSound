package DAO;

import javax.swing.*;

import Model.Cover;

public interface CoverDAO {

	JList mostra_cover(JList lista);
	
	public Cover coverSelezionata(String nome_cover);
}
