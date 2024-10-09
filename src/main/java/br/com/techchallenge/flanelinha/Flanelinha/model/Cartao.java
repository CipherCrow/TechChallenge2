package br.com.techchallenge.flanelinha.Flanelinha.model;

import br.com.techchallenge.flanelinha.Flanelinha.model.enums.TipoBandeirasCartaoEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Cartao {
    @Id
    private int id;

    private String numero;
    private TipoBandeirasCartaoEnum bandeira;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataVencimento;
    private String codigoDeSeguranca;

    @DBRef
    private Usuario titular;
}
