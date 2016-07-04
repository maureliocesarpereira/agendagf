package com.senac.maurelio.agendagf.controller;

import com.senac.maurelio.agendagf.model.Agenda;

import java.util.List;

/**
 * Created by home on 03/07/2016.
 */

public class ListaDeAgendas {

    public List<Agenda> agendas;

    public ListaDeAgendas() {
    }

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }
}
