package br.com.kleberson2santos.casadocodigov1.detalhelivro;

import br.com.kleberson2santos.casadocodigov1.cadastrolivro.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class DetalheLivroSiteController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/produtos/{id}")
    public ResponseEntity<?> detalhe(@PathVariable("id") Long id) {

        var livroBuscado = manager.find(Livro.class, id);
        // o find tá retornando nullo, defendo-me aqui
        if(livroBuscado ==  null) {
            return ResponseEntity.notFound().build();
        }

        DetalheSiteLivroResponse detalheSiteLivroResponse = new DetalheSiteLivroResponse(livroBuscado);
        return ResponseEntity.ok(detalheSiteLivroResponse);
    }
}
