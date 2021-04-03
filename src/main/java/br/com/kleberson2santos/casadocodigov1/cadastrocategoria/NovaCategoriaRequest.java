package br.com.kleberson2santos.casadocodigov1.cadastrocategoria;

import javax.validation.constraints.NotBlank;

import br.com.kleberson2santos.casadocodigov1.compartilhada.UniqueValue;

public class NovaCategoriaRequest {
    @Deprecated
    NovaCategoriaRequest(){}

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public NovaCategoriaRequest(@NotBlank String nome) {
        super();
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
