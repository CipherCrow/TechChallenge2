package br.com.techchallenge.flanelinha.Flanelinha.services;

import br.com.techchallenge.flanelinha.Flanelinha.model.Pagamento;
import br.com.techchallenge.flanelinha.Flanelinha.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PagamentoService {
    public List<Pagamento> buscarTodosPagamentos();
    public Pagamento criarPagamento(Pagamento pagamento);
    public Pagamento buscarPagamento(String idPagamento);
    public void atualizarPagamento(Pagamento pagamento);
    public void deletarPagamento(String idPagamento);

}
