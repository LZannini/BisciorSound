package DAO;

import javax.swing.*;

import Model.Traccia;

public interface TracciaDAO {

	JList mostra_tracce(JList lista);

	public Traccia tracciaSelezionata(String nome_traccia);
}
