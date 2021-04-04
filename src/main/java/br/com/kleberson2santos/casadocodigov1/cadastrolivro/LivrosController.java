package br.com.kleberson2santos.casadocodigov1.cadastrolivro;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/livros")
@RestController
public class LivrosController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String cria(@RequestBody @Valid NovoLivroRequest request) {
        Livro novoLivro = request.toModel(manager);
        manager.persist(novoLivro);
        return novoLivro.toString();
    }

    @GetMapping
    public List lista() {
        //TODO: criar um Response
        return manager.createQuery("from Livro").getResultList();
    }
}
