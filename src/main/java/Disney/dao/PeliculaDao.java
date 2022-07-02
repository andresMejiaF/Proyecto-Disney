package Disney.dao;

import Disney.models.Pelicula;

import javax.persistence.criteria.CriteriaBuilder;

public interface PeliculaDao {

    Pelicula crearPelicula(Pelicula pelicula);

    Pelicula asignarPersonaje(Integer peliculaId, Integer personajeId);

    String eliminarPelicula(Integer id);

}
