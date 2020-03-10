package quixada.npi.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.service.UsuarioService;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PostMapping("/editUsuario/{email}")
    public ResponseEntity<Usuario> edit(@PathVariable("email") String email, @RequestBody Usuario usuario) {
        usuario.setPassword(new BCryptPasswordEncoder(12).encode(usuario.getPassword()));
        return ResponseEntity.ok(usuarioService.update(email, usuario));
    }

    @PostMapping("/formUsuario")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        usuario.setPassword(new BCryptPasswordEncoder(12).encode(usuario.getPassword()));
        return ResponseEntity.ok(usuarioService.createUser(usuario));
    }

    @DeleteMapping(value="/deletarUsuario/{email}")
    public ResponseEntity<Usuario> delete(@PathVariable("email") String email){
        usuarioService.delete(email);
        return ResponseEntity.ok().build();
    }

    // @PutMapping("{id}")
    /*public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {

    }*/



}
