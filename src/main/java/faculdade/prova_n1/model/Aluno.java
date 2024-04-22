package faculdade.prova_n1.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Aluno")
@Entity
@Data
@Builder
@DiscriminatorValue("Aluno")
@EqualsAndHashCode(callSuper = true)
public class Aluno  extends Pessoa{


    private String matricula;
    private String situacao;

    public void matricularCurso(){}
    public void trancar(){}
    public void formar(){}
    public void evedir(){}
    public void obterAvaliacoes(){}
    public void emitirHistorico(){}

    @ManyToMany(mappedBy = "alunos")
    private Set<Turma> turmas = new HashSet<>();

}
