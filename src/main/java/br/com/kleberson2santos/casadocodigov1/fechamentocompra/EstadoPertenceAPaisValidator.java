package br.com.kleberson2santos.casadocodigov1.fechamentocompra;

import br.com.kleberson2santos.casadocodigov1.paisestado.Estado;
import br.com.kleberson2santos.casadocodigov1.paisestado.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        NovaCompraRequest request = (NovaCompraRequest) o;

        Pais pais = manager.find(Pais.class, request.getIdPais());
        Estado estado = manager.find(Estado.class, request.getIdEstado());

        if(!estado.pertenceAPais(pais)){
            errors.rejectValue("idEstado", null, "este estado não é o do país selecionado");
        }
    }
}












