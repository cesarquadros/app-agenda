package com.ninox.agenda.service;

import com.ninox.agenda.model.AgendamentoDTO;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AgendamentoService {

    @POST("/api/ms-agendamento/agendamento")
    Call<Void> agendar(@Header("token") String token, @Body AgendamentoDTO agendamentoDTO);

}
