
package Adogcatme.Proyecto.Repositorios;

import Adogcatme.Proyecto.entidades.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepositorio extends JpaRepository<Imagen, String> {

    @Query("select i from Imagen i where id = :id")
    public Imagen findByIde(@Param("id") String id);
}
