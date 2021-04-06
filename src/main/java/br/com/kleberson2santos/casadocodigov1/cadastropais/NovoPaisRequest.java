package br.com.kleberson2santos.casadocodigov1.cadastropais;

import br.com.kleberson2santos.casadocodigov1.compartilhada.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {
    @Deprecated
    public NovoPaisRequest() {
    }

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public NovoPaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public Pais toModel(EntityManager manager) {
        return manager.createQuery("from Pais p where p.nome=:nome", Pais.class)
                .setParameter("nome", this.nome)
                .getResultList().stream().findFirst().orElse(new Pais(nome));
    }

    public String getNome() {
        return nome;
    }

}
