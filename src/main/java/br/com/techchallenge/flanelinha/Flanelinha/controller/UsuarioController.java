package br.com.techchallenge.flanelinha.Flanelinha.controller;

import br.com.techchallenge.flanelinha.Flanelinha.model.Usuario;
import br.com.techchallenge.flanelinha.Flanelinha.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/buscarTodos")
    public ResponseEntity<Object> buscarTodosUsuarios() {
        try {
            List<Usuario> usuarios = usuarioService.buscarTodosUsuarios();
            if (usuarios.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Não foi possível buscar todos os usuários: " + e.getMessage());
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<Object> criarUsuario(@Valid @RequestBody Usuario usuarioBody) {
        try {
            Usuario usuario = usuarioService.criarUsuario(usuarioBody);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        //} catch (MethodArgumentNotValidException ex) {
        //    return ResponseEntity.badRequest().body("Validações necessárias: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar usuário: " + e.getMessage());
        }
    }

    @GetMapping("/buscar/{codigo}")
    public ResponseEntity<Object> buscarUsuario(@PathVariable  String codigo) {
        try {
            Usuario usuario = usuarioService.buscarUsuario(codigo);
            return ResponseEntity.ok(usuario);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Validação: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar usuário: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Object> atualizarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.atualizarUsuario(usuario);
            return ResponseEntity.ok("Usuário atualizado com sucesso");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable String codUsuario) {
        try {
            usuarioService.deletarUsuario(codUsuario);
            return ResponseEntity.ok("Usuário deletado com sucesso");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar usuário: " + e.getMessage());
        }
    }

}
