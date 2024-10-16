package br.com.techchallenge.flanelinha.Flanelinha.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class LocalEstacionavel {
    @Id
    private String id;

    @NotNull(message = "Deve existir um bairro para o local!")
    private String bairro;
    @NotNull(message = "Deve existir uma rua para o local!")
    private String rua;
    private String descricaoEspecial;
    @NotNull(message = "Deve existir uma numeraçao para o local!")
    private String numeracao;
    private boolean isVagaPrioritaria; // PCD e/ou Idoso
}
