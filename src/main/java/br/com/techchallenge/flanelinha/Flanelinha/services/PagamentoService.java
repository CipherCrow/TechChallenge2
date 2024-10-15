package br.com.techchallenge.flanelinha.Flanelinha.services;

import br.com.techchallenge.flanelinha.Flanelinha.model.Pagamento;

import java.util.List;

public interface PagamentoService {
    public List<Pagamento> buscarTodosPagamentos();
    public Pagamento criarPagamento(Pagamento pagamento);
    public Pagamento buscarPagamento(String idPagamento);
    public void atualizarPagamento(Pagamento pagamento);
    public void deletarPagamento(String idPagamento);

}
