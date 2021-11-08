
package Adogcatme.Proyecto.Controladores;


import Adogcatme.Proyecto.Servicios.DuenoServicio;
import Adogcatme.Proyecto.entidades.Dueno;
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
    @GetMapping("/list")
    public String listDueno(Model model){
        model.addAttribute("dueno", duenoServicio.listAll());
        return "perfil-dueno";
    }
    
    //Guardar dueño
    /*@PostMapping("/save")
    public String saveDueno (ueno dueno){
        duenoServicio.save(dueno);
        return "redirect:/dueno/list";
    }*/
    
    //Crear dueño
    @PostMapping("/login")
    public String crearDueno (Dueno dueno){
        
        return "redirect:/HOME-DUENO-ADMIN.HTML";
    }
    
    
    
    //Modificar un dueño
    @PutMapping("/form")
    public String crearLibro(Model model, @RequestParam(required = false) String id) {
        if (id != null) {
            Optional<Dueno> optional = duenoServicio.findById(id);
            if (optional.isPresent()) {
                model.addAttribute("dueno", optional.get());
            } else {
                return "redirect:/dueno/list";
            }
        } else {
            model.addAttribute("dueno", new Dueno());
        }
        return "dueno-form";
    }
    
    
    
}
