package br.com.letscode.spring.projetofinal.controller;

import br.com.letscode.spring.projetofinal.model.UsuariosLogados;
import br.com.letscode.spring.projetofinal.repository.AnotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UsuariosLogados logins;
    @Autowired
    private AnotacaoRepository anotacao;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("nome", logins.getUsuarios().getNome());
        if (anotacao.buscarTodos(logins.getUsuarios().getId()).size() == 0) {
            model.addAttribute("nullNotas", "Você não possui notas!");
        }
        model.addAttribute("allNotas", anotacao.buscarTodos(logins.getUsuarios().getId()));

        return "home";
    }
}
