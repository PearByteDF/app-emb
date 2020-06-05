package app.embadm.component;

import app.embadm.entity.PerfilEntidade;
import app.embadm.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PerfilConversor implements Converter<String, PerfilEntidade> {

    @Autowired
    private PerfilService perfilService;

    @Override
    public PerfilEntidade convert (String s) {
        return perfilService.obterPerfilPorId(Integer.parseInt(s));
    }

}
