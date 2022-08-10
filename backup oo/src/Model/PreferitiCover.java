package Model;

public class PreferitiCover {
	
	private int id_utente;
	private int id_cover;
	
	public int getId_utente() {
		return id_utente;
	}
	
	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}
	
	public int getId_cover() {
		return id_cover;
	}
	
	public void setId_cover(int id_cover) {
		this.id_cover = id_cover;
	}

	public PreferitiCover(int id_utente, int id_cover) {
		super();
		this.id_utente = id_utente;
		this.id_cover = id_cover;
	}
}
