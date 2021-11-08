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
        new ArrayList<Mascota>();
    }
    

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

  
}