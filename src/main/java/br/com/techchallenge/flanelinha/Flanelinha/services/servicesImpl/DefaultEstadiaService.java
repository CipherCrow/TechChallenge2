package br.com.techchallenge.flanelinha.Flanelinha.services.servicesImpl;

import br.com.techchallenge.flanelinha.Flanelinha.model.Estadia;
import br.com.techchallenge.flanelinha.Flanelinha.model.Vaga;
import br.com.techchallenge.flanelinha.Flanelinha.repository.EstadiaRepository;
import br.com.techchallenge.flanelinha.Flanelinha.services.EstadiaService;
import br.com.techchallenge.flanelinha.Flanelinha.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class DefaultEstadiaService implements EstadiaService {

    @Autowired
    private EstadiaRepository estadiaRepository;

    @Autowired
    private VagaService vagaService;

    public Estadia iniciarEstadia(String usuarioId, String vagaId, int horasEstadia) {
        Vaga vaga = (Vaga) vagaService.buscarVagaPorId(vagaId);
        if (vaga.isOcupada()) {
            throw new IllegalStateException("Vaga já ocupada");
        }

        vagaService.ocuparVaga(vagaId);

        Estadia estadia = new Estadia();
        estadia.setUsuarioId(usuarioId);
        estadia.setVagaId(vagaId);
        estadia.setHoraEntrada(LocalDateTime.now());
        estadia.setHoraSaida(LocalDateTime.now().plusHours(horasEstadia));
        BigDecimal tarifaTotal = vaga.getTarifaPorHora().multiply(BigDecimal.valueOf(horasEstadia));
        estadia.setTarifaTotal(tarifaTotal);

        return estadiaRepository.save(estadia);
    }

    public void finalizarEstadia(String estadiaId) {
        Estadia estadia = estadiaRepository.findById(estadiaId).orElseThrow(() -> new IllegalArgumentException("Estadia não encontrada!"));
        vagaService.liberarVaga(estadia.getVagaId());
    }
}
