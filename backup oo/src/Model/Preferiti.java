package Model;

public class Preferiti {

	private int id_utente;
	private int id_traccia;

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}

	public int getId_traccia() {
		return id_traccia;
	}

	public void setId_traccia(int id_traccia) {
		this.id_traccia = id_traccia;
	}

	public Preferiti(int id_utente, int id_traccia) {
		super();
		this.id_utente = id_utente;
		this.id_traccia = id_traccia;
	}
}
