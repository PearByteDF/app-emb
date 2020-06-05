package app.embadm.repository;

import app.embadm.entity.MateriaEntidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends CrudRepository<MateriaEntidade, Integer> {

}
