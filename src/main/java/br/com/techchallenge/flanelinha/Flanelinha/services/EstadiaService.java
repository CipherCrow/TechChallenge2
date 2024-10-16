package br.com.techchallenge.flanelinha.Flanelinha.services;

import br.com.techchallenge.flanelinha.Flanelinha.model.Estadia;

public interface EstadiaService {

    public Estadia iniciarEstadia(String usuarioId, String vagaId, int horasEstadia);
    public void finalizarEstadia(String estadiaId);
}
