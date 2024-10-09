package br.com.techchallenge.flanelinha.Flanelinha.model;

import br.com.techchallenge.flanelinha.Flanelinha.model.enums.TipoPagamentoEnum;
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
    private Double valorTotal;

    @DBRef
    private Cartao cartao;
}
