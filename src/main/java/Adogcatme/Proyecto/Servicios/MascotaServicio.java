package Adogcatme.Proyecto.Servicios;

import Adogcatme.Proyecto.Repositorios.FiltroRepositorio;
import Adogcatme.Proyecto.Repositorios.MascotaRepositorio;
import Adogcatme.Proyecto.entidades.Dueno;
import Adogcatme.Proyecto.entidades.Mascota;
import exepciones.WebExeption;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaServicio {

    @Autowired
    MascotaRepositorio mr;

    @Autowired
    FiltroRepositorio fr;

    @Autowired
    DuenoServicio ds;


    public List<Mascota> findByFiltro(String raza, String tipo, Integer edad, String sexo, String tamano, Boolean castrado) {
        Integer cast_valor;
        if (castrado) {
            cast_valor = 0;
        } else {
            cast_valor = 1;
        }
        return fr.filtro(raza, tipo, edad, sexo, tamano, cast_valor);
    }

    public Optional<Mascota> findById(String id) {
        return mr.findById(id);
    }
    
    public List<Mascota> listAll() {
        return mr.findAll();
    }

    @Transactional
    public void registrarMascota(Mascota m, Dueno d) throws WebExeption, Exception {
        verificarRegistro(m);
        m.setDueno(d);
        mr.save(m);
        d.getMascotas().add(m);
        ds.save(d);
    }

    @Transactional
    public void editarMascota(Mascota m) throws WebExeption {
        if (mr.existsById(m.getId())) {
            mr.save(m);
        }
    }

    @Transactional
    public void eliminarMascota(Mascota m) throws WebExeption {
        if (mr.existsById(m.getId())) {
            mr.deleteById(m.getId());
        }
    }

    public void verificarRegistro(Mascota m) throws WebExeption {
        if (m.getNombre().isEmpty() || m.getNombre() == null) {
            throw new WebExeption("El nombre de la mascota no puede estar vacio.");
        }
        if (m.getDescripcion().isEmpty() || m.getDescripcion() == null) {
            throw new WebExeption("La descripcion de la mascota no puede estar vacia.");
        }
        if (m.getRaza().isEmpty() || m.getRaza() == null) {
            throw new WebExeption("La raza de la mascota no puede estar vacia.");
        }
        if (m.getSexo().isEmpty() || m.getSexo() == null) {
            throw new WebExeption("Debes elegir el sexo de la mascota.");
        }
        if (m.getTamano().isEmpty() || m.getTamano() == null) {
            throw new WebExeption("Debes indicar el peso de la mascota.");
        }
        if (m.getTipo().isEmpty() || m.getTipo() == null) {
            throw new WebExeption("Debes indicar el tipo de mascota.");
        }
        if (m.getEdad() == 0 || m.getEdad() == null) {
            throw new WebExeption("La edad de la mascota no puede estar vacia.");
        }
        if (m.getPeso() == 0 || m.getPeso() == null) {
            throw new WebExeption("El peso de la mascota no puede estar vacio.");
        }
//        if (m.getImagen() == null) {
//            throw new WebExeption("Debe subir una imagen de la mascota.");
//        }
        if (m.getCastrado() == null) {
            throw new WebExeption("Debe indicar si la mascota esta castrada o no.");
        }
    }
}
