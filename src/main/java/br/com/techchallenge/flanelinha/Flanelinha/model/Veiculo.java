package br.com.techchallenge.flanelinha.Flanelinha.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Veiculo {
    @Id
    private String id;

    @NotBlank(message = "A placa não deve estar em branco!")
    private String placa;
    private String modelo;
    private String cor;
    private int ano;
    private String marca;
    private String renavam;

    @DBRef
    private Usuario dono;
}
