package quixada.npi.springproject.service.impl;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.repository.CursoRepository;
import quixada.npi.springproject.repository.UsuarioRepository;
import quixada.npi.springproject.service.CursoService;
import quixada.npi.springproject.service.UsuarioService;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void deleteCurso(Integer id) {
        Curso curso = cursoRepository.findById(id).get();
        cursoRepository.delete(curso);
    }

    @Override
    public Curso updateCurso(Integer id, Curso course) {
        Curso curso = cursoRepository.findById(id).get();
        curso.setNome(course.getNome());
        curso.setSigla(course.getSigla());
        curso.setTurno(course.getTurno());
        return cursoRepository.save(curso);
    }


    @Override
    public Curso createCurso(Curso curso) {
         return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

}
