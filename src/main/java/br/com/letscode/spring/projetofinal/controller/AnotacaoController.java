package br.com.letscode.spring.projetofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AnotacaoController {

    @RequestMapping( value="/anotacao", method = RequestMethod.GET)
    public String getCadastroForm(){
        return "cadastro-anotacao";
    }
}
