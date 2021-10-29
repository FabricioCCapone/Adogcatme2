
package Adogcatme.Proyecto.Repositorios;

import Adogcatme.Proyecto.entidades.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenoRepositorio extends JpaRepository<Dueno, String>{
    
    
}
