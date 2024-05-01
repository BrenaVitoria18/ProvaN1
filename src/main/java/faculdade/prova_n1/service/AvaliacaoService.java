package faculdade.prova_n1.service;

import faculdade.prova_n1.model.Avaliacao;
import faculdade.prova_n1.model.Professor;
import faculdade.prova_n1.repository.AvaliacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AvaliacaoService {
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Transactional(rollbackFor = Exception.class)
    public Avaliacao criaAvaliacao(Avaliacao entity){
        return avaliacaoRepository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public Avaliacao listaAvaliacaoPorId(Long id){
        Optional<Avaliacao> avaliacaoExiste = avaliacaoRepository.findById(id);
        if (avaliacaoExiste.isPresent()){
            return avaliacaoExiste.get();
        }
        else {
            return new Avaliacao();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List listaTodasAvaliacoes(){
        return avaliacaoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Avaliacao atualizar(Long id, Avaliacao entity) {
        Avaliacao avaliacaoEncontrado = this.listaAvaliacaoPorId(id);
        if(avaliacaoEncontrado.getId_avaliacao() != 0 || avaliacaoEncontrado.getId_avaliacao() != null){
            return avaliacaoRepository.save(entity);
        } else {
            return new Avaliacao();
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void deletar(Long id) {
        avaliacaoRepository.deleteById(id);
    }
}
