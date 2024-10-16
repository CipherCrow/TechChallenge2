package br.com.techchallenge.flanelinha.Flanelinha.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Document
@Data
public class Vaga {
    @Id
    private String id;
    private String localId; // ID do LocalEstacionavel
    private boolean isOcupada;
    private boolean isVagaPrioritaria; // PCD
    private BigDecimal tarifaPorHora; // Tarifa padrão por hora
}