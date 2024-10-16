package br.com.techchallenge.flanelinha.Flanelinha.controller;

import br.com.techchallenge.flanelinha.Flanelinha.model.Estadia;
import br.com.techchallenge.flanelinha.Flanelinha.services.EstadiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

    @RestController
    @RequestMapping("/estadia")
    public class EstadiaController {

        @Autowired
        private EstadiaService estadiaService;

        @PostMapping("/iniciar")
        public ResponseEntity<Estadia> iniciarEstadia(@RequestParam String usuarioId, @RequestParam String vagaId, @RequestParam int horasEstadia) {
            return ResponseEntity.ok(estadiaService.iniciarEstadia(usuarioId, vagaId, horasEstadia));
        }

        @PostMapping("/finalizar/{id}")
        public ResponseEntity<String> finalizarEstadia(@PathVariable String id) {
            estadiaService.finalizarEstadia(id);
            return ResponseEntity.ok("Estadia finalizada e vaga liberada");
        }
    }


