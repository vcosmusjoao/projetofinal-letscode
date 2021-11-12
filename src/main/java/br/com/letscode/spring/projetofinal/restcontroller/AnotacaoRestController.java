package br.com.letscode.spring.projetofinal.restcontroller;

import br.com.letscode.spring.projetofinal.model.Anotacao;
import br.com.letscode.spring.projetofinal.model.UsuariosLogados;
import br.com.letscode.spring.projetofinal.repository.AnotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("rest")
@RestController
public class AnotacaoRestController {

    @Autowired
    private UsuariosLogados usuariosLogados;

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @RequestMapping( value="/anotacao", method = RequestMethod.GET)
    public String getCadastroForm(){
        if (usuariosLogados.getUsuarios().getId() != null) {
            return "cadastro-anotacao";
        }

        return "redirect:/login";
    }

    @PostMapping("/cadastro_anotacao")
    public String processRegister(Anotacao anotacao) {
        anotacao.setUsuario(usuariosLogados.getUsuarios());
        anotacaoRepository.save(anotacao);

        return "redirect:/home";
    }

    @GetMapping("/anotacao/{id}")
    public String getAnotacao(@PathVariable Long id, Model model) {
        if (usuariosLogados.getUsuarios().getId() != null) {
            Anotacao anotacao = anotacaoRepository.getById(id);
            model.addAttribute("anotacao", anotacao);

            return "/anotacao";
        }

        return "redirect:/login";
    }

    @GetMapping("/anotacao/deletar/{id}")
    public String removerAnotacao(@PathVariable Long id){
        anotacaoRepository.deleteById(id);
        return "redirect:/home";
    }


}
