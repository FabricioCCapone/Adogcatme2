/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.entidades.Adoptante;
import org.springframework.stereotype.Service;

@Service
public class AdoptanteServicio {
    public void registrar (String nombre, String email, String contrasena, String telefono){
        Adoptante adoptante = new Adoptante();
        adoptante.setNombre(nombre);
        adoptante.setEmail(email);
        adoptante.setContrasena(contrasena);
        adoptante.setTelefono(telefono);
        
    }
    
}
