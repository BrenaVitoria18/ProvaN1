package faculdade.prova_n1.service;

import faculdade.prova_n1.model.Professor;
import faculdade.prova_n1.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Transactional(rollbackFor = Exception.class)
    public Professor criarProfessor(Professor entity){
        return professorRepository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public Professor listaProfessorPorId(Long id){
        Optional<Professor> professorExiste = professorRepository.findById(id);
        if (professorExiste.isPresent()){
            return professorExiste.get();
        }
        else {
            return new Professor();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List listaTodosProfessores(){
        return professorRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Professor atualizar(Long id, Professor entity) {
        Professor professorEncontrado = this.listaProfessorPorId(id);
        if(professorEncontrado.getId() != 0 || professorEncontrado.getId() != null){
            return professorRepository.save(entity);
        } else {
            return new Professor();
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void deletar(Long id) {
        professorRepository.deleteById(id);
    }
}
