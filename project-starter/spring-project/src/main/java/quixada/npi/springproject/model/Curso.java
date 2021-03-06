package quixada.npi.springproject.model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Entity
public class Curso {

    private static final long serialVersionUID = 1L;

    public Set<Usuario> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Usuario usuario){
        this.alunos.add(usuario);
    }

    public void removerAluno(Usuario usuario){
        this.alunos.remove(usuario);
    }

    public void setAlunos(Set<Usuario> alunos) {
        this.alunos = alunos;
    }

    @OneToMany(mappedBy="curso")
    private Set<Usuario> alunos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String nome;

    @NotEmpty
    @Column(unique = true)
    private String sigla;

    @NotEmpty
    //@JsonIgnore
    private String turno;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Curso() {}

    public Curso (Integer id, String nome, String sigla, String turno, Set<Usuario> alunos) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.turno = turno;
        this.alunos = alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
