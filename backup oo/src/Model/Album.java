package Model;

public class Album {

	private String nome_album;
	private String artista;
	private int anno_uscita;

	public String getNome_album() {
		return nome_album;
	}

	public void setNome_album(String nome_album) {
		this.nome_album = nome_album;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getAnno_uscita() {
		return anno_uscita;
	}

	public Album(String nome_album, String artista, int anno_uscita) {
		super();
		this.nome_album = nome_album;
		this.artista = artista;
		this.anno_uscita = anno_uscita;
	}

	public void setAnno_uscita(int anno_uscita) {
		this.anno_uscita = anno_uscita;
	}
}
