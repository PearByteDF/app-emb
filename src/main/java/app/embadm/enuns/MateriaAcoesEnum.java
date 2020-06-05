package app.embadm.enuns;

import app.embadm.Acao;

public enum MateriaAcoesEnum implements Acao {

    REDIRECIONAR_MATERIA_PARA_ENDPOINT_DE_LISTAGEM("redirect:/materias/listar-materias"),
    LISTAR_MATERIA_TEMPLATE("materia/listar-materias"),
    INCLUIR_MATERIA("materia/inserir-materia");

    private String acao;

    @Override
    public String getAcao() {
        return acao;
    }

    MateriaAcoesEnum(String acao) {
        this.acao = acao;
    }

}
