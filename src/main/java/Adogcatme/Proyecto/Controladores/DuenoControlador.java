package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.DuenoServicio;
import Adogcatme.Proyecto.entidades.Dueno;
import Adogcatme.Proyecto.entidades.Mascota;
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

    //Listar dueños
    /*@GetMapping("/list")
    public String listDueno(Model model) {
        model.addAttribute("Dueno", duenoServicio.listAll());
        return "duenoList";
    }*/

    //Crear dueño
    @PostMapping("/LOGIN-DUENO.HTML")
    public String saveDueno(Dueno dueno) {
        try {
            duenoServicio.save(dueno);
            return "redirect:/HOME-DUENO-ADMIN.HTML";
        } catch (Exception ErrorServicio) {
            return "redirect:/INICIO.HTML";
        }

    }

    //Modificar un dueño
    @GetMapping("/HOME-DUENO-ADMIN.HTML")
    public String crearDueno(Model model, @RequestParam(required = false) String id) {
        if (id != null) {
            Optional<Dueno> optional = duenoServicio.findById(id);
            if (optional.isPresent()) {
                
                model.addAttribute("dueno", optional.get());
            } else {
                return "/HOME-DUENO-ADMIN.HTML";
            }
        } else {
            model.addAttribute("dueno", new Dueno());
        }
        return "/HOME-DUENO-ADMIN.HTML";
    }
    
    //Crear Mascota
    @GetMapping("/REGIST-MASC.HTML")
    public String crearMascota(Mascota mascota){
        
        return "/HOME-DUENO-ADMIN.HTML";
    }
    

}
