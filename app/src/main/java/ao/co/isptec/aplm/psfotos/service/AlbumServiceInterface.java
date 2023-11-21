package ao.co.isptec.aplm.psfotos.service;

import java.util.List;

import ao.co.isptec.aplm.psfotos.DTO.AlbumUsersDto;
import ao.co.isptec.aplm.psfotos.model.Album;
import ao.co.isptec.aplm.psfotos.model.AlbumUsers;
import ao.co.isptec.aplm.psfotos.model.User;

public interface AlbumServiceInterface {
    public boolean criarAlbum(Album album, String username);
    public boolean adicionarParticipantesAoAlbum(String username, long albumId, AlbumUsersDto usersDto);
    public List<User> participantesDoAlbum(long albumId, String username);
    public List<AlbumUsers> usersDeTodosAlbumsNaNuvem();
    public List<Album> myAlbums(String username);
}
