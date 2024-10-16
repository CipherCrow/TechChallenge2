package br.com.techchallenge.flanelinha.Flanelinha.model;

import br.com.techchallenge.flanelinha.Flanelinha.model.enums.StatusTicketEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Document
@Data
public class Ticket {
    @Id
    private String id;
    private LocalDateTime horaCriacao;
    private LocalTime tempoSolicitado;
    private LocalDateTime momentoExpiracao;
    private StatusTicketEnum status;

    @DBRef
    private Pagamento pagamento;

    @DBRef
    private Usuario usuario;

    @DBRef
    @NotNull(message = "Deve existir um veiculo relacionado!")
    private Veiculo veiculo;

    @DBRef
    @NotNull(message = "Deve existir um local relacionado!")
    private LocalEstacionavel local;
}
