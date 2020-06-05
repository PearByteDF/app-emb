package app.embadm.service;

import app.embadm.RespostaAbstrata;
import app.embadm.entity.MateriaEntidade;
import app.embadm.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MateriaService extends RespostaAbstrata {

    @Autowired
    private MateriaRepository materiaRepository;
    private static final String LISTAR_MATERIAS = "listarMaterias";
    private static final String ATRIBUTO_MATERIA = "materia";

    public MateriaService() {
        super();
    }

    public MateriaService salvarMateria (MateriaEntidade materiaEntidade) {
        materiaRepository.save(materiaEntidade);
        return this;
    }

    public MateriaService listarTodasMaterias() {
        adicionarAtributoDaResposta(LISTAR_MATERIAS, StreamSupport.stream(materiaRepository
                .findAll().spliterator(), false).collect(Collectors.toList()));
        return this;
    }

    public MateriaService deletarMateriaPorId(Integer idMateria) {
        materiaRepository.deleteById(idMateria);
        return this;
    }

    public MateriaService obterMateriaPorId (Integer idMateria) {
        adicionarAtributoDaResposta(ATRIBUTO_MATERIA, materiaRepository
                .findById(idMateria).orElseGet(MateriaEntidade::new));
        return this;
    }
}
