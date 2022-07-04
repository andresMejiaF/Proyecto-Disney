package Disney.dao;

import Disney.Repositorios.PersonajeRepo;
import Disney.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class PersonajeDaoImp implements PersonajeDao{


    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private PersonajeRepo personajeRepo;
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

    @Override
    public Personaje actualizarPersonaje(Personaje personaje, Integer id) {

        Personaje personajeActual = entityManager.find(Personaje.class, id);
        personajeActual.setEdad(personaje.getEdad());
        personajeActual.setHistoria(personaje.getHistoria());
        personajeActual.setImagen(personaje.getImagen());
        personajeActual.setNombre(personaje.getNombre());
        personajeActual.setPeso(personaje.getPeso());

        return entityManager.merge(personajeActual);
    }

    @Override
    public Personaje obtenerDetalle(Integer id) {
        Personaje personaje = entityManager.find(Personaje.class, id);
        return personaje;
    }

    @Override
    public List<Personaje> buscarPorNombre(String palabra) {

        return personajeRepo.buscarPersonajes(palabra);
    }

    @Override
    public List<Personaje> buscarPorEdad(Integer edad) {
        return personajeRepo.buscarPersonajesEdad(edad);
    }


}
