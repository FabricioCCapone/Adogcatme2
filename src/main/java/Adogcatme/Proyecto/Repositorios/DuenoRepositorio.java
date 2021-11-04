package Adogcatme.Proyecto.Repositorios;

import Adogcatme.Proyecto.entidades.Adoptante;
import Adogcatme.Proyecto.entidades.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenoRepositorio extends JpaRepository<Dueno, String> {

    @Query("select d from Dueno d  where d.email = :email ")
    Dueno findByEmail(@Param("email") String email);
}
