package br.com.kleberson2santos.casadocodigov1.fechamentocompra;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private @NotNull @Valid final Compra compra;
    @ElementCollection
    private @Size(min = 1) final Set<ItemPedido> itens = new HashSet<>();

    public Pedido(@NotNull @Valid Compra compra,
                  @Size(min = 1) Set<ItemPedido> itens) {
        Assert.isTrue(!itens.isEmpty(), "todo pedido deve ter pelo menos um item");
        this.compra = compra;
        this.itens.addAll(itens);
    }

    public boolean totalIgual(@Positive @NotNull BigDecimal total) {
        BigDecimal totalPedido = itens.stream().map(ItemPedido::total)
                .reduce(BigDecimal.ZERO, (atual, proximo) -> atual.add(proximo));
        return totalPedido.doubleValue() == total.doubleValue();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "itens=" + itens +
                '}';
    }
}
