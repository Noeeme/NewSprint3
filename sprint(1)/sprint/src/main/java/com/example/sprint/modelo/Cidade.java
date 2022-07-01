package com.example.sprint.modelo;

import javax.persistence.*;

@Entity
public class Cidade {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Regiao regiao;
    private int populacao;
    private String capital;
    private int area;

    public Cidade(){

}
    public Cidade( String nome, Regiao regiao, int populacao, String capital, int area) {
        this.nome = nome;
        this.regiao = regiao;
        this.populacao = populacao;
        this.capital = capital;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public Cidade setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cidade setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public Cidade setRegiao(Regiao regiao) {
        this.regiao = regiao;
        return this;
    }

    public int getPopulacao() {
        return populacao;
    }

    public Cidade setPopulacao(int populacao) {
        this.populacao = populacao;
        return this;
    }

    public String getCapital() {
        return capital;
    }

    public Cidade setCapital(String capital) {
        this.capital = capital;
        return this;
    }

    public int getArea() {
        return area;
    }

    public Cidade setArea(int area) {
        this.area = area;
        return this;
    }
}
