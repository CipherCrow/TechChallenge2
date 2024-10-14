package br.com.techchallenge.flanelinha.Flanelinha.controller;

import br.com.techchallenge.flanelinha.Flanelinha.model.Usuario;
import br.com.techchallenge.flanelinha.Flanelinha.model.Veiculo;
import br.com.techchallenge.flanelinha.Flanelinha.services.UsuarioService;
import br.com.techchallenge.flanelinha.Flanelinha.services.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/buscarTodos")
    public ResponseEntity<Object> buscarTodosVeiculos() {
        try {
            List<Veiculo> veiculos = veiculoService.buscarTodosVeiculos();
            if (veiculos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(veiculos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Não foi possível buscar todos os veiculos: " + e.getMessage());
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<Object> criarVeiculo(@Valid @RequestBody Veiculo veiculoBody) {
        try {
            Veiculo veiculo = veiculoService.criarVeiculo(veiculoBody);
            return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
        //} catch (MethodArgumentNotValidException ex) {
        //    return ResponseEntity.badRequest().body("Validações necessárias: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar veiculo: " + e.getMessage());
        }
    }

    @GetMapping("/buscar/{codigo}")
    public ResponseEntity<Object> buscarVeiculo(@PathVariable  String codigo) {
        try {
            Veiculo veiculo = veiculoService.buscarVeiculo(codigo);
            return ResponseEntity.ok(veiculo);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Validação: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar veiculo: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Object> atualizarVeiculo(@RequestBody Veiculo veiculo) {
        try {
            veiculoService.atualizarVeiculo(veiculo);
            return ResponseEntity.ok("Veiculo atualizado com sucesso");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar veiculo: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<Object> deletarVeiculo(@PathVariable String codigo) {
        try {
            veiculoService.deletarVeiculo(codigo);
            return ResponseEntity.ok("Veiculo deletado com sucesso");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar usuário: " + e.getMessage());
        }
    }

}
