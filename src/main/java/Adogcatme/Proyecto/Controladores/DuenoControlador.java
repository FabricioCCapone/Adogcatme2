package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.DuenoServicio;
import Adogcatme.Proyecto.entidades.Dueno;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequestMapping("/dueno")
@Controller
public class DuenoControlador {

    @Autowired
    private DuenoServicio duenoServicio;
    
    //Modificar un dueño
    @GetMapping("/editar")
    public String editarPerfilDueno(Model model, HttpSession session) {
        Dueno dueno = (Dueno) session.getAttribute("usuario");
        model.addAttribute("usuario", dueno);
        return "perfil-dueno";
    }
    
    @PostMapping("/save")
    public String guardarDueno(@ModelAttribute Dueno usuario) throws Exception{
        duenoServicio.save(usuario);
        return "perfil-dueno";
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
