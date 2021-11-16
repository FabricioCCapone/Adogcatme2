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

    @GetMapping("/dueno")
    public String registroDueno() {
        return "login-dueno"; 
    }

    @GetMapping("/adoptante")
    public String registroAdoptante() {
        return "login-adop"; 
    }

    @PostMapping("/save")
    public String registroSave(Model model, @RequestParam String usuario, @RequestParam String contrasena1, @RequestParam String contrasena2,
            @RequestParam Integer selector, @RequestParam String nombre, @RequestParam String email, @RequestParam String telefono,
            @RequestParam String barrio, @RequestParam String direccion) {
        try {
            if (selector == 0) {

                usuarioServicio.saveDueno(usuario, contrasena1, contrasena2, nombre, telefono, email, barrio, direccion);
                return "redirect:/registro/dueno";
            }
            if (selector == 1) {
                usuarioServicio.saveAdotante(usuario,contrasena1, contrasena2, nombre, telefono, email, barrio, direccion);
                return "redirect:/registro/adoptante";
            }
            
        } catch (WebExeption ex) {
            model.addAttribute("error", ex.getMessage());
        }
        return "redirect:/";
    }

//    @GetMapping("/login")
//    public String login(Model model, @RequestParam(required = false) String error, @RequestParam(required = false) String username, @RequestParam(required = false) String logout) {
//        if (error != null) {
//            model.addAttribute("error", "El usuario o la contraseña son incorrectos");
//        }
//        if (username != null) {
//            model.addAttribute("username", username);
//        }
//        return "redirect:/";
//    }
}
