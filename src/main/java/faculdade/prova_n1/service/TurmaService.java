package faculdade.prova_n1.service;

import faculdade.prova_n1.model.Aluno;
import faculdade.prova_n1.model.Turma;
import faculdade.prova_n1.repository.AlunoRepository;
import faculdade.prova_n1.repository.TurmaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    @Transactional(rollbackFor = Exception.class)
    public Turma criarTurma(Turma entity){
        return turmaRepository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public Turma listaTurmaPorID(Long id){
        Optional<Turma> turmaExiste = turmaRepository.findById(id);
        if (turmaExiste.isPresent()){
            return turmaExiste.get();
        }
        else {
            return new Turma();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List listaTodasTurmas(){
        return turmaRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Turma atualizar(Long id, Turma entity) {

        Turma turmaEncontrada = this.listaTurmaPorID(id);

        if(turmaEncontrada.getId_turma() != 0 || turmaEncontrada.getId_turma() != null){
            return turmaRepository.save(entity);
        } else {
            return new Turma();
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void deletar(Long id) {
        turmaRepository.deleteById(id);
    }
}
