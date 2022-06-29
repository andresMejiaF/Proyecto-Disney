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
@Table(name = "Genero")
public class Genero {

    /*■ Nombre
■ Imagen
■ Películas o series asociadas*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String imagen;

    @OneToMany(mappedBy = "genero")
    @ToString.Exclude
    private List<Pelicula> peliculasAsociadas;
}