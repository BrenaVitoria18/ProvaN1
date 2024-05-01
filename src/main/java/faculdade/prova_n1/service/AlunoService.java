package faculdade.prova_n1.service;

import faculdade.prova_n1.model.Aluno;
import faculdade.prova_n1.repository.AlunoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional(rollbackFor = Exception.class)
    public Aluno criarAluno(Aluno entity){
        return alunoRepository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public Aluno listaAlunoPorId(Long id){
        Optional<Aluno> alunoExiste = alunoRepository.findById(id);
        if (alunoExiste.isPresent()){
            return alunoExiste.get();
        }
        else {
            return new Aluno();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List listaTodosAlunos(){
        return alunoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Aluno atualizar(Long id, Aluno entity) {

        Aluno alunoEncontrado = this.listaAlunoPorId(id);

        if(alunoEncontrado.getId() != 0 || alunoEncontrado.getId() != null){
            return alunoRepository.save(entity);
        } else {
            return new Aluno();
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }


}
