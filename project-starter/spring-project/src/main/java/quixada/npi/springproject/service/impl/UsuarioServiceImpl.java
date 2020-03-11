package quixada.npi.springproject.service.impl;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.repository.UsuarioRepository;
import quixada.npi.springproject.service.UsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public void delete(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario update(String email, Usuario user) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        usuario.setPassword(user.getPassword());
        usuario.setEmail(user.getEmail());
        usuario.setHabilitado(user.isHabilitado());
        usuario.setNome(user.getNome());
        return  usuarioRepository.save(usuario);
    }


    @Override
    public Usuario createUser(Usuario user) {
        return usuarioRepository.save(user);

    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

}
