
package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.Repositorios.DuenoRepositorio;
import Adogcatme.Proyecto.entidades.Dueno;
import Adogcatme.Proyecto.entidades.Mascota;
import Adogcatme.Proyecto.entidades.Solicitud;
import Adogcatme.Proyecto.entidades.Ubicacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenoServicio {
    
    @Autowired
    private DuenoRepositorio duenoRepositorio;
    

    //Listar dueños
    public List<Dueno> listAll(){
        return duenoRepositorio.findAll();
    }
    
    //busqueda por ID
    public Optional<Dueno> findById(String id){
        return duenoRepositorio.findById(id);
    }
    
    
    //Crear dueños
    @Transactional
    public Dueno save(String id, String nombre, String email, String contrasena, String telefono, ArrayList<Mascota> mascotas, ArrayList<Solicitud> solicitudes, Ubicacion ubicacion){
        Dueno dueno = new Dueno();
        dueno.setId(id);
        dueno.setNombre(nombre);
        dueno.setEmail(email);
        dueno.setContrasena(contrasena);
        dueno.setTelefono(telefono);
        dueno.setMascotas(mascotas);
        dueno.setSolicitudes(solicitudes);
        dueno.setUbicacion(ubicacion);
        return duenoRepositorio.save(dueno);
    }
    
    /*@Transactional
    public Dueno save(Dueno dueno) throws webException {
       if (dueno.getNombre().isEmpty() || dueno.getNombre()==null){
           throw new webException (" La persona debe tener un nombre");
       }
       if (dueno.getEmail().isEmpty() || dueno.getEmail()==null){
           throw new webException (" La persona debe tener un mail de contacto");
       }
       if (dueno.getContrasena().isEmpty() || dueno.getContrasena()==null){
           throw new webException (" La contraseña es obligatoria");
       }
       if (dueno.getTelefono().isEmpty() || dueno.getTelefono()==null){
           throw new webException (" La persona debe tener un teléfono de contacto");
       }
       if (dueno.getUbicacion()==null){
           throw new webException (" Ubicación obligatoria");
       }       
       return duenoRepositorio.save(dueno);
    }*/
    
    //Modificar dueño
    
    
    //Eliminar dueño (Creada en el caso de que haya un usuario de administrador)
    @Transactional
    public void delete (Dueno dueno){
        duenoRepositorio.delete(dueno);
    }
    
    @Transactional
    public void deleteById(String id){
        Optional<Dueno> optional = duenoRepositorio.findById(id);
        if (optional.isPresent()) {
            duenoRepositorio.delete(optional.get());
        }
    }
    
    
    
    
}
