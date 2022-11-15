package Model;

public class AscoltoTraccia {

	private int id_ascolto;
	private int id_utente;
	private int id_traccia;
	private int num_ascolti;
	private String fascia_oraria;

	public AscoltoTraccia(int id_ascolto, int id_utente, int id_traccia, int num_ascolti, String fascia_oraria) {
		super();
		this.id_ascolto = id_ascolto;
		this.id_utente = id_utente;
		this.id_traccia = id_traccia;
		this.num_ascolti = num_ascolti;
		this.fascia_oraria = fascia_oraria;
	}

	public int getId_ascolto() {
		return id_ascolto;
	}

	public void setId_ascolto(int id_ascolto) {
		this.id_ascolto = id_ascolto;
	}

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
