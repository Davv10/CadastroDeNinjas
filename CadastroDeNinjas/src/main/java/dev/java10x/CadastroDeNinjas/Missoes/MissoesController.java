package dev.java10x.CadastroDeNinjas.Missoes;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService  missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar missoes (CREATE)
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao) {
        return missoesService.criarMissoes(missao);
    }


    // Mostrar todos as missoes (READ)
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao() {
        return missoesService.listarMissao();
    }

    //  Mostrar missoes por ID (READ)
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id) {
        return missoesService.listaMissaoPorId(id);
    }

    //  Alterar dados de missoes (UPDATE)
    @PutMapping("/alterarID")
    public String alterarMissao() {
        return "Missão alterada com sucesso";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
         missoesService.deletarMissaoPorId(id);
    }


}
