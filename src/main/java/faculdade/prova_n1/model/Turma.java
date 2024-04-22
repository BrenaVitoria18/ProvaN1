package faculdade.prova_n1.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Turma")
@Entity
@EqualsAndHashCode(of = "id_turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_turma;
    private int ano;
    private int diaSemana;
    private String Horarios;


    public void abrirTurma(){}
    public void alocarProfessor(){}
    public void matricularAluno(){}
    public void emitirDiario(){}

    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    private Professor professor;

    @OneToOne
    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    private Disciplina disciplina;

    @ManyToMany
    @JoinTable(
            name = "turma_aluno",
            joinColumns = @JoinColumn(name = "turma_id", referencedColumnName = "id_turma"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private Set<Aluno> alunos = new HashSet<>();

}
