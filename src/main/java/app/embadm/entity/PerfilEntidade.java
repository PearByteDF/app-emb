package app.embadm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "perfil")
@Table(name = "perfil")
public class PerfilEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    private String perfil;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
