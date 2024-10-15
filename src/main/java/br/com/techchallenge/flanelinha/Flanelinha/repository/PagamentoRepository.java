package br.com.techchallenge.flanelinha.Flanelinha.repository;

import br.com.techchallenge.flanelinha.Flanelinha.model.Pagamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends MongoRepository<Pagamento, String> {
}
