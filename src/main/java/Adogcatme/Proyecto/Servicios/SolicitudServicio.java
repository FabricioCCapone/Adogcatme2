/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.Repositorios.SolicitudRepositorio;
import Adogcatme.Proyecto.entidades.Solicitud;
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

    public List<Solicitud> listAll() {
        return solicitudRepositorio.findAll();
    }

    @Transactional
    public Solicitud save(Solicitud solicitud) {
        return solicitudRepositorio.save(solicitud);
    }

    @Transactional
    public void delete(Solicitud solicitud) {
        solicitudRepositorio.delete(solicitud);
    }
}