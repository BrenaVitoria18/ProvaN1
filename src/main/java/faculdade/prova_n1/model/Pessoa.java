package faculdade.prova_n1.model;


import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Pessoa")
@Entity
@EqualsAndHashCode(of = "id")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;


    public void cadastrar(){}

}
