package br.com.techchallenge.flanelinha.Flanelinha.controller;

import br.com.techchallenge.flanelinha.Flanelinha.model.Vaga;
import br.com.techchallenge.flanelinha.Flanelinha.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vaga")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping("/disponiveis/{localId}")
    public ResponseEntity<List<Vaga>> buscarVagasDisponiveis(@PathVariable String localId) {
        return ResponseEntity.ok(vagaService.buscarVagaPorId(localId));
    }
}
