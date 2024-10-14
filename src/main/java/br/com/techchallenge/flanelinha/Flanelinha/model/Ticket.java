package br.com.techchallenge.flanelinha.Flanelinha.model;

import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Deve existir dados de pagamento!")
    private Pagamento pagamento;

    @DBRef
    @NotNull(message = "Deve existir um usuário relacionado!")
    private Usuario usuario;

    @DBRef
    @NotNull(message = "Deve existir um veiculo relacionado!")
    private Veiculo veiculo;

    @DBRef
    @NotNull(message = "Deve existir um local relacionado!")
    private LocalEstacionavel local;
}
