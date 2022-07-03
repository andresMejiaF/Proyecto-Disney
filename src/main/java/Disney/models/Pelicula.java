package Disney.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titulo;
    private LocalDate fechaCreacion;
    private float calificacion;
    private String imagen;

   // @ManyToMany(mappedBy = "peliculas")
    //@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
   // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//  @ManyToMany( targetEntity = Personaje.class, cascade = CascadeType.ALL)
 /* @ManyToMany(cascade = {
           CascadeType.PERSIST,
           CascadeType.MERGE
   })
   @JoinTable(name = "pelicula_personaje",
           joinColumns = @JoinColumn(name = "pelicula_id"),
           inverseJoinColumns = @JoinColumn(name = "personaje_id")
   )
    @ToString.Exclude
    private List<Personaje> personajes = new ArrayList<>();
*/

    @ManyToMany
    @JoinTable(
            name = "pelicula_personaje",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id")
    )
    private Set<Personaje> personajes = new HashSet<>();


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Genero genero;

}
