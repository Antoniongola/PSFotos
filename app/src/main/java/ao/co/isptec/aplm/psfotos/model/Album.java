package ao.co.isptec.aplm.psfotos.model;

public class Album {
    private long id;
    private String nome;

    public Album(){

    }

    public Album(long id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
