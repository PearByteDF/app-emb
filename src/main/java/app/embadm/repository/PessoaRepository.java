package app.embadm.repository;

import app.embadm.entity.PessoaEntidade;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaEntidade, Integer> {

    @Transactional
    @Modifying
    int deleteByCpf (String cpf);

    @Transactional
    PessoaEntidade findByCpf (String cpf);

    @Transactional
    @Query("SELECT pe FROM pessoa pe " +
            "INNER JOIN perfil per ON pe.perfil.id = per.id " +
            "WHERE pe.nome LIKE %:nome% AND pe.cpf LIKE %:cpf% AND pe.perfil.perfil LIKE %:perfil% ")
    List<PessoaEntidade> filtrarPessoa (@Param("nome") String nome,
                                        @Param("cpf") String cpf,
                                        @Param("perfil") String id_perfil);

}
