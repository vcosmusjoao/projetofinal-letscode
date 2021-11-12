package br.com.letscode.spring.projetofinal.restcontroller;

import br.com.letscode.spring.projetofinal.model.UsuariosLogados;
import br.com.letscode.spring.projetofinal.repository.AnotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("rest")
@RestController
public class HomeRestController {

    @Autowired
    private UsuariosLogados logins;
    @Autowired
    private AnotacaoRepository anotacao;

    @GetMapping("/home")
    public String home(Model model) {
        if (logins.getUsuarios().getId() != null) {
            model.addAttribute("nome", logins.getUsuarios().getNome());

            if (anotacao.buscarTodos(logins.getUsuarios().getId()).size() == 0) {
                model.addAttribute("nullNotas", "Você não possui notas!");
            }
            model.addAttribute("allNotas", anotacao.buscarTodos(logins.getUsuarios().getId()));

            return "home";
        }

        return "redirect:/login";
    }
}
