package br.com.letscode.spring.projetofinal.controller;

import br.com.letscode.spring.projetofinal.model.Usuario;
import br.com.letscode.spring.projetofinal.model.UsuariosLogados;
import br.com.letscode.spring.projetofinal.repository.AnotacaoRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private UsuariosLogados logins;
    //private AnotacaoRepository anotacaoRepository;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("nome", logins.getUsuarios(0).getNome());
        return "home";
    }
}
