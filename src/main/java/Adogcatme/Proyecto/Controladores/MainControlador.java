/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.entidades.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Extre
 */
@Controller
@RequestMapping("/")
public class MainControlador {

    @GetMapping("")
    public String home(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        try {
            if (usuario != null) {
                switch (usuario.getRol()) {
                    case DUENO:
                        return "redirect:/dueno/home";
                    case ADOPTANTE:
                        return "redirect:/adoptante/home";
                }
            }
        } catch (Exception e) {
        }

        return "home";
    }
}
