
package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.Repositorios.DuenoRepositorio;
import Adogcatme.Proyecto.entidades.Dueno;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class DuenoServicio {
    
    @Autowired
    private DuenoRepositorio duenoRepositorio;
    
    @Autowired
    private MascotaRepositorio mascotaRepositorio;
    
    @Autowired
    private MascotaServicio mascotaServicio;
    
    //Listar dueños
    public List <Dueno> listAll(){
        return duenoRepositorio.findAll();
    }
    
    //busqueda por ID
    public Optional<Dueno> findById(String id){
        return duenoRepositorio.findById(id);
    }
    
    //Eliminar mascota
    @Transactional
    public void eliminarMascota (Dueno dueno, Mascota mascota){
        if(dueno.getId().equals(mascota.getDueno().getId)){
            mascotaServicio.eliminarMascota(mascota);
        }else{
            try {
                System.out.println("El usuario no es dueño de la mascota");
            } catch (Exception e) {
            }
        }
    }
    
    //Editar mascota
    @Transactional
    public void editarMascota (Dueno dueno, Mascota mascota){
        if(dueno.getId().equals(mascota.getDueno().getId)){
            mascotaServicio.editarMascota(mascota);
        }else{
            try {
                System.out.println("El usuario no es dueño de la mascota");
            } catch (Exception e) {
            }
        }
    }
    
    //Agregar mascota
    @Transactional
    public void agregarMascota (Dueno dueno, Mascota mascota){
        try {
            mascota.setDueno(dueno);
            mascotaServicio.registrarMascota(mascota);
        } catch (Exception e) {
        }
    }
    
    //Modificar dueño
    @Transactional
    public Dueno modificar(@ModelAttribute Dueno dueno) throws Exception {
        if (duenoRepositorio.existsById(dueno.getId())) {
            duenoRepositorio.save(dueno);
        }
       return duenoRepositorio.save(dueno);
    }
    
    //Crear dueño 
    @Transactional
    public Dueno save(@ModelAttribute Dueno dueno) throws Exception {
       if (dueno.getNombre().isEmpty() || dueno.getNombre()==null){
           throw  new Exception (" La persona debe tener un nombre");
       }
       if (dueno.getEmail().isEmpty() || dueno.getEmail()==null){
           throw new Exception (" La persona debe tener un mail de contacto");
       }
       if (dueno.getContrasena().isEmpty() || dueno.getContrasena()==null){
           throw new Exception (" La contraseña es obligatoria");
       }
       if (dueno.getTelefono().isEmpty() || dueno.getTelefono()==null){
           throw new Exception (" La persona debe tener un teléfono de contacto");
       }
       if (dueno.getUbicacion()==null){
           throw new Exception (" Ubicación obligatoria");
       }       
       return duenoRepositorio.save(dueno);
    }
    
    //Eliminar dueño (Creada en el caso de que haya un usuario de administrador)
    @Transactional
    public void delete (Dueno dueno){
        duenoRepositorio.delete(dueno);
    }
    
    //Eliminar dueño por ID
    @Transactional
    public void deleteById(String id){
        Optional<Dueno> optional = duenoRepositorio.findById(id);
        if (optional.isPresent()) {
            duenoRepositorio.delete(optional.get());
        }
    }
    
    
    
    
}
