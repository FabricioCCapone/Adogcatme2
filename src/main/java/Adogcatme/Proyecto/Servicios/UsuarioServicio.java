package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.Repositorios.DuenoRepositorio;
import Adogcatme.Proyecto.entidades.Usuario;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Adogcatme.Proyecto.Repositorios.UsuarioRepositorio;
import Adogcatme.Proyecto.entidades.Dueno;
import Adogcatme.Proyecto.entidades.Ubicacion;
import exepciones.WebExeption;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private DuenoServicio duenoServicio;
    @Autowired
    private AdoptanteServicio adoptanteServicio;
    @Autowired
    private DuenoRepositorio duenoRepositorio;

    @Transactional
    public Usuario saveAdoptante(String username, String contrasena1, String contrasena2) {

        Usuario usuario = new Usuario();

        if (username == null || username.isEmpty()) {
            System.out.println("El usuario no puede ser nulo");
        }

        if (!contrasena1.equals(contrasena2)) {
            System.out.println("Las contraseñas no son iguales");
        }

        usuario.setUsuario(username);
        usuario.setContrasena(contrasena1);

        return usuarioRepositorio.save(usuario);
    }

    @Transactional
    public Usuario saveDueño(String usuario, String contrasena1, String contrasena2, String nombre, String telefono, String email,String barrio,String direccion) throws WebExeption {
        
            
        validar(usuario, contrasena1, contrasena2,nombre,telefono,email,barrio,direccion);
        Dueno dueno = duenoRepositorio.findByEmail(email);
        if (dueno  == null) {
            
        }
        return .save(usuario);
    }

    public void validar(String usuario, String contrasena1, String contrasena2,String nombre, String telefono, String email,String barrio,String direccion) throws WebExeption {
        if (usuario == null || usuario.isEmpty()) {
            throw new WebExeption("El usuario no puede ser nulo");
        }
        if (contrasena1.isEmpty() || contrasena1 == null || contrasena2.isEmpty() || contrasena2 == null) {
            throw new WebExeption("La contraseña no puede estar vacio");
        }
        if (!contrasena1.equals(contrasena2)) {
            throw new WebExeption("Las contraseña no coinciden");
        }
        if (nombre.isEmpty() || nombre == null) {
            throw new WebExeption("El nombre no puede estar vacio");
        }
        if (telefono.isEmpty() || telefono == null) {
            throw new WebExeption("El telefono no puede estar vacio");
        }
        if (email.isEmpty() || email == null) {
            throw new WebExeption("El email no puede estar vacio");
        }
        if (barrio.isEmpty() || barrio == null) {
            throw new WebExeption("El barrio no puede estar vacio");
        }
        if (direccion.isEmpty() || direccion == null) {
            throw new WebExeption("El direccion no puede estar vacio");
        }
    }
}
