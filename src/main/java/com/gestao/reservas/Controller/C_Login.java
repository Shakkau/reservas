package com.gestao.reservas.Controller;

import com.gestao.reservas.Service.S_Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Login {

    @GetMapping("/")
    public String getHome(HttpSession session){
        if(session.getAttribute("usuario") != null){
            return "redirect:/Home";
        }else{
            return "login/login";
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean validarLogin(@RequestParam("matricula") String matricula,
                                @RequestParam("senha") String senha,
                                HttpSession session){
        session.setAttribute("usuario", S_Usuario.validaLogin(matricula,senha));
        if(session.getAttribute("usuario") != null){
            return true;
        }
        return false;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("usuario", null);
        return "redirect:/";
    }
}
