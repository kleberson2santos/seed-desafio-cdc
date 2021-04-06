package br.com.kleberson2santos.casadocodigov1.paisestado;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class CriaEstadoController {
    @PersistenceContext
    EntityManager manager;

    @PostMapping("/estados")
    @Transactional
    public String cria(@RequestBody @Valid NovoEstadoResquest request) {
        Estado novoEstado = request.toModel(manager);
        manager.persist(novoEstado);
        return novoEstado.toString();
    }
}
