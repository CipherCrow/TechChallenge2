package br.com.techchallenge.flanelinha.Flanelinha.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class LocalEstacionavel {
    @Id
    private String id;

    private String bairro;
    private String rua;
    private String descricaoEspecial;
    private String numeracao;
    private boolean isVagaPcd;
    private boolean isVagaIdoso;
}
