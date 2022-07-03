package Disney.dao;

import Disney.models.Pelicula;
import Disney.models.Personaje;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class PeliculaDaoImp implements PeliculaDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {

        return entityManager.merge(pelicula);
    }

    @Override
    public Pelicula asignarPersonaje(Integer peliculaId, Integer personajeId) {

        Pelicula pelicula = entityManager.find(Pelicula.class, peliculaId);
        Personaje personaje = entityManager.find(Personaje.class, personajeId);
        pelicula.getPersonajes().add(personaje);

        return entityManager.merge(pelicula);
    }

    @Override
    public String eliminarPelicula(Integer id) {
        Pelicula pelicula = entityManager.find(Pelicula.class, id);
        entityManager.remove(pelicula);
        return "Pelicula eliminada con exito";
    }

}
