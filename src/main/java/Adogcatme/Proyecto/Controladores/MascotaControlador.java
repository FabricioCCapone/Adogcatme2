package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.MascotaServicio;
import Adogcatme.Proyecto.entidades.Mascota;
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
    
    @GetMapping("/perfilMascota")
    public String perfilMascota(Model model, Mascota m){
        model.addAttribute("mascota", ms.findById(m.getId()));
        return "perfil-mascot";
    }
    
    @GetMapping("/registro")
    public String registrarMascota(Model model){
        model.addAttribute("mascota", new Mascota());
        return "regist-masc";
    }
    
    @PostMapping("/registroForm")
    public String registrarMascota(@ModelAttribute Mascota mascota){
        try {
            ms.registrarMascota(mascota);
        } catch (Exception e) {
            
        }finally{
            return "redirect:/";
        }
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

