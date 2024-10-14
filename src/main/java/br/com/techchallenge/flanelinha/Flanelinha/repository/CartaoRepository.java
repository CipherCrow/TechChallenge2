package br.com.techchallenge.flanelinha.Flanelinha.repository;

import br.com.techchallenge.flanelinha.Flanelinha.model.Cartao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends MongoRepository<Cartao, String> {
}
