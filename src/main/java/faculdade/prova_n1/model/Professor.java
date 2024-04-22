package faculdade.prova_n1.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Professor")
@Entity(name = "Professor")
@Data
@Builder
@DiscriminatorValue("Professor")
@EqualsAndHashCode(callSuper = true)
public class Professor extends Pessoa {

    private Long id;
    private String titulacaoMaxima;

    @Override
    public void cadastrar(){}


    @OneToMany(mappedBy = "professor")
    private Set<Turma> turmas = new HashSet<>();

    @ManyToMany(mappedBy = "professores")
    private Set<Curso> cursos;

}
