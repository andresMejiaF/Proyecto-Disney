package Disney.controllers;


import Disney.dao.GeneroDao;
import Disney.dao.PeliculaDao;
import Disney.models.Genero;
import Disney.models.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneroController {

    @Autowired
    private GeneroDao generoDao;

    @RequestMapping(value = "/genero", method = RequestMethod.POST)
    public Genero crearGenero(@RequestBody Genero genero){

        return generoDao.crearGenero(genero);
    }
}
