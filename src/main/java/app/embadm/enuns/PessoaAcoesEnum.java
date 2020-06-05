package app.embadm.enuns;

import app.embadm.Acao;

public enum PessoaAcoesEnum implements Acao {

    REDIRECIONAR_PESSOA("redirect:/pessoas/listar-pessoas"),
    LISTAR_PESSOA_ENDPOINT("pessoa/listar-pessoas"),
    INCLUIR_PESSOA("pessoa/inserir-pessoa");

    private String acao;

    @Override
    public String getAcao() {
        return acao;
    }

    PessoaAcoesEnum(String acao) {
        this.acao = acao;
    }
}
