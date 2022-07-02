package Disney.controllers;

import Disney.dao.PeliculaDao;
import Disney.dao.PersonajeDao;
import Disney.models.Pelicula;
import Disney.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PeliculaController {

    @Autowired
    private PeliculaDao peliculaDao;

    @RequestMapping(value = "/pelicula", method = RequestMethod.POST)
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula){

        return peliculaDao.crearPelicula(pelicula);
    }

    @PutMapping("/{peliculaId}/peliculas/{personajeId}")
    public Pelicula addPersonajePelicula(
            @PathVariable Integer peliculaId,
            @PathVariable Integer personajeId
    ) {

        return peliculaDao.asignarPersonaje(peliculaId, personajeId);
    }

    @RequestMapping(value = "/eliminarPelicula/{id}", method = RequestMethod.DELETE)
    public String eliminarPelicula(@PathVariable Integer id) {

        return peliculaDao.eliminarPelicula(id);
    }

}
