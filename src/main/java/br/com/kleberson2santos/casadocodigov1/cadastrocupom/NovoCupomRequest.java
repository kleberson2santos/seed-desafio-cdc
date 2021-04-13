package br.com.kleberson2santos.casadocodigov1.cadastrocupom;

import br.com.kleberson2santos.casadocodigov1.compartilhada.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

public class NovoCupomRequest {

    @NotBlank
    @UniqueValue(domainClass = Cupom.class, fieldName = "codigo")
    private String codigo;

    @Positive
    @NotNull
    private BigDecimal percentualDesconto;

    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = STRING)
    private LocalDate validade;

    public NovoCupomRequest(@NotBlank String codigo,
                            @Positive @NonNull BigDecimal percentualDesconto) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
    }

    // não conseguir fazer pelo construtor
    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public Cupom toModel(){
        return new Cupom(codigo, percentualDesconto, validade);
    }
}
