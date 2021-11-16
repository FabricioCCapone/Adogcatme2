package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.MascotaServicio;
import Adogcatme.Proyecto.Servicios.SolicitudServicio;
import Adogcatme.Proyecto.entidades.Dueno;
import Adogcatme.Proyecto.entidades.Mascota;
import exepciones.WebExeption;
import java.security.Principal;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mascota")
public class MascotaControlador {

    @Autowired
    MascotaServicio ms;

    @Autowired
    SolicitudServicio ss;

    @GetMapping("/perfilMascota")
    public String perfilMascota(Model model, Mascota m) {
        model.addAttribute("mascota", ms.findById(m.getId()));
        model.addAttribute("solicitudes", ss.listAll());
        return "perfil-mascot";
    }

    @GetMapping("/registro")
    public String registrarMascota(Model model) {
        model.addAttribute("mascota", new Mascota());
        return "registro-mascota";
    }

    @PostMapping("/registroform")
    public String registrarMascota(@ModelAttribute Mascota mascota, HttpSession session) {
        try {
            Dueno usuario = (Dueno) session.getAttribute("usuario");
            ms.registrarMascota(mascota, usuario);
            return "redirect:/dueno/home";
        } catch (WebExeption e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/dueno/home";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarMascota(@PathVariable(name = "id") String id) {
        ModelAndView editarVista = new ModelAndView("perfil-mascot-admin");
        Mascota mascota = ms.findById(id);
        editarVista.addObject("mascota", mascota);
        return editarVista;
    }

    @PostMapping("/save")
    public String editarMascota(@ModelAttribute Mascota m,Principal principal,HttpSession session) {
        try {
            Dueno dueno = (Dueno) session.getAttribute("usuario");
            System.out.println(m.getNombre());
            System.out.println(m.getId());
            System.out.println(m.getRaza());
            ms.editarMascotaEnDueño(m,dueno);
        } catch (Exception e) {

        } finally {
            return "redirect:/";
        }
    }

    @GetMapping("/eliminarMascota")
    public String eliminarMascota(@ModelAttribute Mascota m) {
        try {
            ms.eliminarMascota(m);
        } catch (Exception e) {

        } finally {
            return "redirect:/";
        }
    }

}
