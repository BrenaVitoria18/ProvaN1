package faculdade.prova_n1.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_avaliacao;
    private float nota1;
    private float nota2;
    private float notaProvaFinal;
    private int frequencia;


    public void lancarAvaliacao(){}
    public void calcularAprovacao(){}

    @ManyToOne
    @JoinColumn(name = "id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

}
