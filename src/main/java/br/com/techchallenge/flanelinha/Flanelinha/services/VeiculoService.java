package br.com.techchallenge.flanelinha.Flanelinha.services;

import br.com.techchallenge.flanelinha.Flanelinha.model.Veiculo;

import java.util.List;

public interface VeiculoService {
    public List<Veiculo> buscarTodosVeiculos();
    public Veiculo criarVeiculo(Veiculo veiculo);
    public Veiculo buscarVeiculo(String idVeiculo);
    public void atualizarVeiculo(Veiculo veiculo);
    public void deletarVeiculo(String idVeiculo);
}
