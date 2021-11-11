/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.AdoptanteServicio;
import Adogcatme.Proyecto.Servicios.MascotaServicio;
import Adogcatme.Proyecto.Servicios.SolicitudServicio;
import Adogcatme.Proyecto.entidades.Adoptante;
import Adogcatme.Proyecto.entidades.Mascota;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adoptante")
public class AdoptanteControlador {

    @Autowired
    AdoptanteServicio as;

    @Autowired
    SolicitudServicio ss;

    @Autowired
    MascotaServicio ms;
    
    private Mascota mascota;

    @GetMapping("/perfilAdoptante")
    public String perfilAdoptante(Model model, Adoptante a) {
        model.addAttribute("solicitudes", a.getSolicitud().listIterator());
        return "perfil-adopt";
    }

    @GetMapping("/home")
    public String homeAdoptante(Model model) {
        model.addAttribute("mascotas", ms.findByFiltro(mascota.getRaza(), mascota.getTipo(), mascota.getEdad(), mascota.getSexo(), mascota.getTamano(), mascota.getCastrado()));
        return "home-adop";
    }
    
    @PostMapping("/filtro")
    public String filtro(Model model) {
        model.addAttribute("mascotas", ms.listAll());
        return "home-adop";
    }

    @GetMapping("/registro")
    public String registrarAdoptante(Model model) {
        model.addAttribute("adoptante", new Adoptante());
        return "regist-adopt";
    }

    @PostMapping("/registroForm")
    public String registrarAdoptante(@ModelAttribute Adoptante adoptante) {
        try {
            as.registrarAdoptante(adoptante);
        } catch (Exception e) {

        } finally {
            return "redirect:/";
        }
    }

    @GetMapping("/editarAdopt")
    public String editarAdoptante(Model model, Adoptante a) {
        model.addAttribute("adoptante", a);
        return "perfil-adopt";
    }

    @PostMapping("/editarAdoptante")
    public String modificar(@ModelAttribute Adoptante a) {
        try {
            as.editarAdoptante(a);
        } catch (Exception e) {

        }
        return "redirect:/";
    }

}
