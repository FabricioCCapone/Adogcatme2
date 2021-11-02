/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.UbicacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author JUAN
 */
public class UbicacionControlador {
     @Autowired UbicacionServicio us;
     
     @GetMapping("/form")
    public String crearubicacion(){
        return "ubicacionform";
    }
   
}
