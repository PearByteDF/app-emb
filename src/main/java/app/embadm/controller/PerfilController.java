package app.embadm.controller;

import app.embadm.entity.PerfilEntidade;
import app.embadm.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("perfis")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("inserir-perfil")
    public String inserirPerfil (Model model) {
        PerfilEntidade perfil = new PerfilEntidade();
        model.addAttribute("perfil", perfil);
        return "perfil/inserir-perfil";
    }

    @RequestMapping(path = "salvar-perfil", method = RequestMethod.POST)
    public String salvarPerfil (PerfilEntidade perfil) {
        perfilService.salvaPerfil(perfil);
        return "redirect:/perfis/listar-perfis";
    }

    @GetMapping("listar-perfis")
    public String listarPerfis (Model model) {
        model.addAttribute("listarPerfis", perfilService.listarTodosOsPerfis());
        return "perfil/listar-perfis";
    }

    @RequestMapping(path = "/deletar-perfil/{id}")
    public String deletarPerfilPorId (@PathVariable("id") Integer id, Model model) {
        perfilService.deletarPerfil(id);
        model.addAttribute("listarPerfis", perfilService.listarTodosOsPerfis());
        return "redirect:/perfis/listar-perfis";
    }

    @GetMapping("atualizar-perfil/{id}")
    public String atualizarPerfilPorId (@PathVariable("id") Integer id, Model model) {
        model.addAttribute("perfil", perfilService.obterPerfilPorId(id));
        return "perfil/inserir-perfil";
    }

}
