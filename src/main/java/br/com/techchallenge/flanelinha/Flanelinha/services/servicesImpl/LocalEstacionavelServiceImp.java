package br.com.techchallenge.flanelinha.Flanelinha.services.servicesImpl;

import br.com.techchallenge.flanelinha.Flanelinha.model.LocalEstacionavel;
import br.com.techchallenge.flanelinha.Flanelinha.repository.LocalEstacionavelRepository;
 import br.com.techchallenge.flanelinha.Flanelinha.services.LocalEstacionavelService;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

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
        return List.of();
    }

    @Override
    public LocalEstacionavel criarLocal(LocalEstacionavel localEstacionavel) {
        return null;
    }

    @Override
    public LocalEstacionavel buscarLocal(String idLocal) {
        return null;
    }

    @Override
    public void atualizarLocal(LocalEstacionavel localEstacionavel) {

    }

    @Override
    public void deletarLocal(String idLocal) {

    }
}
