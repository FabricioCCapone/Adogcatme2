package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.DuenoServicio;
import Adogcatme.Proyecto.Servicios.MascotaServicio;
import Adogcatme.Proyecto.entidades.Dueno;
import Adogcatme.Proyecto.entidades.Mascota;
import exepciones.WebExeption;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Service
@RequestMapping("/dueno")
@Controller
public class DuenoControlador {

    @Autowired
    private DuenoServicio duenoServicio;

    @Autowired
    private MascotaServicio mascotaServicio;

    //Listar dueños
    /*@GetMapping("/list")
    public String listDueno(Model model) {
        model.addAttribute("dueno", duenoServicio.listAll());
        return "duenoList";
    }*/
    //Crear dueño
    /*@PostMapping("/LOGIN-DUENO")
    public String saveDueno(Dueno dueno) {
        try {
            duenoServicio.save(dueno);
            return "redirect:/HOME-DUENO-ADMIN.HTML";
        } catch (Exception ErrorServicio) {
            return "redirect:/INICIO.HTML";
        }

    }*/
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
        

}
