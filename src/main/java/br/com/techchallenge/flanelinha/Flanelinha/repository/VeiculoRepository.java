package br.com.techchallenge.flanelinha.Flanelinha.repository;

import br.com.techchallenge.flanelinha.Flanelinha.model.Veiculo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends MongoRepository<Veiculo, String> {
}
