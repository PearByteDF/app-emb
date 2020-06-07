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
    @Query("select p FROM pessoa p where p.nome LIKE %:nome% and p.cpf LIKE %:cpf%")
    List<PessoaEntidade> filtrarPorNome (@Param("nome") String nome, @Param("cpf") String cpf);

}
