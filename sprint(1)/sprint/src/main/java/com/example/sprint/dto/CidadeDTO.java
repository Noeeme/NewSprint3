package com.example.sprint.dto;

import com.example.sprint.modelo.Cidade;
import com.example.sprint.modelo.Regiao;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class CidadeDTO {
    private Long id;
    private String nome;
    private Regiao regiao;
    private int populacao;
    private String capital;
    private int area;

    public CidadeDTO(Cidade cidade){
        this.id = cidade.getId();
        this.nome = cidade.getNome();
        this.regiao = cidade.getRegiao();
        this.populacao = cidade.getPopulacao();
        this.capital = cidade.getCapital();
        this.area = cidade.getArea();
    }

    public static Page<CidadeDTO> converter(Page<Cidade> cidades) {
        return cidades.map(CidadeDTO::new);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public int getPopulacao() {
        return populacao;
    }

    public String getCapital() {
        return capital;
    }

    public int getArea() {
        return area;
    }
}
