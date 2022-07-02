package Disney.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Personaje")
public class Personaje {
/*
    ○ Imagen
○ Películas o series asociadas
*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private Integer edad;
    private float peso;
    private String historia;
    private String imagen;

    //@ManyToMany(mappedBy = "personajes", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
   // @ManyToMany(mappedBy = "personajes", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
  // @ManyToMany(mappedBy = "personajes", targetEntity = Pelicula.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  /*  @ManyToMany(mappedBy = "personajes", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
     /* @ManyToMany(cascade = {
           CascadeType.PERSIST,
           CascadeType.MERGE
   })
   @JoinTable(name = "pelicula_personajes",
           joinColumns = @JoinColumn(name = "peliculas_id"),
           inverseJoinColumns = @JoinColumn(name = "personajes_id")
   ) */
    /*
    @ManyToMany(mappedBy = "personajes", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @ToString.Exclude
    private List<Pelicula> peliculas = new ArrayList<>();
    */
    @JsonIgnore
    @ManyToMany(mappedBy = "personajes")
    private Set<Pelicula> peliculas = new HashSet<>();
}
