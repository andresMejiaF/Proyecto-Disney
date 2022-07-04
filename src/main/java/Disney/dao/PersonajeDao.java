package Disney.dao;

import Disney.models.Personaje;

import java.util.List;

public interface PersonajeDao {

    Personaje crearPersonaje(Personaje personaje);

    String eliminarPersonaje(Integer id);

    Personaje actualizarPersonaje(Personaje personaje, Integer id);

    Personaje obtenerDetalle(Integer id);

    List<Personaje> buscarPorNombre(String palabra);

    List<Personaje> buscarPorEdad(Integer edad);
}
