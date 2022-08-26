package Controller;

import Model.*;
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
	
   	

	

}
