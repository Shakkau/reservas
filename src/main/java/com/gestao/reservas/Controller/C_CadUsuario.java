package com.gestao.reservas.Controller;

import com.gestao.reservas.Service.S_Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_CadUsuario {

    @GetMapping("/cadastro")
    public String getCadastro(){
        return "cadastros/usuario";
    }

    @PostMapping("/cadastro")
    @ResponseBody
    public String cadastrarUsuario(@RequestParam("nome") String nome,
                                   @RequestParam("email") String email,
                                   @RequestParam("matricula") String matricula,
                                   @RequestParam("cargo") String cargo){
        return S_Usuario.cadastrarUsuario(nome,matricula,cargo,email);
    }
}
