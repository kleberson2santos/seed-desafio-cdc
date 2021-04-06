package br.com.kleberson2santos.casadocodigov1.paisestado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
    @Deprecated
    public Pais() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    public Pais(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}