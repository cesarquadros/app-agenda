package com.ninox.agenda.model;

import java.io.Serializable;
import java.util.Date;

public class AgendamentoDTO implements Serializable {

    private String cpfCliente;
    private String dataAgendamento;
    private Status status;
    private String hora;
    private String idSala;

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
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

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public enum Status {ABERTO,FINALIZADO,CANCELADO}
}
