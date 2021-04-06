package br.com.kleberson2santos.casadocodigov1.paisestado;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String nome;
    @ManyToOne
    private @NotNull @Valid Pais pais;

    public Estado(@NotBlank String nome, @NotNull @Valid Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }
}