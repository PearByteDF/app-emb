package app.embadm.controller;

import app.embadm.entity.MateriaEntidade;
import app.embadm.enuns.MateriaAcoesEnum;
import app.embadm.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping("inserir-materia")
    public String inserirMateria (Model model) {
        MateriaEntidade materia = new MateriaEntidade();
        model.addAttribute("materia", materia);
        return "materia/inserir-materia";
    }

    @RequestMapping(path = "salvar-materia", method = RequestMethod.POST)
    public String salvarMateria (MateriaEntidade materiaEntidade) {
        return materiaService.salvarMateria(materiaEntidade)
                .redirecionar(MateriaAcoesEnum.REDIRECIONAR_MATERIA_PARA_ENDPOINT_DE_LISTAGEM);
    }

    @GetMapping("listar-materias")
    public String listarMaterias (Model model) {
        return materiaService.listarTodasMaterias()
                .uploadAtributosModelo(model)
                .redirecionar(MateriaAcoesEnum.LISTAR_MATERIA_TEMPLATE);
    }

    @RequestMapping(path = "/deletar-materia/{id}")
    public String deletarMateria (@PathVariable Integer id, Model model) {
        return materiaService.deletarMateriaPorId(id).listarTodasMaterias().uploadAtributosModelo(model)
                .redirecionar(MateriaAcoesEnum.REDIRECIONAR_MATERIA_PARA_ENDPOINT_DE_LISTAGEM);
    }
}
