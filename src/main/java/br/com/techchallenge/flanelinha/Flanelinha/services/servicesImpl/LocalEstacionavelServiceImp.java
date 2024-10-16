package br.com.techchallenge.flanelinha.Flanelinha.services.servicesImpl;

import br.com.techchallenge.flanelinha.Flanelinha.model.LocalEstacionavel;
import br.com.techchallenge.flanelinha.Flanelinha.repository.LocalEstacionavelRepository;
 import br.com.techchallenge.flanelinha.Flanelinha.services.LocalEstacionavelService;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LocalEstacionavelServiceImp implements LocalEstacionavelService {

    @Autowired
    private LocalEstacionavelRepository localEstacionavelRepository;

    private final MongoTemplate mongoTemplate;
    private MongoClient mongo;

    public LocalEstacionavelServiceImp(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<LocalEstacionavel> buscarTodosLocais() {
        return this.localEstacionavelRepository.findAll();
    }

    @Override
    public LocalEstacionavel criarLocal(LocalEstacionavel localEstacionavel) {
        return this.localEstacionavelRepository.save(localEstacionavel);
    }

    @Override
    public LocalEstacionavel buscarLocal(String idLocal) {
        Objects.requireNonNull(idLocal, "O código do local não deve estar nulo!");
        return this.localEstacionavelRepository
                .findById(idLocal)
                .orElseThrow(() -> new IllegalArgumentException("Local não encontrado!"));
    }

    @Override
    public void atualizarLocal(LocalEstacionavel localEstacionavel) {
        Objects.requireNonNull(localEstacionavel.getId(),
                "O código do Local não deve estar nulo!");
        this.localEstacionavelRepository.findById(localEstacionavel.getId())
                .orElseThrow(() -> new IllegalArgumentException("Local não encontrado!"));
        this.localEstacionavelRepository.save(localEstacionavel);
    }

    @Override
    public void deletarLocal(String idLocal) {
        Objects.requireNonNull(idLocal, "O código do Cartão não deve estar nulo!");
        Query query = new Query(Criteria.where("id").is(idLocal));
        this.mongoTemplate.remove(query, LocalEstacionavel.class);
    }
}
