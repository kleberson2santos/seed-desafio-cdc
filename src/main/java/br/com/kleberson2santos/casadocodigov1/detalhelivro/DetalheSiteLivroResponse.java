package br.com.kleberson2santos.casadocodigov1.detalhelivro;

import br.com.kleberson2santos.casadocodigov1.cadastrolivro.Livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetalheSiteLivroResponse {
    private final DetalheSiteAutorResponse autor;
    private final String titulo;
    private final String isbn;
    private final int numeroPaginas;
    private final BigDecimal preco;
    private final String resumo;
    private final String sumario;
    private final String dataPublicacao;

    public DetalheSiteLivroResponse(Livro livroBuscado) {
        autor = new DetalheSiteAutorResponse(livroBuscado.getAutor());
        titulo = livroBuscado.getTitulo();
        isbn = livroBuscado.getIsbn();
        numeroPaginas = livroBuscado.getNumeroPaginas();
        preco = livroBuscado.getPreco();
        resumo = livroBuscado.getResumo();
        sumario = livroBuscado.getSumario();
        dataPublicacao = livroBuscado.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public DetalheSiteAutorResponse getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }
}
