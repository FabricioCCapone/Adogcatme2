package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.Repositorios.AdoptanteRepositorio;
import Adogcatme.Proyecto.Repositorios.DuenoRepositorio;
import Adogcatme.Proyecto.entidades.Usuario;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Adogcatme.Proyecto.entidades.Adoptante;
import Adogcatme.Proyecto.entidades.Dueno;
import Adogcatme.Proyecto.enums.Rol;
import exepciones.WebExeption;

@Service
public class UsuarioServicio {

    @Autowired
    private DuenoRepositorio duenoRepositorio;
    @Autowired
    private AdoptanteRepositorio adoptanteRepositorio;

    @Transactional
    public Usuario saveAdoptante(String usuario, String contrasena1, String contrasena2, String nombre, String telefono, String email, String barrio, String direccion) throws WebExeption {
       
        validar(usuario, contrasena1, contrasena2, nombre, telefono, email, barrio, direccion);
        Adoptante adoptante = adoptanteRepositorio.findByEmail(email);

        if (adoptante == null) {
            adoptante.setUsuario(usuario);
            adoptante.setContrasena(contrasena2);
            adoptante.setEmail(email);
            adoptante.setNombre(nombre);
            adoptante.setTelefono(telefono);
            adoptante.setBarrio(barrio);
            adoptante.setDireccion(direccion);
            adoptante.setRol(Rol.USER);
            return adoptante;
        }
        return adoptante;
    }

    @Transactional
    public Usuario saveDueno(String usuario, String contrasena1, String contrasena2, String nombre, String telefono, String email, String barrio, String direccion) throws WebExeption {

        validar(usuario, contrasena1, contrasena2, nombre, telefono, email, barrio, direccion);
        Dueno dueno = duenoRepositorio.findByEmail(email);

        if (dueno == null) {
            dueno.setUsuario(usuario);
            dueno.setContrasena(contrasena2);
            dueno.setEmail(email);
            dueno.setNombre(nombre);
            dueno.setTelefono(telefono);
            dueno.setBarrio(barrio);
            dueno.setDireccion(direccion);
            dueno.setRol(Rol.USER);
            return dueno;
        }
        return dueno;
    }

    public void validar(String usuario, String contrasena1, String contrasena2, String nombre, String telefono, String email, String barrio, String direccion) throws WebExeption {
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
