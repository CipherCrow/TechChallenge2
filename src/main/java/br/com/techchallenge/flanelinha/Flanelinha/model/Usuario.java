package br.com.techchallenge.flanelinha.Flanelinha.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@Data
public class Usuario {
    @Id
    private String id;

    @NotNull(message = "O nome não deve estar em branco!")
    private String nome;
    @NotNull(message = "Apenas cadastros com CPF são suportados!")
    private String cpf;
    @NotNull(message = "É necessário inserir o email para cadastro!")
    private String email;
    private int idade;
    @NotNull(message = "Deve ser inserido uma data de nascimento!")
    private LocalDate dataNascimento;
    private String sexo;
    @NotNull(message = "É necessário inserir o numero de celular para cadastro!")
    private String numeroCelular;
    private String rgPcd;

    @DBRef
    private List<Veiculo> veiculos;

    @DBRef
    private List<Cartao> cartoes;

    @DBRef
    private List<Ticket> historico;

}
