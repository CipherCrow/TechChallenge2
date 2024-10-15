package br.com.techchallenge.flanelinha.Flanelinha.services.servicesImpl;

import br.com.techchallenge.flanelinha.Flanelinha.model.Usuario;
import br.com.techchallenge.flanelinha.Flanelinha.model.Veiculo;
import br.com.techchallenge.flanelinha.Flanelinha.repository.VeiculoRepository;
import br.com.techchallenge.flanelinha.Flanelinha.services.VeiculoService;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VeiculoServiceImp implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    private final MongoTemplate mongoTemplate;
    private MongoClient mongo;

    public VeiculoServiceImp(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Veiculo> buscarTodosVeiculos() {
        return this.veiculoRepository.findAll();
    }

    @Override
    public Veiculo criarVeiculo(Veiculo veiculo) {
        return this.veiculoRepository.save(veiculo);
    }

    @Override
    public Veiculo buscarVeiculo(String idVeiculo) {
        Objects.requireNonNull(idVeiculo, "O código do veiculo não deve estar nulo!");
        return this.veiculoRepository
                .findById(idVeiculo)
                .orElseThrow(() -> new IllegalArgumentException("Veiculo não encontrado!"));
    }

    @Override
    public void atualizarVeiculo(Veiculo veiculo) {
        Objects.requireNonNull(veiculo.getId(), "O código do veiculo não deve estar nulo!");
        this.veiculoRepository.findById(veiculo.getId())
                .orElseThrow(() -> new IllegalArgumentException("Veiculo não encontrado!"));
        this.veiculoRepository.save(veiculo);
    }

    @Override
    public void deletarVeiculo(String idVeiculo) {
        Objects.requireNonNull(idVeiculo, "O código do veiculo não deve estar nulo!");
        Query query = new Query(Criteria.where("id").is(idVeiculo));
        this.mongoTemplate.remove(query, Veiculo.class);
    }
}
