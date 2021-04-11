package br.com.kleberson2santos.casadocodigov1.fechamentocompra;

import br.com.kleberson2santos.casadocodigov1.compartilhada.Documento;
import br.com.kleberson2santos.casadocodigov1.compartilhada.ExistsId;
import br.com.kleberson2santos.casadocodigov1.paisestado.Estado;
import br.com.kleberson2santos.casadocodigov1.paisestado.Pais;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.function.Function;

public class NovaCompraRequest {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @Documento
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldId = "id")
    private Long idPais;
    @ExistsId(domainClass = Estado.class, fieldId = "id")
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @Valid
    @NotNull
    private NovoPedidoRequest pedido;

    public NovaCompraRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
                             @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                             @NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
                             @NotBlank String cep,
                             @NotNull @Valid NovoPedidoRequest pedido) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = pedido;
    }

    public String getDocumento() {
        return documento;
    }

    public NovoPedidoRequest getPedido() {
        return pedido;
    }

    public boolean documentoValido() {
        Assert.hasLength(documento, "você não deveria validar o documento se ele não tiver sido preenchido");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);
    }

    @Override
    public String toString() {
        return "NovaCompraRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", pedido=" + pedido +
                '}';
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public Compra toModel(EntityManager manager) {
        @NotNull Pais pais = manager.find(Pais.class, idPais);
        Function<Compra, Pedido> funcaoCriacaoPedido = pedido.toModel(manager);
        Compra compra = new Compra(email, nome, sobrenome, documento, endereco, complemento,
                pais, telefone, cep, funcaoCriacaoPedido);
        if ( idEstado != null){
            compra.setEstado(manager.find(Estado.class, idEstado));
        }



        return compra;
    }

    public boolean temEstado() {
        return idEstado != null;
    }

    public boolean naoTemEstado() {
        return !temEstado();
    }

    public boolean temPais(){
        return idPais != null;
    }
}
