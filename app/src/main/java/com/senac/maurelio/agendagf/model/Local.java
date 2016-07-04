package com.senac.maurelio.agendagf.model;


import java.io.Serializable;
import java.util.ArrayList;

public class Local implements Serializable {

    private int id;
    private String nome;
    private String urlGuia;
    private String endereco;
    private String bairro;
    private String telefone;
    private String urlImagem;
    private String descricao;
    private ArrayList<Agenda> agendasDoLocal;

    public Local() {
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

    public String getUrlGuia() {
        return urlGuia;
    }

    public void setUrlGuia(String urlGuia) {
        this.urlGuia = urlGuia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Agenda> getAgendasDoLocal() {
        return agendasDoLocal;
    }

    public void setAgendasDoLocal(ArrayList<Agenda> agendasDoLocal) {
        this.agendasDoLocal = agendasDoLocal;
    }

    @Override
    public String toString() {
        return "Local{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", bairro='" + bairro + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
