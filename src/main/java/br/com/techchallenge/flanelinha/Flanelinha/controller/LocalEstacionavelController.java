package br.com.techchallenge.flanelinha.Flanelinha.controller;

import br.com.techchallenge.flanelinha.Flanelinha.model.LocalEstacionavel;
import br.com.techchallenge.flanelinha.Flanelinha.services.LocalEstacionavelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/local")
public class LocalEstacionavelController {


    @Autowired
    private LocalEstacionavelService localEstacionavelService;

    @GetMapping("/buscarTodos")
    public ResponseEntity<Object> buscarTodosLocais() {
        try {
            List<LocalEstacionavel> local = localEstacionavelService.buscarTodosLocais();
            if (local.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(local);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Não foi possível buscar todos os Locais: " + e.getMessage());
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<Object> criarLocal(@Valid @RequestBody LocalEstacionavel localBody) {
        try {
            LocalEstacionavel local = localEstacionavelService.criarLocal(localBody);
            return ResponseEntity.status(HttpStatus.CREATED).body(local);
            //} catch (MethodArgumentNotValidException ex) {
            //    return ResponseEntity.badRequest().body("Validações necessárias: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar Local: " + e.getMessage());
        }
    }

    @GetMapping("/buscar/{codigo}")
    public ResponseEntity<Object> buscarLocal(@PathVariable  String codigo) {
        try {
            LocalEstacionavel local = localEstacionavelService.buscarLocal(codigo);
            return ResponseEntity.ok(local);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Validação: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar Local: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Object> atualizarLocal(@RequestBody LocalEstacionavel local) {
        try {
            localEstacionavelService.atualizarLocal(local);
            return ResponseEntity.ok("Local atualizado com sucesso");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar Local: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<Object> deletarLocal(@PathVariable String codigo) {
        try {
            localEstacionavelService.deletarLocal(codigo);
            return ResponseEntity.ok("Local deletado com sucesso");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar local: " + e.getMessage());
        }
    }




}
