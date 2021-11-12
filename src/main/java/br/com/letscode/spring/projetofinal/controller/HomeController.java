package br.com.letscode.spring.projetofinal.controller;

import br.com.letscode.spring.projetofinal.model.Anotacao;
import br.com.letscode.spring.projetofinal.model.UsuariosLogados;
import br.com.letscode.spring.projetofinal.repository.AnotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    private UsuariosLogados logins;
    @Autowired
    private AnotacaoRepository anotacao;

    @GetMapping("/home")
    public String home(Model model) {
        Long idUsu = logins.getUsuarios().getId();

        if (idUsu != null) {
            model.addAttribute("nome", logins.getUsuarios().getNome());

            ArrayList<Anotacao> notas = (ArrayList<Anotacao>) anotacao.buscarTodos(idUsu);

            if (notas.size() == 0) {
                model.addAttribute("nullNotas", "Você não possui notas!");
            }
            model.addAttribute("allNotas", notas);

            return "home";
        }

        return "redirect:/login";
    }
}
