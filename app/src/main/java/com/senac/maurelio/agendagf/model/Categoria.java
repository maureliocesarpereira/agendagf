package com.senac.maurelio.agendagf.model;


import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable{

    private int id;
    private String nome;
    private String url;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public ArrayList<Categoria> pegarArrayCategorias(){
        ArrayList<Categoria> categoriaArrayList = new ArrayList<>();
        this.setNome("Festa");
        categoriaArrayList.add(this);
        this.setNome("Show");
        categoriaArrayList.add(this);
        this.setNome("Teatro");
        categoriaArrayList.add(this);
        return categoriaArrayList;
    }
}
