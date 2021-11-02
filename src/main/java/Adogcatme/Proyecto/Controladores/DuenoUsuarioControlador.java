package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.DuenoUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Registro")
public class DuenoUsuarioControlador {
    
    @Autowired
    private DuenoUsuarioServicio dus;
    
    @GetMapping("")
    public String registro(){
        return "registro"; //Falta incluir la página
    }
    
    @PostMapping("")
    public String registroSave(Model model, @RequestParam String usuario, @RequestParam String contrasena1, @RequestParam String contrasena2){
        dus.save(usuario, contrasena1, contrasena2);
        return "redirect:/"; //Falta incluir la página de inicio del dueño
    }
}
