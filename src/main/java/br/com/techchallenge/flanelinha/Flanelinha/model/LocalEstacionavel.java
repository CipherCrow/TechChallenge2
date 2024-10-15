package br.com.techchallenge.flanelinha.Flanelinha.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class LocalEstacionavel {
    @Id
    private String id;

    @NotBlank(message = "Deve existir um bairro para o local!")
    private String bairro;
    @NotBlank(message = "Deve existir uma rua para o local!")
    private String rua;
    private String descricaoEspecial;
    @NotBlank(message = "Deve existir uma numeraçao para o local!")
    private String numeracao;
    private boolean isVagaPrioritaria; // PCD e/ou Idoso
}
