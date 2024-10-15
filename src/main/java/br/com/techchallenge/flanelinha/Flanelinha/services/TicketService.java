package br.com.techchallenge.flanelinha.Flanelinha.services;

import br.com.techchallenge.flanelinha.Flanelinha.model.Pagamento;
import br.com.techchallenge.flanelinha.Flanelinha.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TicketService {
    public List<Ticket> buscarTodosTikets();
    public Ticket criarTicket   (Ticket ticket);
    public Ticket buscarTicket(String idTicket);
    public void atualizarTicket(Ticket ticket);
    public void deletarTicket(String idTicket);

}
