package ao.co.isptec.aplm.psfotos.model;

public class AlbumUsers {
    private long id;
    private Album albumFk;
    private User userFk;

    public AlbumUsers(){

    }

    public AlbumUsers(long id, Album albumFk, User userFk) {
        this.id = id;
        this.albumFk = albumFk;
        this.userFk = userFk;
    }

    public AlbumUsers(Album album, User user){
        this.albumFk = album;
        this.userFk = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Album getAlbumFk() {
        return albumFk;
    }

    public void setAlbumFk(Album albumFk) {
        this.albumFk = albumFk;
    }

    public User getUserFk() {
        return userFk;
    }

    public void setUserFk(User userFk) {
        this.userFk = userFk;
    }
}
