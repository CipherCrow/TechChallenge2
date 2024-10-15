package br.com.techchallenge.flanelinha.Flanelinha.services;

import br.com.techchallenge.flanelinha.Flanelinha.model.LocalEstacionavel;

import java.util.List;

public interface LocalEstacionavelService {
    public List<LocalEstacionavel> buscarTodosLocais();
    public LocalEstacionavel criarLocal(LocalEstacionavel usuario);
    public LocalEstacionavel buscarLocal(String idLocal);
    public void atualizarLocal(LocalEstacionavel localEstacionavel);
    public void deletarLocal(String idLocal);
}
