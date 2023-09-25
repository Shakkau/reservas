package com.gestao.reservas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_CadUsuario {

    @GetMapping("/cadastro")
    public String getCadastro(){
        return "cadastros/usuario";
    }
}
