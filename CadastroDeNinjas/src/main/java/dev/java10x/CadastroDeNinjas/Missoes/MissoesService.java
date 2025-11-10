package dev.java10x.CadastroDeNinjas.Missoes;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

    // Criar uma nova missao
    public MissoesModel criarMissoes(MissoesModel missoes) {
        return missoesRepository.save(missoes);
    }

    // Listar todas as Missoes
    public List<MissoesModel> listarMissao() {
        return missoesRepository.findAll();
    }

    // Listar todas as missoes por ID
    public MissoesModel listaMissaoPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    // Deletar missao - tem que ser um metodo VOID
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

}
