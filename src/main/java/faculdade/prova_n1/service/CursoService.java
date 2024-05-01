package faculdade.prova_n1.service;

import faculdade.prova_n1.model.Curso;
import faculdade.prova_n1.model.Disciplina;
import faculdade.prova_n1.repository.CursoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Transactional(rollbackFor = Exception.class)
    public Curso criarCurso(Curso entity){
        return cursoRepository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public Curso listaCursoPorId(Long id){
        Optional<Curso> cursoExiste = cursoRepository.findById(id);
        if (cursoExiste.isPresent()){
            return cursoExiste.get();
        }
        else {
            return new Curso();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List listaTodosCursos(){
        return cursoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Curso atualizar(Long id, Curso entity) {
        Curso cursoEncontrado = this.listaCursoPorId(id);
        if(cursoEncontrado.getCodigo() != 0 || cursoEncontrado.getCodigo() != null){
            return cursoRepository.save(entity);
        } else {
            return new Curso();
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void deletar(Long id) {
        cursoRepository.deleteById(id);
    }
}
