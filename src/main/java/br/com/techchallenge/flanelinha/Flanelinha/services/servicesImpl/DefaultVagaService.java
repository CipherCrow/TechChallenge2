package br.com.techchallenge.flanelinha.Flanelinha.services.servicesImpl;

import br.com.techchallenge.flanelinha.Flanelinha.model.Vaga;
import br.com.techchallenge.flanelinha.Flanelinha.repository.VagaRepository;
import br.com.techchallenge.flanelinha.Flanelinha.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DefaultVagaService implements VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public List<Vaga> buscarVagaPorId(String localId) {
        return vagaRepository.findByLocalIdAndIsOcupada(localId, false);
    }

    public Vaga criarVaga(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    public void ocuparVaga(String vagaId) {
        Vaga vaga = vagaRepository.findById(vagaId).orElseThrow(() -> new IllegalArgumentException("Vaga não encontrada!"));
        if (!vaga.isOcupada()) {
            vaga.setOcupada(true);
            vagaRepository.save(vaga);
        }
    }

    public void liberarVaga(String vagaId) {
        Vaga vaga = vagaRepository.findById(vagaId).orElseThrow(() -> new IllegalArgumentException("Vaga não encontrada!"));
        if (vaga.isOcupada()) {
            vaga.setOcupada(false);
            vagaRepository.save(vaga);
        }
    }
}
