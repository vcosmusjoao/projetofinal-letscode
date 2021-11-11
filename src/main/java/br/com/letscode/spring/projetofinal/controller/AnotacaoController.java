package br.com.letscode.spring.projetofinal.controller;

import br.com.letscode.spring.projetofinal.model.Anotacao;
import br.com.letscode.spring.projetofinal.model.UsuariosLogados;
import br.com.letscode.spring.projetofinal.repository.AnotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnotacaoController {

    @Autowired
    private UsuariosLogados usuariosLogados;

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @RequestMapping( value="/anotacao", method = RequestMethod.GET)
    public String getCadastroForm(){
        return "cadastro-anotacao";
    }

    @PostMapping("/cadastro_anotacao")
    public String processRegister(Anotacao anotacao) {
        anotacao.setUsuario(usuariosLogados.getUsuarios());
        anotacaoRepository.save(anotacao);

        return "redirect:/home";
    }

    @GetMapping("/anotacao/{id}")
    public String getAnotacao(@PathVariable Long id, Model model) {
        Anotacao anotacao = anotacaoRepository.getById(id);
        model.addAttribute("anotacao", anotacao);

        return "/anotacao";
    }
}
