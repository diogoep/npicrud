package quixada.npi.springproject.service;


import quixada.npi.springproject.model.Usuario;

import java.util.List;

public interface UsuarioService {
    void delete(String email);

    Usuario update(String email, Usuario user);

    Usuario findByEmail(String email);

    Usuario createUser(Usuario user);
    
    List<Usuario> findAll();
}
