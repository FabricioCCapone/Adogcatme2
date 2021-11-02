
package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.Repositorios.DuenoUsuarioRepositorio;
import Adogcatme.Proyecto.entidades.DuenoUsuario;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenoUsuarioServicio {
    
    @Autowired
    private DuenoUsuarioRepositorio dur;
    
    @Transactional
    public DuenoUsuario save(String username, String contrasena1, String contrasena2){
        
        //Creo un objeto dueñoUsuario
        DuenoUsuario du = new DuenoUsuario();
        
        //falta agregar las excepciones de error (tanto para user como para password)
        if(username == null || username.isEmpty()){
            System.out.println("El usuario no puede ser nulo"); 
        }
        
        //Verifica que las contraseñas sean iguales sino envia otra excepcion
        if (!contrasena1.equals(contrasena2)) {
            System.out.println("Las contraseñas no son iguales");
        }
        
        du.setUsuario(username);
        du.setContrasena(contrasena1);
        
        return dur.save(du);
    }
    
}
