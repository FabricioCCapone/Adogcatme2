/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.Repositorios.UbicacionRepositorio;
import Adogcatme.Proyecto.entidades.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JUAN
 */



@Service
public class UbicacionServicio {

    @Autowired 
    private UbicacionRepositorio r;
    
    public Ubicacion cargarubicacion(String provincia, String ciudad, String barrio, String direccion){
        Ubicacion ubicacion = new Ubicacion();
        
        ubicacion.setProvincia(provincia);
        ubicacion.setCiudad(ciudad);
        ubicacion.setDireccion(direccion);
        ubicacion.setBarrio(barrio);
        
        return r.save(ubicacion);
        
    }
}
