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

    @NotBlank(message = "O numero não deve estar em branco!")
    private String numero;
    @NotBlank(message = "A bandeira do cartão não pode estar em branco!")
    private TipoBandeirasCartaoEnum bandeira;
    private LocalDateTime dataCadastro;
    @NotBlank(message = "A data de vencimento não pode estar em branco!")
    private LocalDateTime dataVencimento;
    @NotBlank(message = "O codigo de segurança não deve estar em branco!")
    private String codigoDeSeguranca;

    @NotBlank(message = "Deve existir um titular!")
    @DBRef
    private Usuario titular;
}
