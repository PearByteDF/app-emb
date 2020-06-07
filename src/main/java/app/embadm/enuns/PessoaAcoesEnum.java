package app.embadm.enuns;

import app.embadm.Acao;

public enum PessoaAcoesEnum implements Acao {

    REDIRECIONAR_PESSOA_ENDPOINT("redirect:/pessoas/listar-pessoas"),
    LISTAR_PESSOA_TEMPLATE("pessoa/listar-pessoas"),
    INCLUIR_PESSOA_TEMPLATE("pessoa/inserir-pessoa");

    private String acao;

    @Override
    public String getAcao() {
        return acao;
    }

    PessoaAcoesEnum(String acao) {
        this.acao = acao;
    }
}
