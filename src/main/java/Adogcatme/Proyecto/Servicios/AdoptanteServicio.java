/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.Repositorios.AdoptanteRepositorio;
import Adogcatme.Proyecto.entidades.Adoptante;
import exepciones.WebExeption;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptanteServicio {

    @Autowired
    private AdoptanteRepositorio adoptanteRepositorio;

    public void registrar(String nombre, String email, String contrasena, String telefono) throws WebExeption {

        validar(nombre, email, contrasena, telefono);
        Adoptante adoptante = new Adoptante();
        adoptante.setNombre(nombre);
        adoptante.setEmail(email);
        adoptante.setContrasena(contrasena);
        adoptante.setTelefono(telefono);

        adoptanteRepositorio.save(adoptante);

    }

    public void modificar(String id, String nombre, String email, String contrasena, String telefono) throws WebExeption {

        validar(nombre, email, contrasena, telefono);

        Optional<Adoptante> respuesta = adoptanteRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Adoptante adoptante = respuesta.get();
            adoptante.setNombre(nombre);
            adoptante.setEmail(email);
            adoptante.setTelefono(telefono);
            adoptante.setContrasena(contrasena);

            adoptanteRepositorio.save(adoptante);
        } else {
            throw new WebExeption("no se encontro el usuario");
        }

    }

    public Adoptante findByEmail(String email) {
        return adoptanteRepositorio.findByEmail(email);
    }

    public void validar(String nombre, String email, String contrasena, String telefono) throws WebExeption {
        if (nombre == null || nombre.isEmpty()) {
            throw new WebExeption("Nombre no puede ser nulo");
        }
        if (email == null || email.isEmpty()) {
            throw new WebExeption("Email no puede ser nulo");
        }
        if (contrasena == null || contrasena.isEmpty()) {
            throw new WebExeption("contrasena no puede ser nulo");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new WebExeption("telefono no puede ser nulo");
        }
    }
}
