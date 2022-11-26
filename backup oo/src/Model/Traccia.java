package Model;

public class Traccia {

	private int id_track;
	private String autore;
	private int versione;
	private String nome;
	private String album;

	public int getId_track() {
		return id_track;
	}

	public void setId_track(int id_track) {
		this.id_track = id_track;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getVersione() {
		return versione;
	}

	public void setVersione(int versione) {
		this.versione = versione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Traccia(int id_track, String autore, int versione, String nome, String album) {
		super();
		this.id_track = id_track;
		this.autore = autore;
		this.versione = versione;
		this.nome = nome;
		this.album = album;
	}
}
