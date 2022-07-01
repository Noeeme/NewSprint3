package com.example.sprint.form;

import com.example.sprint.modelo.Cidade;
import com.example.sprint.repository.CidadeRepository;
import com.sun.istack.NotNull;

public class AtualizacaoCidadeForm {

    @NotNull
    private int populacao;

    @NotNull
    private int area;

    public int getPopulacao() {
        return populacao;
    }

    public AtualizacaoCidadeForm setPopulacao(int populacao) {
        this.populacao = populacao;
        return this;
    }

    public int getArea() {
        return area;
    }

    public AtualizacaoCidadeForm setArea(int area) {
        this.area = area;
        return this;
    }

    public Cidade atualizar(Long id, CidadeRepository cidadeRepository) {
        Cidade cidade = cidadeRepository.getReferenceById(id);
        cidade.setArea(this.area);
        cidade.setPopulacao(this.populacao);

        return cidade;
    }
}
