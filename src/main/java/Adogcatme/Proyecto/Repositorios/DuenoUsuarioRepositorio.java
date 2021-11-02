
package Adogcatme.Proyecto.Repositorios;

import Adogcatme.Proyecto.entidades.DuenoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenoUsuarioRepositorio extends JpaRepository<DuenoUsuario, String>{
    
}
