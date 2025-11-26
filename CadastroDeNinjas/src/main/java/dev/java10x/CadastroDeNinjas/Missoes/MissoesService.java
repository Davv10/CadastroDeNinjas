package dev.java10x.CadastroDeNinjas.Missoes;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper){
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;

    }

    public MissoesDTO criarMissoes(MissoesDTO missoesDTO) {
        MissoesModel missoes =  missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    public List<MissoesDTO> listarMissao() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return  missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listaMissaoPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesDTO atualizarMissoes(Long id, MissoesDTO missoesDTO) {
        Optional<MissoesModel> missoesExistente = missoesRepository.findById(id);
        if (missoesExistente.isPresent()) {
            MissoesModel missoesAtualizado = missoesMapper.map(missoesDTO);
            missoesAtualizado.setId(id);
            MissoesModel missoesSalvo = missoesRepository.save(missoesAtualizado);
            return missoesMapper.map(missoesSalvo);
        }
        return null;
    }

}
