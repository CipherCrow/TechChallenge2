package br.com.techchallenge.flanelinha.Flanelinha.repository;

import br.com.techchallenge.flanelinha.Flanelinha.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
