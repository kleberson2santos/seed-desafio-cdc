package br.com.kleberson2santos.casadocodigov1.paisestado;

import br.com.kleberson2santos.casadocodigov1.compartilhada.ExistsId;
import br.com.kleberson2santos.casadocodigov1.compartilhada.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoResquest {
    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldId = "id")
    private Long idPais;

    public NovoEstadoResquest(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    @Override
    public String toString() {
        return "NovoEstadoResquest{" +
                "nome='" + nome + '\'' +
                ", idPais=" + idPais +
                '}';
    }


    public Estado toModel(EntityManager manager) {
        return new Estado(nome, manager.find(Pais.class, idPais));
    }
}
