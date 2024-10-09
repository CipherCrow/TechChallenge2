package br.com.techchallenge.flanelinha.Flanelinha.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Usuario {
    @Id
    private String id;

    private String nome;
    private String cpf;
    private String email;
    private String idade;
    private String dataNascimento;
    private String sexo;
    private String celular;
    private String rgPcd;

    @DBRef
    private List<Veiculo> veiculos;

    @DBRef
    private List<Cartao> cartoes;

    @DBRef
    private List<Ticket> historico;

}
