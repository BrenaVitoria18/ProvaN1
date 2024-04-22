package faculdade.prova_n1.resource;


import faculdade.prova_n1.model.Aluno;
import faculdade.prova_n1.service.AlunoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/aluno")
@Tag(name = "aluno", description = "documentação do resource aluno")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;
}
