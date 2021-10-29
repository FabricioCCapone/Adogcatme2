/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adogcatme.Proyecto.Repositorios;

import Adogcatme.Proyecto.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author fabri
 */
public interface MascotaRepositorio extends JpaRepository<Mascota, String>{
    
    @Query("SELECT m FROM Mascota m WHERE m.ubicacion = :")
    public Mascota findBy(@Param("ubica") String ubicacion); 
}
