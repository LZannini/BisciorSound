package Model;

public class Cover {

	private String autore;
	private int anno_nascita;
	private int anno_rivisitazione;
	private String nome;
	private String album;
	private int id_cover;
	private int traccia_originale;

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getAnno_nascita() {
		return anno_nascita;
	}

	public void setAnno_nascita(int anno_nascita) {
		this.anno_nascita = anno_nascita;
	}

	public int getAnno_rivisitazione() {
		return anno_rivisitazione;
	}

	public void setAnno_rivisitazione(int anno_rivisitazione) {
		this.anno_rivisitazione = anno_rivisitazione;
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

	public int getId_cover() {
		return id_cover;
	}

	public void setId_cover(int id_cover) {
		this.id_cover = id_cover;
	}
	
	public int getTraccia_originaler() {
		return traccia_originale;
	}

	public void setTraccia_originale(int traccia_originale) {
		this.traccia_originale = traccia_originale;
	}

	public Cover(String autore, int anno_nascita, int anno_rivisitazione, String nome, String album, int id_cover, int traccia_originale) {
		super();
		this.autore = autore;
		this.anno_nascita = anno_nascita;
		this.anno_rivisitazione = anno_rivisitazione;
		this.nome = nome;
		this.album = album;
		this.id_cover = id_cover;
		this.traccia_originale = traccia_originale;
	}
}
