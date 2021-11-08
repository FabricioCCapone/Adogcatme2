package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.UsuarioServicio;
import exepciones.WebExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registro")
public class RegistroControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("")
    public String registro() {
        return "registro"; //Falta incluir la página
    }

    @PostMapping("")
    public String registroSave(Model model, @RequestParam String usuario, @RequestParam String contrasena1, @RequestParam String contrasena2,
            @RequestParam Integer selector, @RequestParam String nombre, @RequestParam String email, @RequestParam String telefono,
            @RequestParam String barrio, @RequestParam String direccion) {
        try {
            if (selector == 0) {

                usuarioServicio.saveDueno(usuario, contrasena1, contrasena2, nombre, telefono, email, barrio, direccion);
            }
            if (selector == 1) {
                usuarioServicio.saveAdotante(usuario, contrasena1, contrasena2, nombre, telefono, email, barrio, direccion);
            }
            return "redirect:/"; //Falta incluir la página de inicio del dueño
        } catch (WebExeption ex) {
            model.addAttribute("error",ex.getMessage());
        }
        return "registro";
    }
}