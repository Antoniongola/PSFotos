package ao.co.isptec.aplm.psfotos.service;

import java.util.List;

import ao.co.isptec.aplm.psfotos.DTO.LoginDTO;
import ao.co.isptec.aplm.psfotos.model.User;

public interface UserServiceInterface {
    public boolean cadastro(User user);
    public boolean login(LoginDTO loginDto);
    public List<User> selecionarTodos();
    public User selecionarUser(String username);
}
