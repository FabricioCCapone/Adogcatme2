package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.Repositorios.MascotaRepositorio;
import Adogcatme.Proyecto.entidades.Adoptante;
import Adogcatme.Proyecto.entidades.Mascota;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Capoun
 */
@Service
public class MascotaServicio {

    @Autowired
    MascotaRepositorio mr;

    public Mascota findById(String id){
        return mr.getById(id);
    }
    
    public List<Mascota> findByUbicacion(Adoptante a){
        return mr.findByUbicacion(a.getUbicacion().getCiudad());
    }
    
    public List<Mascota> findByTipo(String tipo){
        return mr.findByTipo(tipo);
    }
    
    public List<Mascota> findByCastrado(String castrado){
        if(castrado.equals("SI")){
            return mr.findByCastrado(0);
        }
        return mr.findByCastrado(1);
    }
    
    public List<Mascota> findBySexo(String sexo){
        if(sexo.equals("MACHO")){
            return mr.findBySexo("MACHO");
        }else{
            return mr.findBySexo("HEMBRA");
        }
    } 
    
    @Transactional
    public void registrarMascota(Mascota m) throws Exception {
        verificarRegistro(m);
        mr.save(m);
    }

    @Transactional
    public void editarMascota(Mascota m) {
        try {
            if (mr.existsById(m.getId())) {
                mr.save(m);
            }
        } catch (Exception e) {
        }
    }

    @Transactional
    public void eliminarMascota(Mascota m){    
        try {
            if (mr.existsById(m.getId())) {
                mr.deleteById(m.getId());
            }
        } catch (Exception e) {
        }
    }
    
    public void verificarRegistro(Mascota m) throws Exception {
        if (m.getNombre().isEmpty() || m.getNombre() == null) {
            throw new Exception("El nombre de la mascota no puede estar vacio.");
        }
        if (m.getDescripcion().isEmpty() || m.getDescripcion() == null) {
            throw new Exception("La descripcion de la mascota no puede estar vacia.");
        }
        if (m.getRaza().isEmpty() || m.getRaza() == null) {
            throw new Exception("La raza de la mascota no puede estar vacia.");
        }
        if (m.getSexo().isEmpty() || m.getSexo() == null) {
            throw new Exception("Debes elegir el sexo de la mascota.");
        }
        if (m.getTamano().isEmpty() || m.getTamano() == null) {
            throw new Exception("Debes indicar el peso de la mascota.");
        }
        if (m.getTipo().isEmpty() || m.getTipo() == null) {
            throw new Exception("Debes indicar el tipo de mascota.");
        }
        if (m.getEdad() == 0 || m.getTipo() == null) {
            throw new Exception("La edad de la mascota no puede estar vacia.");
        }
        if (m.getPeso() == 0 || m.getPeso() == null) {
            throw new Exception("El peso de la mascota no puede estar vacio.");
        }
        if (m.getImagen() == null) {
            throw new Exception("Debe subir una imagen de la mascota.");
        }
        if (m.getCastrado() == null) {
            throw new Exception("Debe indicar si la mascota esta castrada o no.");
        }
    }
}
