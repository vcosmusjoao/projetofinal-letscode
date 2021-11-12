package br.com.letscode.spring.projetofinal.restcontroller;

import br.com.letscode.spring.projetofinal.model.Anotacao;
import br.com.letscode.spring.projetofinal.model.UsuariosLogados;
import br.com.letscode.spring.projetofinal.repository.AnotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("rest")
@RestController
public class AnotacaoRestController {

    @Autowired
    private UsuariosLogados usuariosLogados;

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @GetMapping("/home")
    public List<Anotacao> getAll() {
        List<Anotacao> notas = null;

        if (usuariosLogados.getUsuarios().getId() != null) {
            notas = anotacaoRepository.buscarTodos(usuariosLogados.getUsuarios().getId());
        }

        return notas;
    }

    @PostMapping("/cadastro_anotacao")
    public Anotacao processRegister(@RequestBody Anotacao anotacao) {
        anotacao.setUsuario(usuariosLogados.getUsuarios());
        anotacaoRepository.save(anotacao);

        return anotacao;
    }

    @GetMapping("/anotacao/{id}")
    public Anotacao getAnotacao(@PathVariable Long id) {
        Long idUsu = usuariosLogados.getUsuarios().getId();

        if (idUsu != null) {
            Anotacao anotacao = anotacaoRepository.getById(id);

            if (anotacao.getUsuario().getId() == idUsu) {
                return anotacao;
            }
        }

        return null;
    }

    @DeleteMapping("/anotacao/deletar/{id}")
    public Anotacao removerAnotacao(@PathVariable Long id){
        Long idUsu = usuariosLogados.getUsuarios().getId();

        if (idUsu != null) {
            Anotacao anotacao = anotacaoRepository.getById(id);

            if (anotacao.getUsuario().getId() == idUsu) {
                anotacaoRepository.delete(anotacao);

                return anotacao;
            }
        }

        return null;
    }
}
