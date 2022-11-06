package Controller;

import Model.*;

import java.sql.SQLException;

import javax.swing.*;
import DAO.*;
import ImplementazioniPG_DAO.*;
import ConfigurazioneDB.ConnessioneDB;

public class Controller {

	Album A;
	AscoltoTraccia AT;
	Cover C;
	Preferiti P;
	PreferitiCover PC;
	Traccia T;
	Utente U;

	public Controller() {

	}
	
	public void mostra_ascoltiTracce(JTable table, Utente U) {
		AscoltoTracciaDAO AT_DAO = new AscoltoTracciaImplementazionePG_DAO();
		AT_DAO.mostra_ascoltiTracce(table, U);
	}
	
	public boolean controllaLoginAdmin(Utente U) throws SQLException {
		UtenteDAO U_DAO = new UtenteImplementazionePG_DAO();
		return U_DAO.checkLoginAdmin(U);
	}
	
	public boolean controllaLoginUtente(Utente U) throws SQLException {
		UtenteDAO U_DAO = new UtenteImplementazionePG_DAO();
		return U_DAO.checkLogin(U);
	}

	public void registraUtente() {
		UtenteDAO U_DAO = new UtenteImplementazionePG_DAO();
		U_DAO.registra_utente(GUI.registrazione.getNomeReg(), GUI.registrazione.getPasswordReg());
	}

	public Utente userData() {
		UtenteDAO U_DAO = new UtenteImplementazionePG_DAO();
		return U_DAO.utenteLoggato();
	}

	public boolean controlloAdmin(Utente U) throws SQLException {
		UtenteDAO U_DAO = new UtenteImplementazionePG_DAO();
		return U_DAO.checkIfAdmin(U);
	}

	public void listaAlbum(JList lista) {
		AlbumDAO Al_DAO = new AlbumImplementazionePG_DAO();
		Al_DAO.mostra_album(lista);
	}

	public void listaUtenti(JList lista) {
		UtenteDAO U_DAO = new UtenteImplementazionePG_DAO();
		U_DAO.mostra_utenti(lista);
	}

	public void listaAdmin(JList lista) {
		UtenteDAO U_DAO = new UtenteImplementazionePG_DAO();
		U_DAO.mostra_admin(lista);
	}

	public void listaTracce(JList lista) {
		TracciaDAO T_DAO = new TracceImplementazionePG_DAO();
		T_DAO.mostra_tracce(lista);
	}

	public void listaCover(JList lista) {
		CoverDAO C_DAO = new CoverImplementazionePG_DAO();
		C_DAO.mostra_cover(lista);
	}

	public void listaPreferiti(JList lista, Utente U) {
		PreferitiDAO P_DAO = new PreferitiImplementazionePG_DAO();
		P_DAO.mostra_preferiti(lista, U);
	}

	public void listaPreferitiCover(JList lista, Utente U) {
		PreferitiCoverDAO PC_DAO = new PreferitiCoverImplementazionePG_DAO();
		PC_DAO.mostra_preferiti_cover(lista, U);
	}



}
