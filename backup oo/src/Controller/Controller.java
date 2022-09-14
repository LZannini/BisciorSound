package Controller;

import Model.*;

import java.sql.SQLException;

import javax.swing.*;
import DAO.*;
import ImplementazioniPG_DAO.*;
import ConfigurazioneDB.ConnessioneDB;

public class Controller {
	
	Album Al;
	Ascolto As;
	Cover C;
	Preferiti P;
	PreferitiCover PC;
	Traccia T;
	Utente U;
	
    public Controller() {

	}
    
    public Utente UserData() {
    	UtenteDAO U = new UtenteImplementazionePG_DAO();
    	return U.utenteLoggato();
    }
    
    public boolean ControlloAdmin(Utente U) throws SQLException {
    	UtenteDAO U_DAO = new UtenteImplementazionePG_DAO();
    	return U_DAO.checkIfAdmin(U);
    }
	
	public void ListaAlbum(JList lista) {
		AlbumDAO A = new AlbumImplementazionePG_DAO();
		A.mostra_album(lista);
	}
	
	public void ListaUtenti(JList lista) {
		UtenteDAO U = new UtenteImplementazionePG_DAO();
		U.mostra_utenti(lista);
	}
	
	public void ListaAdmin(JList lista) {
		UtenteDAO U = new UtenteImplementazionePG_DAO();
		U.mostra_admin(lista);
	}
	
	public void ListaTracce(JList lista) {
		TracciaDAO T = new TracceImplementazionePG_DAO();
		T.mostra_tracce(lista);
	}
	
	public void ListaCover(JList lista) {
		CoverDAO C = new CoverImplementazionePG_DAO();
		C.mostra_cover(lista);
	}
	
	public void ListaPreferiti(JList lista) {
		PreferitiDAO P = new PreferitiImplementazionePG_DAO();
		P.mostra_preferiti(lista, T, U);
	}
   	
	public void ListaPreferitiCover(JList lista) {
		PreferitiCoverDAO PC = new PreferitiCoverImplementazionePG_DAO();
		PC.mostra_preferiti_cover(lista, C, U);		
	}

	public Album getAl() {
		return Al;
	}

	public void setAl(Album al) {
		this.Al = al;
	}

	public Ascolto getAs() {
		return As;
	}

	public void setAs(Ascolto as) {
		this.As = as;
	}

	public Cover getC() {
		return C;
	}

	public void setC(Cover c) {
		this.C = c;
	}

	public Preferiti getP() {
		return P;
	}

	public void setP(Preferiti p) {
		this.P = p;
	}

	public PreferitiCover getPC() {
		return PC;
	}

	public void setPC(PreferitiCover pC) {
		this.PC = pC;
	}

	public Traccia getT() {
		return T;
	}

	public void setT(Traccia t) {
		this.T = t;
	}

	public Utente getU() {
		return U;
	}

	public void setU(Utente u) {
		this.U = u;
	}	

	
}

