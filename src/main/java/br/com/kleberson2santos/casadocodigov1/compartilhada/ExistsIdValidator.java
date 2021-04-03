package br.com.kleberson2santos.casadocodigov1.compartilhada;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {
    private String entityId;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistsId constraintAnnotation) {
        entityId = constraintAnnotation.fieldId();
        klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        List<?> list = manager.createQuery("select 1 from " + klass.getName() + " where " + entityId + "=:value")
                .setParameter("value", value).getResultList();
        Assert.state(list.size() <=1, "aconteceu algo bizarro e você tem mais de um " + klass + " com o id " + entityId + " com o valor " + value);

        return !list.isEmpty();
    }
}
