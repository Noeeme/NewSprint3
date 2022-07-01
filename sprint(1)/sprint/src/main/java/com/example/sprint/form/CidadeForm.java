package com.example.sprint.form;

import com.example.sprint.modelo.Cidade;
import com.example.sprint.modelo.Regiao;
import com.example.sprint.repository.CidadeRepository;
import com.sun.istack.NotNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CidadeForm {
    @NotNull
    private String nome;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Regiao regiao;
    @NotNull
    private int populacao;
    @NotNull
    private String capital;
    @NotNull
    private int area;


    public String getNome() {
        return nome;
    }

    public CidadeForm setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public CidadeForm setRegiao(Regiao regiao) {
        this.regiao = regiao;
        return this;
    }

    public int getPopulacao() {
        return populacao;
    }

    public CidadeForm setPopulacao(int populacao) {
        this.populacao = populacao;
        return this;
    }

    public String getCapital() {
        return capital;
    }

    public CidadeForm setCapital(String capital) {
        this.capital = capital;
        return this;
    }

    public int getArea() {
        return area;
    }

    public CidadeForm setArea(int area) {
        this.area = area;
        return this;
    }

    public Cidade converter(CidadeRepository cidadeRepository) {

        return new Cidade(nome, regiao, populacao, capital,area);
    }
}
