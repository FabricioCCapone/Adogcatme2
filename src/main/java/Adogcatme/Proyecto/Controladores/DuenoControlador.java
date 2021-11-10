package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.DuenoServicio;
import Adogcatme.Proyecto.Servicios.MascotaServicio;
import Adogcatme.Proyecto.entidades.Dueno;
import Adogcatme.Proyecto.entidades.Mascota;
import exepciones.WebExeption;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequestMapping("/dueno")
@Controller
public class DuenoControlador {

    @Autowired
    private DuenoServicio duenoServicio;
    
    //Listar dueños
    @GetMapping("/list")
    public String listDueno(Model model){
        model.addAttribute("dueno", duenoServicio.listAll());
        return "perfil-dueno";
    }
    
    //Crear dueño
    @PostMapping("/login")
    public String crearDueno (Dueno dueno){        
        return "redirect:/HOME-DUENO-ADMIN.HTML";

    } 
    
    

    //Modificar un dueño
    @GetMapping("/editar")
    public String editarPerfilDueno(Model model, HttpSession session) {
        Dueno dueno = (Dueno) session.getAttribute("usuario");
        model.addAttribute("usuario", dueno);
        return "editar-dueno";
    }

    @GetMapping("/home")
    public String homeDueno(Model model, HttpSession session) {
        Dueno dueno = (Dueno) session.getAttribute("usuario");
        model.addAttribute("usuario", dueno);
        model.addAttribute("mascota", dueno.getMascotas());
        return "perfil-dueno";
    }
    //QUEDAMOS ACA
    //Como distinguir al loggear y como pasar los datos del objeto al loggear
}
