package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.DuenoServicio;
import Adogcatme.Proyecto.Servicios.MascotaServicio;
import Adogcatme.Proyecto.entidades.Dueno;
<<<<<<< HEAD
import Adogcatme.Proyecto.entidades.Mascota;
import exepciones.WebExeption;
import java.util.Optional;
=======
import exepciones.WebExeption;
import javax.servlet.http.HttpSession;
>>>>>>> 75e2494e90193197edcb9734f1a1079bceddeb7e
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
=======
import org.springframework.web.bind.annotation.ModelAttribute;
<<<<<<< HEAD
>>>>>>> 46c9498953df2568413c9c73b83e6e16290b926e
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> 75e2494e90193197edcb9734f1a1079bceddeb7e

@Service
@RequestMapping("/dueno")
@Controller
public class DuenoControlador {

    @Autowired
    private DuenoServicio duenoServicio;
<<<<<<< HEAD
<<<<<<< HEAD

    @Autowired
    private MascotaServicio mascotaServicio;

=======
    
    //Listar dueños
    @GetMapping("/list")
    public String listDueno(Model model){
        model.addAttribute("dueno", duenoServicio.listAll());
        return "perfil-dueno";
    }
    
    //Crear dueño
>>>>>>> 46c9498953df2568413c9c73b83e6e16290b926e
    @PostMapping("/login")
    public String crearDueno (Dueno dueno){        
        return "redirect:/HOME-DUENO-ADMIN.HTML";
<<<<<<< HEAD
    }
   
=======
    } 
    
>>>>>>> 46c9498953df2568413c9c73b83e6e16290b926e
    //Modificar un dueño
    @GetMapping("/HOME-DUENO-ADMIN")
    public String crearDueno(Model model, @RequestParam(required = false) String id) {

        try {
            if (id != null) {
                Optional<Dueno> optional = duenoServicio.findById(id);
                if (optional.isPresent()) {

                    model.addAttribute("dueno", optional.get());

                } else {
                    return "/HOME-DUENO-ADMIN.HTML";
                }
            }
        } catch (Exception e) {

            System.out.println("No se puede crear el usuario");
            return "/INICIO.HTML";
        }
        return "/HOME-DUENO-ADMIN.HTML";
    }

    //Crear Mascota
    @GetMapping("/REGIST-MASC")
    public String crearMascota(Mascota mascota, Dueno dueno) {
        try {
            mascotaServicio.registrarMascota(mascota);
            Optional<Dueno> optional = duenoServicio.findById(dueno.getId());
            if (optional.isPresent()) {
                dueno.setMascotas(mascota);
            } else {
                System.out.println("No puede registrar una mascota, primero inicie sesión");
                return "/LOGIN-DUENO.HTML";
            }

        } catch (WebExeption e) {
            System.out.println("No es posible crear la mascota");
        }
        return "/HOME-DUENO-ADMIN.HTML";
    }
<<<<<<< HEAD
        

=======
    
=======

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

>>>>>>> 75e2494e90193197edcb9734f1a1079bceddeb7e
    @GetMapping("/home")
    public String homeDueno(Model model, HttpSession session) {
        Dueno dueno = (Dueno) session.getAttribute("usuario");
        model.addAttribute("usuario", dueno);
        model.addAttribute("mascota", dueno.getMascotas());
        return "perfil-dueno";
    }
    //QUEDAMOS ACA
    //Como distinguir al loggear y como pasar los datos del objeto al loggear
>>>>>>> 46c9498953df2568413c9c73b83e6e16290b926e
}
