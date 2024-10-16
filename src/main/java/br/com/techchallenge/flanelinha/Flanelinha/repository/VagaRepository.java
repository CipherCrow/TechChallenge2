package br.com.techchallenge.flanelinha.Flanelinha.repository;

import br.com.techchallenge.flanelinha.Flanelinha.model.Vaga;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface VagaRepository extends MongoRepository<Vaga, String> {
    List<Vaga> findByLocalIdAndIsOcupada(String localId, boolean isOcupada);
}
