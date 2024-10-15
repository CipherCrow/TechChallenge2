package br.com.techchallenge.flanelinha.Flanelinha.services;

import br.com.techchallenge.flanelinha.Flanelinha.model.Ticket;

import java.util.List;

public interface TicketService {
    public List<Ticket> buscarTodosTickets();
    public Ticket criarTicket   (Ticket ticket);
    public Ticket buscarTicket(String idTicket);
    public void atualizarTicket(Ticket ticket);
    public void deletarTicket(String idTicket);

}
