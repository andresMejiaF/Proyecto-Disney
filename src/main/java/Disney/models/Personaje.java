package Disney.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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


    @ManyToMany
    @ToString.Exclude
    private List<Pelicula> peliculas;

}
