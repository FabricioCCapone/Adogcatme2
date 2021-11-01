
package Adogcatme.Proyecto.Repositorios;

import Adogcatme.Proyecto.entidades.Adoptante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptanteRepositorio extends JpaRepository<Adoptante, String> {
    
}
