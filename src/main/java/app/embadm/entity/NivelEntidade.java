package app.embadm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

//@Entity
//@Table(name = "nivel")
public class NivelEntidade {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(nullable = false)
//    @NotBlank
    private String nivel;

//    @Column(nullable = false)
//    @NotBlank
    private String nomenclatura;

    private Boolean ativo;

//    @ManyToMany
//    @JoinTable(name = "niveisPessoas",
//    joinColumns = { @JoinColumn(name = "idNivel") },
//    inverseJoinColumns = { @JoinColumn(name = "cpfPessoa")} )
    private List<PessoaEntidade> pessoas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<PessoaEntidade> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaEntidade> pessoas) {
        this.pessoas = pessoas;
    }
}
