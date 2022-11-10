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
	AscoltoCover AC;
	Cover C;
	PreferitiTracce PT;
	PreferitiCover PC;
	Traccia T;
	Utente U;

	public Controller() {

	}
	
	public void mostraFasceOrariePiuAscolti(JTable tabella1, JTable tabella2, String nome_utente) {
		AscoltoCoverDAO AC_DAO = new AscoltoCoverImplementazionePG_DAO();
		AscoltoTracciaDAO AT_DAO = new AscoltoTracciaImplementazionePG_DAO();
		AC_DAO.riempiFasciaOrariaPiuAscoltiCover(tabella2, nome_utente);
		AT_DAO.riempiFasciaOrariaPiuAscoltiTraccia(tabella1, nome_utente);
	}
	
	public void utentiPiuAscoltiCoverData(JTable tabella, Traccia T) {
		AscoltoCoverDAO AC_DAO = new AscoltoCoverImplementazionePG_DAO();
		AC_DAO.riempiUtentiPiuAscoltiCover(tabella, T);
	}
	
	public void utentiPiuAscoltiTracciaData(JTable tabella, Traccia T) {
		AscoltoTracciaDAO AT_DAO = new AscoltoTracciaImplementazionePG_DAO();
		AT_DAO.riempiUtentiPiuAscoltiTraccia(tabella, T);
	}
	
	public void ascoltiTracciaData(JTable tabella, Utente U) {
		AscoltoTracciaDAO AT_DAO = new AscoltoTracciaImplementazionePG_DAO();
		AT_DAO.riempiAscoltiTraccia(tabella, U);
	}
	
	public void ascoltiCoverData(JTable tabella, Utente U) {
		AscoltoCoverDAO AC_DAO = new AscoltoCoverImplementazionePG_DAO();
		AC_DAO.riempiAscoltiCover(tabella, U);
	}
	
	public Traccia trackData(String nome_traccia) {
		TracciaDAO T_DAO = new TracciaImplementazionePG_DAO();
		return T_DAO.tracciaSelezionata(nome_traccia);
	}
	
	public Cover coverData(String nome_cover) {
		CoverDAO C_DAO = new CoverImplementazionePG_DAO();
		return C_DAO.coverSelezionata(nome_cover);
	}
	
	public void removePreferitoTraccia(Traccia T, Utente U) {
		PreferitiTracceDAO PT_DAO = new PreferitiTracciaImplementazionePG_DAO();
		PT_DAO.rimuovi_preferito(T, U);
	}
	
	public void removePreferitoCover(Cover C, Utente U) {
		PreferitiCoverDAO PC_DAO = new PreferitiCoverImplementazionePG_DAO();
		PC_DAO.rimuovi_preferito_cover(C, U);
	}
	
	public void addPreferitoTraccia(Traccia T, Utente U) {
		PreferitiTracceDAO PT_DAO = new PreferitiTracciaImplementazionePG_DAO();
		PT_DAO.aggiungi_preferito(T, U);
	}
	
	public void addPreferitoCover(Cover C, Utente U) {
		PreferitiCoverDAO PC_DAO = new PreferitiCoverImplementazionePG_DAO();
		PC_DAO.aggiungi_preferito_cover(C, U);
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
		U_DAO.registra_utente(GUI.Registrazione.getNomeReg(), GUI.Registrazione.getPasswordReg());
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
		TracciaDAO T_DAO = new TracciaImplementazionePG_DAO();
		T_DAO.mostra_tracce(lista);
	}

	public void listaCover(JList lista) {
		CoverDAO C_DAO = new CoverImplementazionePG_DAO();
		C_DAO.mostra_cover(lista);
	}

	public void listaPreferiti(JList lista, Utente U) {
		PreferitiTracceDAO P_DAO = new PreferitiTracciaImplementazionePG_DAO();
		P_DAO.mostra_preferiti(lista, U);
	}

	public void listaPreferitiCover(JList lista, Utente U) {
		PreferitiCoverDAO PC_DAO = new PreferitiCoverImplementazionePG_DAO();
		PC_DAO.mostra_preferiti_cover(lista, U);
	}



}
