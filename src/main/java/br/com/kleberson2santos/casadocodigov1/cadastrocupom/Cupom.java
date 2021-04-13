package br.com.kleberson2santos.casadocodigov1.cadastrocupom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String codigo;
    @Positive
    @NotNull
    private BigDecimal percentualDesconto;
    @Future
    @NotNull
    private LocalDate validade;

    @Deprecated
    public Cupom() {
    }

    public Cupom(@NotBlank String codigo, @Positive @NotNull BigDecimal percentualDesconto,
                 @FutureOrPresent @NotNull LocalDate validade) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", percentualDesconto=" + percentualDesconto +
                ", validade=" + validade +
                '}';
    }

}
