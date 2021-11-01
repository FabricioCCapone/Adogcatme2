/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adogcatme.Proyecto.Controladores;

import Adogcatme.Proyecto.Servicios.SolicitudServicio;
import Adogcatme.Proyecto.entidades.Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Extre
 */
@Controller
@RequestMapping("/")
public class SolicitudControlador {
    
    @Autowired
    private SolicitudServicio solicitudServicio;
    
    @GetMapping("/list")
    public String listAll(Model model){
        model.addAttribute("solicitudes", solicitudServicio.listAll());
    return "redirect:/";}
    
    @PostMapping("/save")
    public String save(@ModelAttribute Solicitud solicitud){
        solicitudServicio.save(solicitud);
    return "redirect:/";}
    
    @GetMapping("/delete")
    public String delete(@ModelAttribute Solicitud solicitud){
        solicitudServicio.delete(solicitud);
    return "redirect:/";}
}
