package Controller;

import Model.*;
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
	
	UtenteDAO UD = new UtenteImplementazionePG_DAO();
	
	Utente utente1 = new Utente(213, "bellaraga12", "buonasera", false);
	
   	

	

}
