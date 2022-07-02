package Disney.dao;

import Disney.models.Personaje;

public interface PersonajeDao {

    Personaje crearPersonaje(Personaje personaje);

    String eliminarPersonaje(Integer id);
}
