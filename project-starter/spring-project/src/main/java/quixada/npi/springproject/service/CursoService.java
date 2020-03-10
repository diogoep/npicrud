package quixada.npi.springproject.service;


import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.model.Usuario;

import java.util.List;

public interface CursoService {
    void deleteCurso(Integer id);

    Curso updateCurso(Integer id, Curso curso);

    Curso createCurso(Curso curso);

    List<Curso> findAll();
}
