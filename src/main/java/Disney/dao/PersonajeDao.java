package Disney.dao;

import Disney.models.Personaje;

public interface PersonajeDao {

    Personaje crearPersonaje(Personaje personaje);

    String eliminarPersonaje(Integer id);

    Personaje actualizarPersonaje(Personaje personaje, Integer id);

    Personaje obtenerDetalle(Integer id);
}
