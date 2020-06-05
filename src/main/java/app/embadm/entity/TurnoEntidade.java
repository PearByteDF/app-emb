package app.embadm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

//@Entity
//@Table(name = "turno")
public class TurnoEntidade {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(nullable = false)
//    @NotBlank
    private String nome;

//    @ManyToMany
//    @JoinTable(name = "turnosPessoas",
//    joinColumns = {@JoinColumn(name = "idTurno")},
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

    public List<PessoaEntidade> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaEntidade> pessoas) {
        this.pessoas = pessoas;
    }
}
