package br.com.kleberson2santos.casadocodigov1.fechamentocompra;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NovoPedidoRequest {

    @Positive
    @NotNull
    private BigDecimal total;
    @Size(min = 1)
    @Valid
    private List<NovoPedidoItemRequest> itens = new ArrayList<>();

    public NovoPedidoRequest(@Positive @NotNull BigDecimal total,
                             @Size(min = 1) @Valid List<NovoPedidoItemRequest> itens) {
        this.total = total;
        this.itens = itens;
    }

    public List<NovoPedidoItemRequest> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "NovoPedidoRequest{" +
                "total=" + total +
                ", itens=" + itens +
                '}';
    }
}
