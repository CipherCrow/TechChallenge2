package br.com.techchallenge.flanelinha.Flanelinha.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Veiculo {
    @Id
    private String id;

    private String placa;
    private String modelo;
    private String cor;
    private int ano;
    private String marca;
    private String renavam;

    @DBRef
    private Usuario dono;
}
