package br.com.kleberson2santos.casadocodigov1.fechamentocompra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class FechaCompraParte1Controller {

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;
    @Autowired
    private EstadoObrigatorioValidator estadoObrigatorioValidator;
    @PersistenceContext
    private EntityManager manager;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoPertenceAPaisValidator, estadoObrigatorioValidator);
    }

    @PostMapping("/compras")
    @Transactional
    public String cria(@RequestBody @Valid NovaCompraRequest request) {
        Compra novaCompra = request.toModel(manager);
        manager.persist(novaCompra);
        return novaCompra.toString();
    }
}
