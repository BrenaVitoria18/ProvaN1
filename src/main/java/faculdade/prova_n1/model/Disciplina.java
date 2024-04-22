package faculdade.prova_n1.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Disciplina")
@Entity
@EqualsAndHashCode(of = "codigo")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descricao;
    private int cargaHoraria;
    private String ementa;
    private String bibliografia;

    public void cadastrar(){}

    @ManyToOne
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo")
    private Curso curso;


}
