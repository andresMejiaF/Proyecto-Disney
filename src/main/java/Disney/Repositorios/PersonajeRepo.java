package Disney.Repositorios;

import Disney.models.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonajeRepo extends JpaRepository<Personaje, Integer> {

    @Query("select p from Personaje p where p.nombre like concat('%', :cadena,'%')")
    List<Personaje> buscarPersonajes(String cadena);


    @Query("select p from Personaje p where p.edad = :edad")
    List<Personaje> buscarPersonajesEdad(Integer edad);





}
