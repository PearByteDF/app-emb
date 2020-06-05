package app.embadm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

//@Entity
//@Table(name = "curso")
public class CursoEntidade {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(nullable = false)
//    @NotBlank
    private String nome;
    private String descricao;
    private Boolean ativo;

//    @ManyToMany
//    @JoinTable(name = "cursosMaterias",
//    joinColumns = {@JoinColumn(name = "idCurso")},
//    inverseJoinColumns = {@JoinColumn(name = "idMateria")})
    private List<MateriaEntidade> materias;

//    @ManyToMany
//    @JoinTable(name = "cursosPessoas",
//    joinColumns = {@JoinColumn(name = "idCurso")},
//    inverseJoinColumns = {@JoinColumn(name = "cpfPessoa")})
    private List<PessoaEntidade> pessoas;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<MateriaEntidade> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaEntidade> materias) {
        this.materias = materias;
    }

    public List<PessoaEntidade> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaEntidade> pessoas) {
        this.pessoas = pessoas;
    }
}
