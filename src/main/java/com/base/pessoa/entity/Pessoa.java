package com.base.pessoa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "Pessoa")
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "PAI")
    private Pessoa pai;

    @ManyToMany(cascade={CascadeType.PERSIST})
    @JoinTable(name="pessoas_caracteristicas",
            joinColumns={@JoinColumn(name="idPessoa")},
            inverseJoinColumns={@JoinColumn(name="id")})
    private Set<Caracteristica> caracteristicas = new HashSet<>();

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, Set<Caracteristica> caracteristicas) {
        this.id = id;
        this.nome = nome;
        this.caracteristicas = caracteristicas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa getPai() {
        return pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }

    public Set<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        return id != null ? id.equals(pessoa.id) : pessoa.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
