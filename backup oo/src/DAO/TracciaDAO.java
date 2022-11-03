package DAO;

import javax.swing.*;

import Model.Traccia;

public interface TracciaDAO {

	JList mostra_tracce(JList lista);

	String[] sfogliaTracce();

}
