package app.embadm.repository;

import app.embadm.entity.PessoaEntidade;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaEntidade, Integer> {

    @Transactional
    @Modifying
    int deleteByCpf (String cpf);

    @Transactional
    PessoaEntidade findByCpf (String cpf);

}
