package Adogcatme.Proyecto.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Solicitud implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @OneToOne
    private Dueno dueno;
    @OneToOne
    private Mascota mascota;
    @OneToOne
    private Adoptante adoptante;
    
//    private Date fecha;
//    private Boolean estado; //0 = aceptada 1 = rechazada

    public Solicitud() {
    }

    public Solicitud(String id, Dueno dueno, Mascota mascota, Adoptante adoptante/*, Date fecha, Boolean estado*/) {
        this.id = id;
        this.dueno = dueno;
        this.mascota = mascota;
        this.adoptante = adoptante;
//        this.fecha = fecha;
//        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }

//    public Date getFecha() {
//        return fecha;
//    }
//
//    public void setFecha(Date fecha) {
//        this.fecha = fecha;
//    }
//
//    public Boolean getEstado() {
//        return estado;
//    }
//
//    public void setEstado(Boolean estado) {
//        this.estado = estado;
//    }


    
    
}
