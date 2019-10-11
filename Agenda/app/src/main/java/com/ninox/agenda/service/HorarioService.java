package com.ninox.agenda.service;

import com.ninox.agenda.model.Horario;
import com.ninox.agenda.model.Sala;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface HorarioService {

    @GET("/api/ms-horario")
    Call<List<Horario>> buscarHorarios(@Header("token") String token);

}
