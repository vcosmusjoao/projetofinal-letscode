package br.com.letscode.spring.projetofinal.restcontroller;

import br.com.letscode.spring.projetofinal.model.Usuario;
import br.com.letscode.spring.projetofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("rest")
@RestController
public class CadastroRestController {

    @Autowired
    private UsuarioRepository userRepo;

    @GetMapping("/registro")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());

        return "cadastro";
    }

    @PostMapping("/processo_registrar")
    public String processRegister(Usuario usuario) {
        userRepo.save(usuario);

        return "login";
    }
}
