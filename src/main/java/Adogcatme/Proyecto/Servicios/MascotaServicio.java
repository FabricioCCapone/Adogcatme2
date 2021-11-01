package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.Repositorios.MascotaRepositorio;
import Adogcatme.Proyecto.entidades.Mascota;
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
    
    public void registrarMascota(Mascota m) throws Exception{
        verificarRegistro(m);
        mr.save(m);
    }
    
    public void editarMascota(){
        
    }
    
    public void verificarRegistro(Mascota m) throws Exception{
        if(m.getNombre().isEmpty() || m.getNombre() == null){
            throw new Exception("El nombre de la mascota no puede estar vacio.");
        }
        if(m.getDescripcion().isEmpty() || m.getDescripcion()== null){
            throw new Exception("La descripcion de la mascota no puede estar vacia.");
        }
        if(m.getRaza().isEmpty() || m.getRaza() == null){
            throw new Exception("La raza de la mascota no puede estar vacia.");
        }
        if(m.getSexo().isEmpty() || m.getSexo() == null){
            throw new Exception("Debes elegir el sexo de la mascota.");
        }
        if(m.getTamano().isEmpty() || m.getTamano()== null){
            throw new Exception("Debes indicar el peso de la mascota.");
        }
        if(m.getTipo().isEmpty() || m.getTipo() == null){
            throw new Exception("Debes indicar el tipo de mascota.");
        }
        if(m.getEdad() == 0 || m.getTipo() == null){
            throw new Exception("La edad de la mascota no puede estar vacia.");
        }
        if(m.getPeso()== 0 || m.getPeso() == null){
            throw new Exception("El peso de la mascota no puede estar vacio.");
        }
        if(m.getImagen() == null){
            throw new Exception("Debe subir una imagen de la mascota.");
        }
        if(m.getCastrado()== null){
            throw new Exception("Debe indicar si la mascota esta castrada o no.");
        } 
    }
}

