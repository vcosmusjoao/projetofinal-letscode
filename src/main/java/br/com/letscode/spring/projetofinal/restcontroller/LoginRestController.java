package br.com.letscode.spring.projetofinal.restcontroller;

import br.com.letscode.spring.projetofinal.model.LoginForm;
import br.com.letscode.spring.projetofinal.model.Usuario;
import br.com.letscode.spring.projetofinal.model.UsuariosLogados;
import br.com.letscode.spring.projetofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("rest")
@RestController
public class LoginRestController {

    @Autowired
    private UsuarioRepository userRepo;
    @Autowired
    private UsuariosLogados login;

    @PostMapping( value="/login")
    public Usuario login(@ModelAttribute(name = "loginForm")LoginForm loginForm){
        String email = loginForm.getEmail();
        String senha = loginForm.getSenha();

        Usuario usuario = userRepo.findByEmailAndSenha(email, senha);

        if (usuario != null) {
            login.setUsuarios(usuario);
        }

        return login.getUsuarios();
    }
}
