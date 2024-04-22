package faculdade.prova_n1.repository;

import faculdade.prova_n1.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
