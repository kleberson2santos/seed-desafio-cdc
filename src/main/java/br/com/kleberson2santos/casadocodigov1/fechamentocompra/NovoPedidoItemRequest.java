package br.com.kleberson2santos.casadocodigov1.fechamentocompra;

import br.com.kleberson2santos.casadocodigov1.cadastrolivro.Livro;
import br.com.kleberson2santos.casadocodigov1.compartilhada.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovoPedidoItemRequest {

    @NotNull
    @ExistsId(domainClass = Livro.class, fieldId = "id")
    private Long idLivro;
    @Positive
    private int quantidade;

    NovoPedidoItemRequest(@NotNull Long idLivro, @Positive int quantidade){
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    //usado para o ExistsId
    public Long getIdLivro() {
        return idLivro;
    }

    @Override
    public String toString() {
        return "NovoPedidoItemRequest{" +
                "idLivro=" + idLivro +
                ", quantidade=" + quantidade +
                '}';
    }

    public ItemPedido toModel(EntityManager manager) {
        @NotNull Livro livro = manager.find(Livro.class, idLivro);
        return new ItemPedido(livro, quantidade);
    }
}
