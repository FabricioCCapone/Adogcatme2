package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.MascotaServicio;
import Adogcatme.Proyecto.entidades.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Capoun
 */
@Controller
@RequestMapping("/Mascota")
public class MascotaControlador {
        
    @Autowired
    MascotaServicio ms;
    
    @GetMapping("/Registro")
    public String registrarMascota(Model model){
        Mascota m = new Mascota();
        model.addAttribute("mascota", m);
        return "regist-masc";
    }
    
    @PostMapping("/RegistroForm")
    public String registrarMascota(@RequestParam Mascota m){
        try {
            ms.registrarMascota(m);
        } catch (Exception e) {
            
        }finally{
            return "redirect:/";
        }
    }
    
    @PostMapping("/EditarMascota")
    public String editarMascota(@RequestParam Mascota m){
        try {
            ms.editarMascota(m);
        } catch (Exception e) {
            
        }finally{
            return "redirect:/";
        }
    }
    
    @GetMapping("/EliminarMascota")
    public String eliminarMascota(@RequestParam Mascota m){
        try {
            ms.eliminarMascota(m);
        } catch (Exception e) {
            
        }finally{
            return "redirect:/";
        }        
    }
}

