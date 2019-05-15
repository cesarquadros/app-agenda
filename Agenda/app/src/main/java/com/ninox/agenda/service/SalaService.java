package com.ninox.agenda.service;

import retrofit2.Call;
import retrofit2.http.GET;

import com.ninox.agenda.model.Sala;

import java.util.List;

public interface SalaService {

    @GET("salas")
    Call<List<Sala>> buscarSalas();

}