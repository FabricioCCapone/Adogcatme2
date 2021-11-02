/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adogcatme.Proyecto.Repositorios;

import Adogcatme.Proyecto.entidades.Mascota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author fabri
 */
public interface MascotaRepositorio extends JpaRepository<Mascota, String>{
    
    @Query("SELECT m FROM Mascota m JOIN Dueno d WHERE d.id = m.dueno_id AND (SELECT * FROM Dueno dd, Adoptante a WHERE a.ciudad AND dd.ciudad = :ciudad)")
    public List<Mascota> findByUbicacion(@Param("ciudad") String ciudad); 

    @Query("SELECT m FROM Mascota m WHERE tipo = :tipo)")
    public List<Mascota> findByTipo(@Param("tipo") String tipo); 
 
    @Query("SELECT m FROM Mascota m WHERE sexo = :sexo)")
    public List<Mascota> findBySexo(@Param("sexo") String sexo); 

    @Query("SELECT m FROM Mascota m WHERE castrado = :castrado)")
    public List<Mascota> findByCastrado(@Param("castrado") Integer castrado); 
}
