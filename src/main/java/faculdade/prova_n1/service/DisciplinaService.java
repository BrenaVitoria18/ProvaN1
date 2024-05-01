package faculdade.prova_n1.service;

import faculdade.prova_n1.model.Avaliacao;
import faculdade.prova_n1.model.Curso;
import faculdade.prova_n1.model.Disciplina;
import faculdade.prova_n1.repository.AvaliacaoRepository;
import faculdade.prova_n1.repository.CursoRepository;
import faculdade.prova_n1.repository.DisciplinaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Transactional(rollbackFor = Exception.class)
    public Disciplina criarDisciplina(Disciplina entity){
        return disciplinaRepository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public Disciplina listaDisciplinaPorId(Long id){
        Optional<Disciplina> cursoExiste = disciplinaRepository.findById(id);
        if (cursoExiste.isPresent()){
            return cursoExiste.get();
        }
        else {
            return new Disciplina();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List listaTodasDisciplinas(){
        return disciplinaRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Disciplina atualizar(Long id, Disciplina entity) {
        Disciplina disciplinaEncontrada = this.listaDisciplinaPorId(id);
        if(disciplinaEncontrada.getCodigo() != 0 || disciplinaEncontrada.getCodigo() != null){
            return disciplinaRepository.save(entity);
        } else {
            return new Disciplina();
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void deletar(Long id) {
        disciplinaRepository.deleteById(id);
    }
}
