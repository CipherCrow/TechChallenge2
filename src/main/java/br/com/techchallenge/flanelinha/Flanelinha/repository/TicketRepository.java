package br.com.techchallenge.flanelinha.Flanelinha.repository;


import br.com.techchallenge.flanelinha.Flanelinha.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {
}
