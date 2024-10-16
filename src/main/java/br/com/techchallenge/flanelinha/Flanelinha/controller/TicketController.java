package br.com.techchallenge.flanelinha.Flanelinha.controller;

import br.com.techchallenge.flanelinha.Flanelinha.model.Ticket;
import br.com.techchallenge.flanelinha.Flanelinha.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {


    @Autowired
    private TicketService ticketService;

    @GetMapping("/buscarTodos")
    public ResponseEntity<Object> buscarTodosTikets() {
        try {
            List<Ticket> ticket = ticketService.buscarTodosTickets();
            if (ticket.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(ticket);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Não foi possível buscar todos os Tickets: " + e.getMessage());
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<Object> criarTicket(@Valid @RequestBody Ticket ticketBody) {
        try {
            Ticket ticket = ticketService.criarTicket(ticketBody);
            return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
            //} catch (MethodArgumentNotValidException ex) {
            //    return ResponseEntity.badRequest().body("Validações necessárias: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar ticket: " + e.getMessage());
        }
    }

    @GetMapping("/buscar/{codigo}")
    public ResponseEntity<Object> buscarTicket(@PathVariable  String codigo) {
        try {
            Ticket ticket = ticketService.buscarTicket(codigo);
            return ResponseEntity.ok(ticket);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Validação: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar ticket: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Object> atualizarTicket(@RequestBody Ticket ticket) {
        try {
            ticketService.atualizarTicket(ticket);
            return ResponseEntity.ok("Ticket atualizado com sucesso");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar ticket: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<Object> deletarTicket(@PathVariable String codigo) {
        try {
            ticketService.deletarTicket(codigo);
            return ResponseEntity.ok("Ticket deletado com sucesso");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar ticket: " + e.getMessage());
        }
    }

}
