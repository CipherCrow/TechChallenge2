package br.com.techchallenge.flanelinha.Flanelinha.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Ticket {
    @Id
    private String id;
    private LocalDateTime horaCriacao;
    private LocalDateTime tempoSolicitado;
    private LocalDateTime momentoExpiracao;

    @DBRef
    private Pagamento pagamento;

    @DBRef
    private Usuario usuario;

    @DBRef
    private Veiculo veiculo;

    @DBRef
    private LocalEstacionavel local;
}
