package app.embadm.entity;

import javax.persistence.*;
import java.util.List;

//@Entity
//@Table(name = "turma")
public class TurmaEntidade {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToMany
//    @JoinTable(name = "turmasPessoas",
//    joinColumns = {@JoinColumn(name = "idTurma")},
//    inverseJoinColumns = {@JoinColumn(name = "cpfPessoa")})
    private List<PessoaEntidade> pessoas;

//    @ManyToMany
//    @JoinTable(name = "turmasTurnos",
//    joinColumns = {@JoinColumn(name = "idTurma")},
//    inverseJoinColumns = {@JoinColumn(name = "idTurno")})
    private List<TurnoEntidade> turnos;

//    @ManyToMany
//    @JoinTable(name = "turmasNiveis",
//    joinColumns = {@JoinColumn(name = "idTurma")},
//    inverseJoinColumns = {@JoinColumn(name = "idNivel")})
    private List<NivelEntidade> niveis;

//    @ManyToOne
//    @JoinColumn(name = "idMateria")
    private MateriaEntidade materia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PessoaEntidade> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaEntidade> pessoas) {
        this.pessoas = pessoas;
    }

    public List<TurnoEntidade> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<TurnoEntidade> turnos) {
        this.turnos = turnos;
    }

    public List<NivelEntidade> getNiveis() {
        return niveis;
    }

    public void setNiveis(List<NivelEntidade> niveis) {
        this.niveis = niveis;
    }

    public MateriaEntidade getMateria() {
        return materia;
    }

    public void setMateria(MateriaEntidade materia) {
        this.materia = materia;
    }
}
