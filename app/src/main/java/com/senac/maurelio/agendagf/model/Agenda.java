package com.senac.maurelio.agendagf.model;

import android.content.ContentValues;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class Agenda implements Serializable {

    public String id_agenda;
    public String agenda_titulo;
    public String agenda_url;
    public String agenda_descricao;
    public String agenda_data_inicio;
    public String agenda_data_fim;
    public String agenda_valores;
    public String agenda_url_imagem;
    public String nomeCategoria;
    public String local_id_local;

    private int imageResId;

    Categoria categoria;
    Local local;
    ArrayList<Categoria> categorias;

    public Agenda(String agenda_titulo, String nomeCategoria, int imageResId) {
        this.agenda_titulo = agenda_titulo;
        this.nomeCategoria = nomeCategoria;
        this.imageResId = imageResId;
    }

    public Agenda(String agenda_titulo, String agenda_descricao, String agenda_data_inicio, String nomeCategoria) {
        this.agenda_titulo = agenda_titulo;
        this.agenda_descricao = agenda_descricao;
        this.agenda_data_inicio = agenda_data_inicio;
        this.nomeCategoria = nomeCategoria;
    }

    public Agenda(String id_agenda, String agenda_titulo) {
        this.id_agenda = id_agenda;
        this.agenda_titulo = agenda_titulo;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }




    public Agenda(Categoria categoria) {
        this.categoria = categoria;
    }

    public Agenda() {
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(String id_agenda) {
        this.id_agenda = id_agenda;
    }

    public String getAgenda_titulo() {
        return agenda_titulo;
    }

    public void setAgenda_titulo(String agenda_titulo) {
        this.agenda_titulo = agenda_titulo;
    }

    public String getAgenda_url() {
        return agenda_url;
    }

    public void setAgenda_url(String agenda_url) {
        this.agenda_url = agenda_url;
    }

    public String getAgenda_descricao() {
        return agenda_descricao;
    }

    public void setAgenda_descricao(String agenda_descricao) {
        this.agenda_descricao = agenda_descricao;
    }

    public String getAgenda_data_inicio() {
        return agenda_data_inicio;
    }

    public void setAgenda_data_inicio(String agenda_data_inicio) {
        this.agenda_data_inicio = agenda_data_inicio;
    }

    public String getAgenda_data_fim() {
        return agenda_data_fim;
    }

    public void setAgenda_data_fim(String agenda_data_fim) {
        this.agenda_data_fim = agenda_data_fim;
    }

    public String getAgenda_valores() {
        return agenda_valores;
    }

    public void setAgenda_valores(String agenda_valores) {
        this.agenda_valores = agenda_valores;
    }

    public String getAgenda_url_imagem() {
        return agenda_url_imagem;
    }

    public void setAgenda_url_imagem(String agenda_url_imagem) {
        this.agenda_url_imagem = agenda_url_imagem;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "agenda_titulo='" + agenda_titulo + '\'' +
                ", agenda_descricao='" + agenda_descricao + '\'' +
                ", agenda_data_inicio=" + agenda_data_inicio +
                ", local=" + local +
                '}';
    }

    public ContentValues getContentValues(){
        ContentValues valores = new ContentValues();
        valores.put("agenda_titulo", this.getAgenda_titulo());
        valores.put("data", String.valueOf(this.getAgenda_data_inicio()));
        valores.put("agenda_url_imagem", this.getAgenda_url_imagem());
        valores.put("categoria", this.getCategoria().getNome());
        return valores;
    }

    private Drawable drawable;
    public Drawable getDrawable(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream inputStream = (InputStream) new URL(getAgenda_url_imagem()).getContent();
                    drawable = Drawable.createFromStream(inputStream, "src name");
                } catch (IOException e) {
                    System.out.print("Erro: "+e.getMessage());
                    drawable = null;
                }
            }
        }).start();
        return drawable;
    }



}
