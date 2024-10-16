package br.com.techchallenge.flanelinha.Flanelinha.repository;
import br.com.techchallenge.flanelinha.Flanelinha.model.Estadia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstadiaRepository extends MongoRepository<Estadia, String> {
}
