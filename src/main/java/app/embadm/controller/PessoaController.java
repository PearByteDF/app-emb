package app.embadm.controller;

import app.embadm.entity.PessoaEntidade;
import app.embadm.enuns.PessoaAcoesEnum;
import app.embadm.service.PerfilService;
import app.embadm.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String inserirPessoa(Model model) {
        return pessoaService.obterPessoaPorId(0)
                .adicionarAtributoDaResposta("perfis", perfilService.listarTodosOsPerfis())
                .uploadAtributosModelo(model)
                .redirecionar(PessoaAcoesEnum.INCLUIR_PESSOA_TEMPLATE);
    }

    @RequestMapping(path = "salvar-pessoa", method = RequestMethod.POST)
    public String salvar(PessoaEntidade pessoaEntidade) {
        pessoaEntidade.setAtivo(true);
        return pessoaService.salvarPessoa(pessoaEntidade).redirecionar(PessoaAcoesEnum.REDIRECIONAR_PESSOA_ENDPOINT);
    }

    @GetMapping("listar-pessoas")
    public String listarPessoas(Model model) {
        return pessoaService.listarTodasPessoas()
                .adicionarAtributoDaResposta("perfis", perfilService.listarTodosOsPerfis())
                .uploadAtributosModelo(model)
                .redirecionar(PessoaAcoesEnum.LISTAR_PESSOA_TEMPLATE);
    }

    @RequestMapping(path = "/deletar-pessoa/{cpf}")
    public String deletarPessoaPorCpf(@PathVariable("cpf") String cpf, Model model) {
        return pessoaService.deletarPessoaPorCpf(cpf).listarTodasPessoas().uploadAtributosModelo(model)
                .redirecionar(PessoaAcoesEnum.REDIRECIONAR_PESSOA_ENDPOINT);
    }

    @GetMapping("atualizar-pessoa/{cpf}")
    public String atualizarPessoaPorCpf(@PathVariable("cpf") String cpf, Model model) {
        return pessoaService.obterPessoaPorCpf(cpf)
                .adicionarAtributoDaResposta("perfis", perfilService.listarTodosOsPerfis())
                .uploadAtributosModelo(model)
                .redirecionar(PessoaAcoesEnum.INCLUIR_PESSOA_TEMPLATE);
    }

    @PostMapping("**/filtar-pessoa")
    public String filtrarPessoa(@RequestParam("nome-pessoa-filtro") String nomePessoaFiltro,
                                @RequestParam("cpf-pessoa-filtro") String cpfPessoaFiltro,
                                @RequestParam("perfil-filtro")String perfilPessoaFiltro, Model model) {
        return pessoaService.filtrarPessoa(nomePessoaFiltro, cpfPessoaFiltro, perfilPessoaFiltro)
                .uploadAtributosModelo(model)
                .redirecionar(PessoaAcoesEnum.LISTAR_PESSOA_TEMPLATE);
    }

}
