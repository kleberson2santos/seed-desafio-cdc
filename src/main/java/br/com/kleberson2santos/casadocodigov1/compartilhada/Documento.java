package br.com.kleberson2santos.casadocodigov1.compartilhada;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE } )
@Retention(RUNTIME)
@Constraint(validatedBy = { })
@ConstraintComposition(value = CompositionType.OR)
@ReportAsSingleViolation
@CPF
@CNPJ
public @interface Documento {

    String message() default "{br.com.kleberson2santos.compartilhada.documento}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
