package br.com.techchallenge.flanelinha.Flanelinha.services.servicesImpl;

import br.com.techchallenge.flanelinha.Flanelinha.model.Ticket;
import br.com.techchallenge.flanelinha.Flanelinha.repository.TicketRepository;
import br.com.techchallenge.flanelinha.Flanelinha.services.TicketService;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class TicketServiceImp implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    private final MongoTemplate mongoTemplate;
    private MongoClient mongo;

    public TicketServiceImp(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<Ticket> buscarTodosTikets() {
        return List.of();
    }

    @Override
    public Ticket criarTicket(Ticket ticket) {
        return null;
    }

    @Override
    public Ticket buscarTicket(String idTicket) {
        return null;
    }

    @Override
    public void atualizarTicket(Ticket ticket) {

    }

    @Override
    public void deletarTicket(String idTicket) {

    }
}
