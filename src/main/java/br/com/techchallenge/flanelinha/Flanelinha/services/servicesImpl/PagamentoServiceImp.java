package br.com.techchallenge.flanelinha.Flanelinha.services.servicesImpl;

import br.com.techchallenge.flanelinha.Flanelinha.model.Pagamento;
import br.com.techchallenge.flanelinha.Flanelinha.repository.PagamentoRepository;
import br.com.techchallenge.flanelinha.Flanelinha.services.PagamentoService;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PagamentoServiceImp implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    private final MongoTemplate mongoTemplate;
    private MongoClient mongo;

    public PagamentoServiceImp(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Pagamento> buscarTodosPagamentos() {
        return this.pagamentoRepository.findAll();
    }

    @Override
    public Pagamento criarPagamento(Pagamento pagamento) {
        return this.pagamentoRepository.save(pagamento);
    }

    @Override
    public Pagamento buscarPagamento(String idPagamento) {
        Objects.requireNonNull(idPagamento, "O código do Pagamento não deve estar nulo!");
        return this.pagamentoRepository
                .findById(idPagamento)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado!"));
    }

    @Override
    public void atualizarPagamento(Pagamento pagamento) {
        Objects.requireNonNull(pagamento.getId(), "O código do Pagamento não deve estar nulo!");
        this.pagamentoRepository.findById(pagamento.getId())
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado!"));
        this.pagamentoRepository.save(pagamento);
    }

    @Override
    public void deletarPagamento(String idPagamento) {
        Objects.requireNonNull(idPagamento, "O código do Pagamento não deve estar nulo!");
        Query query = new Query(Criteria.where("id").is(idPagamento));
        this.mongoTemplate.remove(query, Pagamento.class);
    }
}
