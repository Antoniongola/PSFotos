package ao.co.isptec.aplm.psfotos.model;

public class Photo {
    private long id;
    private String nome;
    private Album album;

    public Photo(){

    }

    public Photo(long id, String nome, Album album) {
        this.id = id;
        this.nome = nome;
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
