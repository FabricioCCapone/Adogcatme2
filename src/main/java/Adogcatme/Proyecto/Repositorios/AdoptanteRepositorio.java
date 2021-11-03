
package Adogcatme.Proyecto.Repositorios;

import Adogcatme.Proyecto.entidades.Adoptante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptanteRepositorio extends JpaRepository<Adoptante, String> {
    @Query("select a from Adoptante a  where a.email = :email ")
    Adoptante findByEmail(@Param("email") String email);
}
