package br.com.letscode.spring.projetofinal.controller;

import br.com.letscode.spring.projetofinal.model.LoginForm;
import br.com.letscode.spring.projetofinal.model.Usuario;
import br.com.letscode.spring.projetofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository userRepo;

    @RequestMapping( value="/login", method = RequestMethod.GET)
    public String getLoginForm(){
        return "login";
    }

    @RequestMapping( value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm")LoginForm loginForm, Model model){
        String email = loginForm.getEmail();
        String senha = loginForm.getSenha();

        Usuario usuario = userRepo.findByEmailAndSenha(email, senha);

        if (usuario != null) {
            model.addAttribute(usuario.getNome(),true);
            return "redirect:/home";
        }

        model.addAttribute("erroLogin", "Usuário inválido!");
        return "login";
    }
}