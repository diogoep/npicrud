package quixada.npi.springproject.repository;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.model.Usuario;

import java.util.List;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    @Query("SELECT new Curso(c.id, c.nome, c.sigla, c.turno) FROM Curso c")
    List<Curso> findAll();

}
