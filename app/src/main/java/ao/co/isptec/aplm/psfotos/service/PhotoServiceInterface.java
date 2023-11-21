package ao.co.isptec.aplm.psfotos.service;

import ao.co.isptec.aplm.psfotos.model.Photo;

public interface PhotoServiceInterface {
    public Photo adicionarFotoAoAlbum(String username, String nomeDaFoto, long albumId);
}
