package app.embadm.controller;

import app.embadm.entity.PessoaEntidade;
import app.embadm.enuns.PessoaAcoesEnum;
import app.embadm.service.PerfilService;
import app.embadm.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PerfilService perfilService;

    @GetMapping("inserir-pessoa")
    public String inserirPessoa (Model model) {
        return pessoaService.obterPessoaPorId(0)
                .adicionarAtributoDaResposta("perfis", perfilService.listarTodosOsPerfis())
                .uploadAtributosModelo(model)
                .redirecionar(PessoaAcoesEnum.INCLUIR_PESSOA);
    }

    @RequestMapping(path = "salvar-pessoa", method = RequestMethod.POST)
    public String salvar(PessoaEntidade pessoaEntidade) {
        pessoaEntidade.setAtivo(true);
        return pessoaService.salvarPessoa(pessoaEntidade).redirecionar(PessoaAcoesEnum.REDIRECIONAR_PESSOA);
    }

    @GetMapping("listar-pessoas")
    public String listarPessoas (Model model) {
        return pessoaService.listarTodasPessoas()
                .uploadAtributosModelo(model)
                .redirecionar(PessoaAcoesEnum.LISTAR_PESSOA_ENDPOINT);
    }

    @RequestMapping(path = "/deletar-pessoa/{cpf}")
    public String deletarPessoaPorCpf (@PathVariable("cpf") String cpf, Model model) {
        return pessoaService.deletarPessoaPorCpf(cpf).listarTodasPessoas().uploadAtributosModelo(model)
                .redirecionar(PessoaAcoesEnum.REDIRECIONAR_PESSOA);
    }

    @GetMapping("atualizar-pessoa/{cpf}")
    public String atualizarPessoaPorCpf (@PathVariable("cpf") String cpf, Model model) {
        return pessoaService.obterPessoaPorCpf(cpf)
            .adicionarAtributoDaResposta("perfis", perfilService.listarTodosOsPerfis())
            .uploadAtributosModelo(model)
            .redirecionar(PessoaAcoesEnum.INCLUIR_PESSOA);
    }

}
