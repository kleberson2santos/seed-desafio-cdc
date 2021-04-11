package br.com.kleberson2santos.casadocodigov1.fechamentocompra;

import br.com.kleberson2santos.casadocodigov1.paisestado.Estado;
import br.com.kleberson2santos.casadocodigov1.paisestado.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class EstadoObrigatorioValidator implements Validator {

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

        if(request.temPais()) {
            if(request.naoTemEstado()) {
                List<Estado> estados = manager
                        .createQuery("select e from Estado e where pais.id = :id", Estado.class)
                        .setMaxResults(1)
                        .setParameter("id", request.getIdPais())
                        .getResultList();
                if (!estados.isEmpty()) {
                    errors.rejectValue("idEstado", null, "o estado deste país é obrigatório");
                }
            }
        }
    }
}












