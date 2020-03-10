package quixada.npi.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.service.CursoService;
import quixada.npi.springproject.service.UsuarioService;

import java.util.List;

@RestController
public class CursoController{

    @Autowired
    private CursoService cursoService;

    @GetMapping("/cursos")
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok(cursoService.findAll());
    }

    @PutMapping("/editCurso/{id}")
    public ResponseEntity<Curso> edit(@PathVariable("id") Integer id, @RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.updateCurso(id, curso));
    }

    @PostMapping("/formCurso")
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.createCurso(curso));
    }

    @DeleteMapping(value="/deleteCurso/{id}")
    public ResponseEntity<Curso> delete(@PathVariable("id") Integer id){
        cursoService.deleteCurso(id);
        return ResponseEntity.ok().build();
    }

    //@PutMapping("{id}")
    /*public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {

    }*/



}
