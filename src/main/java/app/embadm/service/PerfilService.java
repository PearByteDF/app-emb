package app.embadm.service;

import app.embadm.entity.PerfilEntidade;
import app.embadm.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public void salvaPerfil (PerfilEntidade perfil) {
        perfilRepository.save(perfil);
    }

    public List<PerfilEntidade> listarTodosOsPerfis () {
        return StreamSupport.stream(perfilRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deletarPerfil (Integer id) {
        perfilRepository.deleteById(id);
    }

    public PerfilEntidade obterPerfilPorId (Integer id) {
        return perfilRepository.findById(id).get();
    }

}
