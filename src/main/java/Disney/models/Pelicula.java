package Disney.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Pelicula")
public class Pelicula {

    /*■ Imagen
■ Título
■ Fecha de creación
■ Calificación (del 1 al 5)
■ Personajes asociados*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titulo;
    private LocalDate fechaCreacion;
    private float Calificacion;

    @ManyToMany(mappedBy = "peliculas")
    @ToString.Exclude
    private List<Personaje> personajes;

    @ManyToOne
    private Genero genero;


}
