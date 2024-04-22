package faculdade.prova_n1.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Curso")
@Entity(name = "Curso")
@EqualsAndHashCode(of = "codigo")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descricao;

    public void cadastrar(){}


    @ManyToOne
    @JoinColumn(name = "disciplina_id", referencedColumnName = "codigo") // Ajuste no nome da coluna
    private Disciplina disciplina;

    @ManyToMany
    @JoinTable(
            name = "curso_professor",
            joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "codigo"),
            inverseJoinColumns = @JoinColumn(name = "professor_id", referencedColumnName = "id")
    )
    private Set<Professor> professores;

    @ManyToOne
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo")
    private Curso curso;



}
