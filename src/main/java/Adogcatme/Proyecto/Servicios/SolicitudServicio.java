/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.Repositorios.SolicitudRepositorio;
import Adogcatme.Proyecto.entidades.Adoptante;
import Adogcatme.Proyecto.entidades.Dueno;
import Adogcatme.Proyecto.entidades.Mascota;
import Adogcatme.Proyecto.entidades.Solicitud;
import exepciones.WebExeption;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Extre
 */
@Service
public class SolicitudServicio {

    @Autowired
    private SolicitudRepositorio solicitudRepositorio;
    
    @Autowired 
    private DuenoServicio duenoServicio;
    @Autowired
    private AdoptanteServicio adoptanteServicio;
    
    public List<Solicitud> listAll() {
        
        return solicitudRepositorio.findAll();
    }

    @Transactional
    public Solicitud save(Adoptante adoptante,Mascota mascota) throws WebExeption {
        Solicitud solicitud = new Solicitud();
        Dueno dueno = duenoServicio.findByIde(mascota.getDueno().getId());
        solicitud.setAdoptante(adoptante);
        solicitud.setMascota(mascota);
        solicitud.setDueno(dueno);
        adoptanteServicio.save(adoptante,solicitud);
        duenoServicio.saveSolicitud(dueno, solicitud);
        System.out.println("ID de la solicitud que llega" + solicitud.getId());
        return solicitudRepositorio.save(solicitud);
    }

    @Transactional
    public void delete(Solicitud solicitud) {
        
        solicitudRepositorio.delete(solicitud);
    }
}