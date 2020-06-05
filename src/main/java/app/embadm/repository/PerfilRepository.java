package app.embadm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.embadm.entity.PerfilEntidade;

@Repository
public interface PerfilRepository extends CrudRepository<PerfilEntidade, Integer> {

}
