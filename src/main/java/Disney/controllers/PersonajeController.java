package Disney.controllers;

import Disney.dao.PersonajeDao;
import Disney.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonajeController {

    @Autowired
    private PersonajeDao personajeDao;

    @RequestMapping (value = "/personaje", method = RequestMethod.POST)
    public Personaje crearPersonaje(@RequestBody Personaje personaje){

        return personajeDao.crearPersonaje(personaje);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public String eliminar(@PathVariable Integer id) {

        return personajeDao.eliminarPersonaje(id);
    }

    @PutMapping (value = "/actualizarPersonaje/{id}")
    public Personaje actualizarPersonaje(@RequestBody Personaje personaje, @PathVariable Integer id){

        return personajeDao.actualizarPersonaje(personaje, id);
    }

    @RequestMapping (value = "/detallePersonaje/{id}", method = RequestMethod.GET)
    public Personaje obtenerDetallePersonaje( @PathVariable Integer id){
        return personajeDao.obtenerDetalle(id);
    }

}
