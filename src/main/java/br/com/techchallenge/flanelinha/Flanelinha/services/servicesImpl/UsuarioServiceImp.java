package br.com.techchallenge.flanelinha.Flanelinha.services.servicesImpl;

import br.com.techchallenge.flanelinha.Flanelinha.model.Usuario;
import br.com.techchallenge.flanelinha.Flanelinha.repository.UsuarioRepository;
import br.com.techchallenge.flanelinha.Flanelinha.services.UsuarioService;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final MongoTemplate mongoTemplate;
    private MongoClient mongo;

    public UsuarioServiceImp(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Usuario> buscarTodosUsuarios() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarUsuario(String idUsuario) {
        Objects.requireNonNull(idUsuario, "O código do usuário não deve estar nulo!");
        return this.usuarioRepository
                .findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado!"));
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {
        Objects.requireNonNull(usuario.getId(), "O código do usuário não deve estar nulo!");
        this.usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado!"));
        this.usuarioRepository.save(usuario);
    }

    @Override
    public void deletarUsuario(String idUsuario) {
        Objects.requireNonNull(idUsuario, "O código do usuário não deve estar nulo!");
        Query query = new Query(Criteria.where("codigo").is(idUsuario));
        this.mongoTemplate.remove(query, Usuario.class);
        usuarioRepository.deleteById(idUsuario);
    }
}
