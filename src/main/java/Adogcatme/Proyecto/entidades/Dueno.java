package Adogcatme.Proyecto.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Dueno extends Usuario implements Serializable {
    
 
    @OneToMany
    private List<Mascota> mascotas;

    public Dueno() {
    }
    
    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(Mascota mascota) {
        mascotas.add(mascota);
    }

  
}