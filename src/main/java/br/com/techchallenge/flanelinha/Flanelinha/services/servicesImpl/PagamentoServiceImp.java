package br.com.techchallenge.flanelinha.Flanelinha.services.servicesImpl;

import br.com.techchallenge.flanelinha.Flanelinha.model.Pagamento;
import br.com.techchallenge.flanelinha.Flanelinha.repository.PagamentoRepository;
import br.com.techchallenge.flanelinha.Flanelinha.services.PagamentoService;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class PagamentoServiceImp implements PagamentoService {

    @Autowired
    private PagamentoRepository PagamentoRepository;

    private final MongoTemplate mongoTemplate;
    private MongoClient mongo;

    public PagamentoServiceImp(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }



    @Override
    public List<Pagamento> buscarTodosPagamentos() {
        return List.of();
    }

    @Override
    public Pagamento criarPagamento(Pagamento pagamento) {
        return null;
    }

    @Override
    public Pagamento buscarPagamento(String idPagamento) {
        return null;
    }

    @Override
    public void atualizarPagamento(Pagamento pagamento) {

    }

    @Override
    public void deletarPagamento(String idPagamento) {

    }
}
