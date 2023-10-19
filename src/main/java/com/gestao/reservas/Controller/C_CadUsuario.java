package com.gestao.reservas.Controller;

import com.gestao.reservas.Model.M_Resposta;
import com.gestao.reservas.Model.M_Usuario;
import com.gestao.reservas.Service.S_Usuario;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/edit/usuario")
    public String getEditUsuario(HttpServletRequest request,
                                    HttpSession session,
                                 Model model ){
        if (request.getHeader("Referer") != null){
            M_Usuario usuario = (M_Usuario) session.getAttribute("usuario");
            M_Usuario matricula = (M_Usuario) session.getAttribute("matricula");
            M_Usuario email = (M_Usuario) session.getAttribute("email");
            model.addAttribute("usuario", usuario);
            model.addAttribute("matricula", matricula);
            model.addAttribute("email", email);
            if (usuario.getCargo() == 1){
                return "/cadastros/pv/edit_cad_usuario_gestor";
            }else{
                return "/cadastros/pv/edit_cad_usuario_default";
            }
        }else{
            return null;
        }
    }

    @PostMapping("/edit/usuario")
    @ResponseBody
    public M_Resposta postEditUsuario(HttpServletRequest request,
                                      HttpSession session,
                                      @RequestParam("nome") String nome,
                                      @RequestParam("email") String email,
                                      @RequestParam("senhaAtual") String senha,
                                      @RequestParam("novaSenha") String novaSenha,
                                      @RequestParam("confirmaNovaSenha") String confirmaNovaSenha,
                                      @RequestParam(value="cargo", required = false) String cargo,
                                      @RequestParam(value="matricula", required = false) String matricula,
                                      @RequestParam(value="ativo", required = false) String ativo){

        Object usuario = session.getAttribute("usuario");
        return S_Usuario.editarUsuario(nome,matricula,email,cargo,
                senha,novaSenha,confirmaNovaSenha,ativo,(M_Usuario) usuario);
    }
}
