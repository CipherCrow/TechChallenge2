package br.com.techchallenge.flanelinha.Flanelinha.controller;

import br.com.techchallenge.flanelinha.Flanelinha.model.Pagamento;
import br.com.techchallenge.flanelinha.Flanelinha.services.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/buscarTodos")
    public ResponseEntity<Object> buscarTodosPagamentos() {
        try {
            List<Pagamento> pagamento = pagamentoService.buscarTodosPagamentos();
            if (pagamento.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(pagamento);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Não foi possível buscar todos os Pagamentos: " + e.getMessage());
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<Object> criarLocal(@Valid @RequestBody Pagamento pagamentoBody) {
        try {
            Pagamento pagamento = pagamentoService.criarPagamento(pagamentoBody);
            return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
            //} catch (MethodArgumentNotValidException ex) {
            //    return ResponseEntity.badRequest().body("Validações necessárias: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar Pagamento: " + e.getMessage());
        }
    }

    @GetMapping("/buscar/{codigo}")
    public ResponseEntity<Object> buscarPagamento(@PathVariable  String codigo) {
        try {
            Pagamento pagamento = pagamentoService.buscarPagamento(codigo);
            return ResponseEntity.ok(pagamento);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Validação: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar Pagamento: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Object> atualizarPagamento(@RequestBody Pagamento pagamento) {
        try {
            pagamentoService.atualizarPagamento(pagamento);
            return ResponseEntity.ok("Pagamento atualizado com sucesso");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar Pagamento: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<Object> deletarPagamento(@PathVariable String codigo) {
        try {
            pagamentoService.deletarPagamento(codigo);
            return ResponseEntity.ok("Pagamento deletado com sucesso");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar pagamento: " + e.getMessage());
        }
    }

}
