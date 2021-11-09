package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.DuenoServicio;
import Adogcatme.Proyecto.entidades.Dueno;
import exepciones.WebExeption;
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

    //Modificar un dueño
    @GetMapping("/editar")
    public String editarPerfilDueno(Model model, HttpSession session) {
        Dueno dueno = (Dueno) session.getAttribute("usuario");
        model.addAttribute("usuario", dueno);
        return "editar-dueno";
    }

    @PostMapping("/save")
    public String editarDueno(@ModelAttribute Dueno usuario, Model model) {
        try {
            duenoServicio.modificar(usuario);
            return "redirect:/dueno/home";
        } catch (WebExeption e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:/dueno/editar";
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
