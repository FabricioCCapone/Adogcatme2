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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/adoptante")
public class AdoptanteControlador {

    @Autowired
    AdoptanteServicio as;

    @Autowired
    SolicitudServicio ss;

    @Autowired
    MascotaServicio ms;

    private Mascota mascota = new Mascota();

    @GetMapping("/perfilAdoptante")
    public String perfilAdoptante(Model model, Adoptante a) {
        model.addAttribute("solicitudes", a.getSolicitud().listIterator());
        return "perfil-adopt";
    }

    @GetMapping("/home")
    public String homeAdoptante(Model model, @RequestParam(required = false) String raza, @RequestParam(required = false) String tipo, @RequestParam(required = false) Integer edad, @RequestParam(required = false) String sexo, @RequestParam(required = false) String tamano, @RequestParam(required = false) Boolean castrado) {
        try {
            if ((raza != null) || (tipo != null) || (edad != null) || (sexo != null) || (tamano != null) || (castrado != null)) {
                model.addAttribute("mascotas", ms.findByFiltro(raza, tipo, edad, sexo, tamano, castrado));
            } else {
                model.addAttribute("mascotas", ms.listAll());
            }
            return "home-adop";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "home-adop";
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
