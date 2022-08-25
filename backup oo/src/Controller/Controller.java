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
	
	public void ListaAlbum() {
		JList lista = new JList();
		AlbumDAO A = new AlbumImplementazionePG_DAO();
		A.mostra_album(lista);
	}
	
   	

	

}
