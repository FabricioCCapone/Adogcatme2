package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.MascotaServicio;
import Adogcatme.Proyecto.Servicios.SolicitudServicio;
import Adogcatme.Proyecto.entidades.Dueno;
import Adogcatme.Proyecto.entidades.Mascota;
import exepciones.WebExeption;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mascota")
public class MascotaControlador {
        
    @Autowired
    MascotaServicio ms;
    
    @Autowired
    SolicitudServicio ss;
    
    @GetMapping("/perfilMascota")
    public String perfilMascota(Model model, Mascota m){
        model.addAttribute("mascota", ms.findById(m.getId()));
        model.addAttribute("solicitudes", ss.listAll());
        return "perfil-mascot";
    }
        
    @GetMapping("/registro")
    public String registrarMascota(Model model, HttpSession session){
        
        Mascota mascota = new Mascota();
        Dueno dueno = (Dueno) session.getAttribute("usuario");
        model.addAttribute("dueno", dueno);
        model.addAttribute("mascota", mascota);
        return "registro-mascota";
    }
    
    @PostMapping("/registroform")
    public String registrarMascota(@ModelAttribute Mascota m){
        try {
            ms.registrarMascota(m);
            return "redirect:/dueno/home";
        } catch (WebExeption e) {         
            
    }
    return "redirect:/fsa";
    }
    
    @PostMapping("/editarMascota")
    public String editarMascota(@ModelAttribute Mascota m){
        try {
            ms.editarMascota(m);
        } catch (Exception e) {
            
        }finally{
            return "redirect:/";
        }
    }
    
    @GetMapping("/eliminarMascota")
    public String eliminarMascota(@ModelAttribute Mascota m){
        try {
            ms.eliminarMascota(m);
        } catch (Exception e) {
            
        }finally{
            return "redirect:/";
        }        
    }
    
}

