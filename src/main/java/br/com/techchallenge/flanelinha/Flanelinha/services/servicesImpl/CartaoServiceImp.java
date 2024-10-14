package br.com.techchallenge.flanelinha.Flanelinha.services.servicesImpl;

import br.com.techchallenge.flanelinha.Flanelinha.model.Cartao;
import br.com.techchallenge.flanelinha.Flanelinha.repository.CartaoRepository;
import br.com.techchallenge.flanelinha.Flanelinha.services.CartaoService;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CartaoServiceImp implements CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    private final MongoTemplate mongoTemplate;
    private MongoClient mongo;

    public CartaoServiceImp(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Cartao> buscarTodosCartoes() {
        return this.cartaoRepository.findAll();
    }

    @Override
    public Cartao criarCartao(Cartao cartao) {
        return this.cartaoRepository.save(cartao);
    }

    @Override
    public Cartao buscarCartao(String idCartao) {
        Objects.requireNonNull(idCartao, "O código do Cartão não deve estar nulo!");
        return this.cartaoRepository
                .findById(idCartao)
                .orElseThrow(() -> new IllegalArgumentException("Cartão não encontrado!"));
    }

    @Override
    public void atualizarCartao(Cartao cartao) {
        Objects.requireNonNull(cartao.getId(), "O código do Cartão não deve estar nulo!");
        this.cartaoRepository.findById(cartao.getId())
                .orElseThrow(() -> new IllegalArgumentException("Cartão não encontrado!"));
        this.cartaoRepository.save(cartao);
    }

    @Override
    public void deletarCartao(String idCartao) {
        Objects.requireNonNull(idCartao, "O código do Cartão não deve estar nulo!");
        Query query = new Query(Criteria.where("codigo").is(idCartao));
        this.mongoTemplate.remove(query, Cartao.class);
    }
}
