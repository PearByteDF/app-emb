package app.embadm;

import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

public abstract class RespostaAbstrata {

    private Map<String, Object> atributosEValores;

    public RespostaAbstrata() {
        this.atributosEValores = new HashMap<>();
    }

    public RespostaAbstrata uploadAtributosModelo (Model model) {
        atributosEValores.forEach(model::addAttribute);
        return this;
    }

    public RespostaAbstrata adicionarAtributoDaResposta(String chave, Object valor) {
        atributosEValores.put(chave, valor);
        return this;
    }

    public String redirecionar(Acao acaoRedirecionar){
        return acaoRedirecionar.getAcao();
    }

}
