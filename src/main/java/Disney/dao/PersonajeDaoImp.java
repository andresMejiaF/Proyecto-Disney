package Disney.dao;

import Disney.models.Personaje;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
@Transactional
public class PersonajeDaoImp implements PersonajeDao{


    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Personaje crearPersonaje(Personaje personaje) {
        return entityManager.merge(personaje);
    }

    @Override
    public String eliminarPersonaje(Integer id) {
        Personaje personaje = entityManager.find(Personaje.class, id);
        entityManager.remove(personaje);
        return "Personaje eliminado con exito";
    }
}
