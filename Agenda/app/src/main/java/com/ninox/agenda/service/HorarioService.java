package com.ninox.agenda.service;

import com.ninox.agenda.model.Horario;
import com.ninox.agenda.model.Sala;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HorarioService {

    @GET("/horario")
    Call<List<Horario>> buscarHorarios();

}
