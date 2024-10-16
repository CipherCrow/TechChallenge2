package br.com.techchallenge.flanelinha.Flanelinha.services;

import br.com.techchallenge.flanelinha.Flanelinha.model.Vaga;

import java.util.List;

public interface VagaService {


    void liberarVaga(String vagaId);

    void ocuparVaga(String vagaId);

    List<Vaga> buscarVagaPorId(String vagaId);

    public Vaga criarVaga(Vaga vaga);


}
