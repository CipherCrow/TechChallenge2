package br.com.techchallenge.flanelinha.Flanelinha.services.servicesImpl;

import br.com.techchallenge.flanelinha.Flanelinha.model.Ticket;
import br.com.techchallenge.flanelinha.Flanelinha.repository.TicketRepository;
import br.com.techchallenge.flanelinha.Flanelinha.services.TicketService;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TicketServiceImp implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    private final MongoTemplate mongoTemplate;
    private MongoClient mongo;

    public TicketServiceImp(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<Ticket> buscarTodosTickets() {
        return this.ticketRepository.findAll();
    }

    // alterar metodo para adicionar ticket transacionalmente
    @Override
    public Ticket criarTicket(Ticket ticket) {
        return this.ticketRepository.save(ticket);
    }

    @Override
    public Ticket buscarTicket(String idTicket) {
        Objects.requireNonNull(idTicket, "O código do Ticket não deve estar nulo!");
        return this.ticketRepository
                .findById(idTicket)
                .orElseThrow(() -> new IllegalArgumentException("Ticket não encontrado!"));
    }

    @Override
    public void atualizarTicket(Ticket ticket) {
        Objects.requireNonNull(ticket.getId(), "O código do Ticket não deve estar nulo!");
        this.ticketRepository.findById(ticket.getId())
                .orElseThrow(() -> new IllegalArgumentException("Ticket não encontrado!"));
        this.ticketRepository.save(ticket);

    }

    @Override
    public void deletarTicket(String idTicket) {
        Objects.requireNonNull(idTicket, "O código do Cartão não deve estar nulo!");
        Query query = new Query(Criteria.where("id").is(idTicket));
        this.mongoTemplate.remove(query, Ticket.class);
    }
}
