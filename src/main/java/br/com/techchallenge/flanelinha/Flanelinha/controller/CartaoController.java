package br.com.techchallenge.flanelinha.Flanelinha.controller;

import br.com.techchallenge.flanelinha.Flanelinha.model.Cartao;
import br.com.techchallenge.flanelinha.Flanelinha.model.Usuario;
import br.com.techchallenge.flanelinha.Flanelinha.services.CartaoService;
import br.com.techchallenge.flanelinha.Flanelinha.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cartao")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @GetMapping("/buscarTodos")
    public ResponseEntity<Object> buscarTodosCartoes() {
        try {
            List<Cartao> cartoes = cartaoService.buscarTodosCartoes();
            if (cartoes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(cartoes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Não foi possível buscar todos os cartões de crédito: " + e.getMessage());
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<Object> criarCartao(@Valid @RequestBody Cartao cartaoBody) {
        try {
            Cartao cartao = cartaoService.criarCartao(cartaoBody);
            return ResponseEntity.status(HttpStatus.CREATED).body(cartao);
        //} catch (MethodArgumentNotValidException ex) {
        //    return ResponseEntity.badRequest().body("Validações necessárias: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar cartão: " + e.getMessage());
        }
    }

    @GetMapping("/buscar/{codigo}")
    public ResponseEntity<Object> buscarCartao(@PathVariable  String codigo) {
        try {
            Cartao cartao = cartaoService.buscarCartao(codigo);
            return ResponseEntity.ok(cartao);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Validação: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar cartão: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Object> atualizarCartao(@RequestBody Cartao cartao) {
        try {
            cartaoService.atualizarCartao(cartao);
            return ResponseEntity.ok("Cartão atualizado com sucesso");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar Cartão: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<Object> deletarCartao(@PathVariable String codigo) {
        try {
            cartaoService.deletarCartao(codigo);
            return ResponseEntity.ok("Usuário deletado com sucesso");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar cartão: " + e.getMessage());
        }
    }

}
