package com.gestao.reservas.Controller;

import com.gestao.reservas.Model.M_Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Home {
    @GetMapping("/Home")
    public String getHome(HttpSession session,
                          Model model){
        if(session.getAttribute("usuario") != null){
            model.addAttribute("usuario",session.getAttribute("usuario"));
            return "home/home";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/home")
    public String getPV_Home(HttpSession session,
                          Model model){
        if(session.getAttribute("usuario") != null){
            model.addAttribute("usuario",session.getAttribute("usuario"));
            return "home/PV_home";
        }else{
            return "redirect:/";
        }
    }
}
