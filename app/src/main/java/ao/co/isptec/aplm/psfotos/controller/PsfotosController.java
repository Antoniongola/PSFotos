package ao.co.isptec.aplm.psfotos.controller;

import java.util.List;

import ao.co.isptec.aplm.psfotos.DTO.AlbumUsersDto;
import ao.co.isptec.aplm.psfotos.DTO.LoginDTO;
import ao.co.isptec.aplm.psfotos.model.Album;
import ao.co.isptec.aplm.psfotos.model.AlbumUsers;
import ao.co.isptec.aplm.psfotos.model.User;
import ao.co.isptec.aplm.psfotos.service.AlbumService;
import ao.co.isptec.aplm.psfotos.service.PhotoService;
import ao.co.isptec.aplm.psfotos.service.UserService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PsfotosController {
    private final UserService userService = new UserService();
    private final AlbumService albumService = new AlbumService();
    private final PhotoService photoService = new PhotoService();

    public boolean login (LoginDTO login){
        return this.userService.login(login);
    }

    public boolean cadastrarUser(User user){
        return this.userService.cadastro(user);
    }

    public User selecionarUser(String username){
        return this.userService.selecionarUser(username);
    }

    public List <User> selecionarTodosUsers(){
        return this.userService.selecionarTodos();
    }

    public boolean criarAlbum(Album album, String username){
       return this.albumService.criarAlbum(album, username);
    }

    public List<Album> myAlbums(String username){
        return this.albumService.myAlbums(username);
    }

    public List<User> participantesDoAlbum(long albumId, String username){
        return this.albumService.participantesDoAlbum(albumId, username);
    }

    public List<AlbumUsers> listaDeTodosUsuariosDeAlbumsNaNuvem(){
        return this.albumService.usersDeTodosAlbumsNaNuvem();
    }

    public boolean adicionarUserAoAlbum(String username, long albumId, AlbumUsersDto usersDto){
        return this.albumService.adicionarParticipantesAoAlbum(username, albumId, usersDto);
    }

}
