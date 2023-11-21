package ao.co.isptec.aplm.psfotos.DTO;

public class AlbumUsersDto {
    private String username;

    public AlbumUsersDto() {

    }

    public AlbumUsersDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
