package Model;

public class AscoltoCover {

	private int id_ascoltoc;
	private int id_utente;
	private int id_cover;
	private int num_ascolti;
	private String fascia_oraria;

	public AscoltoCover(int id_ascoltoc, int id_utente, int id_cover, int num_ascolti, String fascia_oraria) {
		super();
		this.id_ascoltoc = id_ascoltoc;
		this.id_utente = id_utente;
		this.id_cover = id_cover;
		this.num_ascolti = num_ascolti;
		this.fascia_oraria = fascia_oraria;
	}

	public int getId_ascoltoc() {
		return id_ascoltoc;
	}

	public void setId_ascoltoc(int id_ascoltoc) {
		this.id_ascoltoc = id_ascoltoc;
	}

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

	public int getNum_ascolti() {
		return num_ascolti;
	}

	public void setNum_ascolti(int num_ascolti) {
		this.num_ascolti = num_ascolti;
	}

	public String getFascia_oraria() {
		return fascia_oraria;
	}

	public void setFascia_oraria(String fascia_oraria) {
		this.fascia_oraria = fascia_oraria;
	}

}
