package com.example.approfisso.domain;

import java.util.Objects;

public class Empregos {
    private String nome;
    private Integer quantidade;
    private Double valor;
    private Integer id;


    @Override
    public String toString() {
        return nome+" - " + quantidade ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empregos empregos = (Empregos) o;
        return Objects.equals(id, empregos.id);
    }




}
