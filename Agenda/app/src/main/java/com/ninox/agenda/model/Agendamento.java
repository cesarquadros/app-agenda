package com.ninox.agenda.model;

import java.io.Serializable;
import java.util.Date;

public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Cliente cliente;
    private Date dataAgendamento;
    private Status status;
    private String hora;
    private Sala sala;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public enum Status {ABERTO,FINALIZADO,CANCELADO}
}
