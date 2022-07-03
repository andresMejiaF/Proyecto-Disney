package Disney.dao;

import Disney.models.Genero;
import Disney.models.Pelicula;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Transactional
@Repository
public class GeneroDaoImp implements GeneroDao{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Genero crearGenero(Genero genero) {
        return entityManager.merge(genero);
    }

}
