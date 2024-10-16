package br.com.techchallenge.flanelinha.Flanelinha.model;

import br.com.techchallenge.flanelinha.Flanelinha.model.enums.TipoPagamentoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Pagamento {
    @Id
    private String id;

    private TipoPagamentoEnum formaPagamento;
    @NotNull(message = "Deve existir um valor total para o pagamento!")
    private Double valorTotal;
}
