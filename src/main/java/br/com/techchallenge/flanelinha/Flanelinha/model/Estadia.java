package br.com.techchallenge.flanelinha.Flanelinha.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
@Data
public class Estadia {
    @Id
    private String id;
    private String usuarioId;
    private String vagaId;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private BigDecimal tarifaTotal;
}