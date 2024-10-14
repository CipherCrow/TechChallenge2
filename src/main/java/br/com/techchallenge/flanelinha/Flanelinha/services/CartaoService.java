package br.com.techchallenge.flanelinha.Flanelinha.services;

import br.com.techchallenge.flanelinha.Flanelinha.model.Cartao;
import java.util.List;

public interface CartaoService {
    public List<Cartao> buscarTodosCartoes();
    public Cartao criarCartao(Cartao cartao);
    public Cartao buscarCartao(String idCartao);
    public void atualizarCartao(Cartao cartao);
    public void deletarCartao(String idCartao);
}
