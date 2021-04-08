package br.com.kleberson2santos.casadocodigov1.fechamentocompra;

import br.com.kleberson2santos.casadocodigov1.compartilhada.Documento;
import br.com.kleberson2santos.casadocodigov1.paisestado.Estado;
import br.com.kleberson2santos.casadocodigov1.paisestado.Pais;
import org.springframework.util.Assert;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Compra {
    @Email
    @NotBlank
    private final String email;
    @NotBlank
    private final String nome;
    @NotBlank
    private final String sobrenome;
    @NotBlank
    @Documento
    private final String documento;
    @NotBlank
    private final String endereco;
    @NotBlank
    private final String complemento;
    @NotNull
    @ManyToOne
    private final Pais pais;
    @NotBlank
    private final String telefone;
    @NotBlank
    private final String cep;
    @ManyToOne
    private Estado estado;

    public Compra(@Email @NotBlank String email, @NotBlank String nome,
                  @NotBlank String sobrenome, @NotBlank @Documento String documento,
                  @NotBlank String endereco, @NotBlank String complemento, @NotNull Pais pais,
                  @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setEstado(@NotNull @Valid Estado estado) {
        Assert.notNull(pais, "Não rola associar um estado enquanto o pais for nulo");
        Assert.isTrue(estado.pertenceAPais(pais), "Este estado não é do país associado a compra");
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", pais=" + pais +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", estado=" + estado +
                '}';
    }
}
