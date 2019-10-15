package com.ninox.agenda.service;

import com.ninox.agenda.model.Agendamento;
import com.ninox.agenda.model.AgendamentoDTO;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AgendamentoService {

    @POST("/api/ms-agendamento/agendamento")
    Call<Agendamento> agendar(@Header("token") String token, @Body AgendamentoDTO agendamentoDTO);

    @GET("/api/ms-agendamento/agendamento/filtro")
    Call<List<Agendamento>> getAgendamentosByCliente(@Header("token") String token, @Query("cpfCliente") String cpfCliente);
}
