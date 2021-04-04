package br.com.kleberson2santos.casadocodigov1.detalhelivro;

import br.com.kleberson2santos.casadocodigov1.novoautor.Autor;

public class DetalheSiteAutorResponse {
    private final String nome;
    private final String descricao;

    public DetalheSiteAutorResponse(Autor autor) {
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
