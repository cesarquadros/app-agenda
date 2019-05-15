package com.ninox.agenda.model;

import java.util.ArrayList;
import java.util.List;

public class Sala {

    private String nome;
    private String descricao;
    private List<Sala> salas;

    public List<Sala> getSalas(){
        return this.salas;
    }

    public Sala() {
    }

    public Sala(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void inicializar(){
        salas = new ArrayList<>();
        salas.add(new Sala("Sala 1", "Uma mesa, uma cadeiras"));
        salas.add(new Sala("Sala 2", "Uma duas, duas cadeiras"));
        salas.add(new Sala("Sala 3", "Uma tres, tres cadeiras"));
        salas.add(new Sala("Sala 4", "Uma quatro, quatro cadeiras"));
    }

    @Override
    public String toString() {
        return "Sala{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", salas=" + salas +
                '}';
    }
}
