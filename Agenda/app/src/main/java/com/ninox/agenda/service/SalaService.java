package com.ninox.agenda.service;

import retrofit2.Call;
import retrofit2.http.GET;

import com.ninox.agenda.model.Sala;

import java.util.List;

public interface SalaService {

    @GET("/v2/5d9d3c19310000640050e18d")
    Call<List<Sala>> buscarSalas();

}
