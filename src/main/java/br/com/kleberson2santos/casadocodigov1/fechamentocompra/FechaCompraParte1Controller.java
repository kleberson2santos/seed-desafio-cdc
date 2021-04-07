package br.com.kleberson2santos.casadocodigov1.fechamentocompra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class FechaCompraParte1Controller {

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoPertenceAPaisValidator);
    }

    @PostMapping("/compras")
    public String cria(@RequestBody @Valid NovaCompraRequest request) {
        return request.toString();
    }
}
