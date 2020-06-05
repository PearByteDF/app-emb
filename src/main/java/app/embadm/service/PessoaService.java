package app.embadm.service;

import app.embadm.RespostaAbstrata;
import app.embadm.entity.PessoaEntidade;
import app.embadm.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PessoaService extends RespostaAbstrata {

    @Autowired
    private PessoaRepository pessoaRepository;
    private static final String LISTA_PESSOAS = "listarPessoas";
    private static final String ATRIBUTO_PESSOA = "pessoa";

    public PessoaService() {
        super();
    }

    public PessoaService salvarPessoa (PessoaEntidade pessoa) {
        pessoaRepository.save(pessoa);
        return this;
    }

    public PessoaService listarTodasPessoas () {
        adicionarAtributoDaResposta(LISTA_PESSOAS, StreamSupport
            .stream(pessoaRepository.findAll().spliterator(), false)
            .collect(Collectors.toList()));
        return this;
    }

    public PessoaService deletarPessoaPorCpf (String cpf) {
        pessoaRepository.deleteByCpf(cpf);
        return this;
    }

    public PessoaService obterPessoaPorCpf (String cpf) {
        adicionarAtributoDaResposta(ATRIBUTO_PESSOA, pessoaRepository.findByCpf(cpf));
        return this;
    }

    public PessoaService obterPessoaPorId (Integer id) {
        adicionarAtributoDaResposta(ATRIBUTO_PESSOA, pessoaRepository
                .findById(id).orElseGet(PessoaEntidade::new));
        return this;
    }
    
}
