package br.com.kleberson2santos.casadocodigov1.paisestado;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;


@RestController
public class CadastroPaisController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping("/paises")
    @Transactional
    public ResponseEntity<?> cria(@RequestBody @Valid NovoPaisRequest request, UriComponentsBuilder builder) {

        Pais novoPais = request.toModel(manager);
        manager.persist(novoPais);
        return ResponseEntity.created(URI.create(builder.toUriString())).body(novoPais);
    }

}
