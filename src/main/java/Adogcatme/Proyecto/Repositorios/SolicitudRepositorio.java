/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adogcatme.Proyecto.Repositorios;

import Adogcatme.Proyecto.entidades.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Extre
 */
@Repository
public interface SolicitudRepositorio extends JpaRepository<Solicitud, String> {

    @Query("SELECT s FROM Solicitud s WHERE adoptante_id = :adoptante_id AND mascota_id = :mascota_id")
    public Solicitud findByAyM(@Param("adoptante_id") String adoptante_id, @Param("mascota_id") String mascota_id);
}
