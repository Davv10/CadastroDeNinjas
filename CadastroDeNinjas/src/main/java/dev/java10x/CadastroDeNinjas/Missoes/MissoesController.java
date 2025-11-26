package dev.java10x.CadastroDeNinjas.Missoes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService  missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao) {
         MissoesDTO novaMissao = missoesService.criarMissoes(missao);
         return ResponseEntity.status(HttpStatus.CREATED)
                 .body("Missao criada com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissao() {
        List<MissoesDTO> missoes = missoesService.listarMissao();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id) {
        MissoesDTO missoes = missoesService.listaMissaoPorId(id);
        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missao com id " + id + " nao existe nos nossos registros");
    }


    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissoes(@PathVariable Long id, @RequestBody MissoesDTO missoesAtualizado) {
        MissoesDTO missoes = missoesService.atualizarMissoes(id, missoesAtualizado);
        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com id " + id + " nao existe nos nossos registros");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
         if (missoesService.listaMissaoPorId(id) != null) {
             missoesService.deletarMissaoPorId(id);
             return ResponseEntity.ok("Missao delatada com sucesso");
         } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("Missao com id " + id + " nao existe nos nossos registros");
         }
    }


}
