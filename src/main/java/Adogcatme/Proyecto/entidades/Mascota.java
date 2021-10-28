
package Adogcatme.Proyecto.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Mascota implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @ManyToOne
    private Dueno dueno;
    
    private Adoptante adoptante;
    private String raza;
    private String tipo;
    private Integer edad;
    private String sexo;
    private String descripcion;
    private Double peso;
    
    @OneToOne
    private Imagen imagen;
    
    private String tamano;
    private Boolean castrado;
    private String estado;

    public Mascota() {
    }

    public Mascota(String id, Dueno dueno, Adoptante adoptante, String raza, String tipo, Integer edad, String sexo, String descripcion, Double peso, Imagen imagen, String tamano, Boolean castrado, String estado) {
        this.id = id;
        this.dueno = dueno;
        this.adoptante = adoptante;
        this.raza = raza;
        this.tipo = tipo;
        this.edad = edad;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.imagen = imagen;
        this.tamano = tamano;
        this.castrado = castrado;
        this.estado = estado;
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public Boolean getCastrado() {
        return castrado;
    }

    public void setCastrado(Boolean castrado) {
        this.castrado = castrado;
    }
    
    
    
}
