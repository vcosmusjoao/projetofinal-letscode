package br.com.letscode.spring.projetofinal.controller;

import br.com.letscode.spring.projetofinal.model.Anotacao;
import br.com.letscode.spring.projetofinal.model.UsuariosLogados;
import br.com.letscode.spring.projetofinal.repository.AnotacaoRepository;
import br.com.letscode.spring.projetofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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



}
