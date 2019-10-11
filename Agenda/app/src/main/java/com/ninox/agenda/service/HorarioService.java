package com.ninox.agenda.service;

import com.ninox.agenda.model.Horario;
import com.ninox.agenda.model.Sala;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HorarioService {

    @GET("/api/ms-agedanmento/agendamento/horarios-disponiveis")
    Call<List<Horario>> buscarHorarios(@Header("token") String token, @Query("data") String data, @Query("idSala")String idSala);

}
