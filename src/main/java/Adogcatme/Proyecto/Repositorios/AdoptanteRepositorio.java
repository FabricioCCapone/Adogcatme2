
package Adogcatme.Proyecto.Repositorios;

import Adogcatme.Proyecto.entidades.Adoptante;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptanteRepositorio extends JpaRepository<Adoptante, String>{

    @Query("SELECT a FROM Adoptante a WHERE nombre = :nombre")
    public List<Adoptante> findByNombre(@Param("nombre") String nombre); 
 

    @Query("SELECT a FROM Adoptante a WHERE adoptante_id = :adoptante_id")
    public List<Adoptante> findByUsuarioId(@Param("usuario_id") String usuario_id); 
    
}
