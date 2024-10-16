package br.com.techchallenge.flanelinha.Flanelinha.model;

import br.com.techchallenge.flanelinha.Flanelinha.model.enums.TipoBandeirasCartaoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Cartao {
    @Id
    private String id;

    @NotNull(message = "O numero não deve estar em branco!")
    private String numero;
    @NotNull(message = "A bandeira do cartão não pode estar em branco!")
    private TipoBandeirasCartaoEnum bandeira;
    private LocalDateTime dataCadastro;
    @NotNull(message = "A data de vencimento não pode estar em branco!")
    private LocalDateTime dataVencimento;
    @NotNull(message = "O codigo de segurança não deve estar em branco!")
    private String codigoDeSeguranca;
    
    @DBRef
    private Usuario titular;
}
